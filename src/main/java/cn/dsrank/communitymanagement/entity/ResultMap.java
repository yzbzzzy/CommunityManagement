package cn.dsrank.communitymanagement.entity;

import lombok.Data;

@Data
public class ResultMap<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultMap(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultMap() {
    }

    public ResultMap(T t) {
        this.data=t;
    }
}
