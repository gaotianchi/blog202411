package com.gaotianchi.backend.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    private R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<>(0, "success", null);
    }

    public static <T> R<T> success(T data) {
        return new R<>(0, "success", data);
    }

    public static <T> R<T> error() {
        return new R<>(1, "error", null);
    }

    public static <T> R<T> error(String message) {
        return new R<>(1, message, null);
    }
}
