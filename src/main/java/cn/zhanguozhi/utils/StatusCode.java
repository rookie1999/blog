package cn.zhanguozhi.utils;

public enum StatusCode {
    login_success(0, "正常登录"),
    user_exists(1, "用户已存在");


    private int status;
    private String msg;

    StatusCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
