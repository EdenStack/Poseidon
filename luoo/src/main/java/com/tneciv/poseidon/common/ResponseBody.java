package com.tneciv.poseidon.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@NoArgsConstructor
public class ResponseBody<T> {

    private boolean succ = true;
    private String msg;
    private T content;
    private final Map<String, Object> options = new HashMap<>();

    public static <T> ResponseBody<T> success(String msg, T object) {
        return new ResponseBody<>(true, msg, object);
    }

    public static <T> ResponseBody<T> success(T object) {
        return new ResponseBody<>(true, Constant.DEF_SUCC_MSG, object);
    }

    public static <T> ResponseBody<T> success(String msg) {
        return new ResponseBody<>(true, msg, null);
    }

    public static <T> ResponseBody<T> success() {
        return success(Constant.DEF_SUCC_MSG);
    }

    public static <T> ResponseBody<T> fail(String msg) {
        return new ResponseBody<>(false, msg, null);
    }

    public static <T> ResponseBody<T> fail() {
        return fail(Constant.DEF_FAIL_MSG);
    }

    public static <T> ResponseBody<T> fail(String msg, Exception e) {
        if (e instanceof ApplicationException
                || e instanceof IllegalArgumentException) {
            return new ResponseBody<>(false, e.getMessage(), null);
        } else {
            return fail(CommonUtil.parseException2Str(e));
        }
    }

    public static <T> ResponseBody<T> fail(Exception e) {
        return fail(Constant.DEF_FAIL_MSG, e);
    }

    public ResponseBody(boolean succ) {
        this();
        this.succ = succ;
    }

    public ResponseBody(boolean succ, String msg) {
        this(succ);
        this.msg = msg;
    }

    public ResponseBody(boolean succ, String msg, T content) {
        this(succ, msg);
        this.content = content;
    }

    public ResponseBody addOption(String key, Object value) {
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
