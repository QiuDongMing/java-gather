package com.qdm.current.thread.demo.demo2.obser;

/**
 * @author qiudm
 * @date 2018/11/21 14:08
 * @desc
 */
public class Result {

    private int resultCode = 100;//COMMON_ERROR

    private String resultMsg;

    private Object data;

    public static Result build(Object data) {
        Result result = new Result();
        result.resultCode = 1;
        result.data = data;
        return result;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean sucess() {
        return resultCode == 1;
    }

}
