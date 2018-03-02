package com.du.lin.bean;

import java.util.Date;

/**
 * 业务操作日志
 */
public class OperationLog {
    private Integer id;

    private String logtype;

    private String logname;

    private Integer userid;

    private String classname;

    private String method;

    private Date createtime;

    private String state;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype == null ? null : logtype.trim();
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname == null ? null : logname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

	@Override
	public String toString() {
		return "OperationLog [id=" + id + ", logtype=" + logtype + ", logname=" + logname + ", userid=" + userid
				+ ", classname=" + classname + ", method=" + method + ", createtime=" + createtime + ", state=" + state
				+ ", message=" + message + "]";
	}
    
    
}