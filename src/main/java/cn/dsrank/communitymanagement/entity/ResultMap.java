package cn.dsrank.communitymanagement.entity;

import lombok.Data;

@Data
public class ResultMap<T> {
    private Integer code;
    private String msg;
    private T data;

}
