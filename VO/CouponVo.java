package net.messi.early.VO;


import java.io.Serializable;
import java.util.List;

public class CouponVo implements Serializable {

    private Integer code;
    private String msg;
    private Integer count;
    private List<LimitCouponVo> data;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<LimitCouponVo> getData() {
        return data;
    }

    public void setData(List<LimitCouponVo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CouponVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
