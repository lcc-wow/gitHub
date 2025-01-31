package com.lcc.pojo;

public class Result {
    private Integer code;
    private String msg;
    private Object data;
    private Object data1;

    public Result() {}

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, Object data, Object data1) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.data1 = data1;
    }

    public static Result success(){
        return new Result(1, "success", null);
    }

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result success(Object data,Object data1) {
        return new Result(1, "success", data,data1);
    }

    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData1() {
        return data1;
    }

    public void setData1(Object data1) {
        this.data1 = data1;
    }
}
