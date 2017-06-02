package com.tneciv.poseidon.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@NoArgsConstructor
public class ResponseWrapper<T> implements Serializable {

    private static final long serialVersionUID = -4532048060066823936L;
    
    private boolean succ = true;
    private String msg;
    private T content;
    private final Map<String, Object> options = new HashMap<>();

    public static <T> ResponseWrapper<T> success(String msg, T object) {
        return new ResponseWrapper<T>(true, msg, object);
    }

    public static <T> ResponseWrapper<T> success(T object) {
        return new ResponseWrapper<>(true, Constant.DEF_SUCC_MSG, object);
    }

    public static <T> ResponseWrapper<T> success(String msg) {
        return new ResponseWrapper<>(true, msg, null);
    }

    public static <T> ResponseWrapper<T> success() {
        return success(Constant.DEF_SUCC_MSG);
    }

    public static <T> ResponseWrapper<T> fail(String msg) {
        return new ResponseWrapper<>(false, msg, null);
    }

    public static <T> ResponseWrapper<T> fail() {
        return fail(Constant.DEF_FAIL_MSG);
    }

    public static <T> ResponseWrapper<T> fail(String msg, Exception e) {
        if (e instanceof ApplicationException
                || e instanceof IllegalArgumentException) {
            return new ResponseWrapper<>(false, e.getMessage(), null);
        } else {
            return fail(CommonUtil.parseException2Str(e));
        }
    }

    public static <T> ResponseWrapper<T> fail(Exception e) {
        return fail(Constant.DEF_FAIL_MSG, e);
    }

    public ResponseWrapper(boolean succ) {
        this();
        this.succ = succ;
    }

    public ResponseWrapper(boolean succ, String msg) {
        this(succ);
        this.msg = msg;
    }

    public ResponseWrapper(boolean succ, String msg, T content) {
        this(succ, msg);
        this.content = content;
    }

    public ResponseWrapper addOption(String key, Object value) {
        options.put(key, value);
        return this;
    }

    public <T> T getOptionValue(String key) {
        return (T) options.get(key);
    }

    public boolean hasValueInOption(String key) {
        return options.containsKey(key);
    }

}
