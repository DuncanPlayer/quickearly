package net.messi.early.VO;

import java.io.Serializable;

public class ChatInit implements Serializable {

    private Integer code = 0;
    private String msg = "";
    private InitVO data;

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

    public InitVO getData() {
        return data;
    }

    public void setData(InitVO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ChatInit{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
