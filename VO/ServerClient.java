package net.messi.early.VO;

import java.io.Serializable;

public class ServerClient implements Serializable {
    private String emit = "play";
    private Object data;

    public String getEmit() {
        return emit;
    }

    public void setEmit(String emit) {
        this.emit = emit;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
