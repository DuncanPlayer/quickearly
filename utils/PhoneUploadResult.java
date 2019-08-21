package net.messi.early.utils;

public class PhoneUploadResult {

    // 响应业务状态
    private Integer code = 0;

    // 响应消息
    private String msg = "";

    // 响应中的数据
    private Object data;

    public PhoneUploadResult(Object data) {
        this.code = 0;
        this.msg = "OK";
        this.data = data;
    }

    public static PhoneUploadResult ok(Object data) {
        return new PhoneUploadResult(data);
    }
}
