package com.tneciv.poseidon.common;

import lombok.Data;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Rest请求返回消息信封类
 */
@Data
public class ResEnv<T> {

    private HttpStatus httpStatus;
    private boolean succ = true;
    private String msg;
    private T content;
    private final Map<String, Object> options;

    public static <T> ResEnv<T> success(String msg, T object) {
        return new ResEnv<>(true, msg, object, HttpStatus.OK);
    }

    public static <T> ResEnv<T> success(T object) {
        return new ResEnv<>(true, Constant.DEF_SUCC_MSG, object, HttpStatus.OK);
    }

    public static <T> ResEnv<T> success(T object, HttpStatus httpStatus) {
        return new ResEnv<>(true, Constant.DEF_SUCC_MSG, object, httpStatus);
    }

    public static <T> ResEnv<T> success(String msg, T object, HttpStatus httpStatus) {
        return new ResEnv<>(true, msg, object, httpStatus);
    }

    public static <T> ResEnv<T> success(String msg) {
        return new ResEnv<>(true, msg, HttpStatus.OK);
    }

    public static <T> ResEnv<T> success() {
        return success(Constant.DEF_SUCC_MSG);
    }

    public static <T> ResEnv<T> success(String msg, HttpStatus httpStatus) {
        return new ResEnv<>(true, msg, httpStatus);
    }

    public static <T> ResEnv<T> fail(String msg, HttpStatus httpStatus) {
        return new ResEnv<>(false, msg, httpStatus);
    }

    public static <T> ResEnv<T> fail(HttpStatus httpStatus) {
        return fail(Constant.DEF_FAIL_MSG, httpStatus);
    }

    public static <T> ResEnv<T> fail(String msg, Exception e) {
        if (e instanceof ApplicationException
                || e instanceof IllegalArgumentException) {
            return new ResEnv<>(false, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return fail(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static <T> ResEnv<T> fail(Exception e) {
        return fail(Constant.DEF_FAIL_MSG, e);
    }

    public static <T> ResEnv<T> fail(Exception e, HttpStatus httpStatus) {
        return new ResEnv<>(false, Constant.DEF_FAIL_MSG, httpStatus);
    }

    public ResEnv() {
        options = new HashMap<>();
    }

    public ResEnv(boolean succ, HttpStatus httpStatus) {
        this();
        this.succ = succ;
        this.httpStatus = httpStatus;
    }

    public ResEnv(boolean succ, String msg, HttpStatus httpStatus) {
        this(succ, httpStatus);
        this.msg = msg;
    }

    public ResEnv(boolean succ, String msg, T content, HttpStatus httpStatus) {
        this(succ, msg, httpStatus);
        this.content = content;
        this.httpStatus = httpStatus;
    }

    public ResEnv addOption(String key, Object value) {
        options.put(key, value);
        return this;
    }

    public <T> T getOption(String key) {
        return (T) options.get(key);
    }

    public boolean hasOption(String key) {
        return options.containsKey(key);
    }

}
