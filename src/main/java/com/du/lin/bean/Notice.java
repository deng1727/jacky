package com.du.lin.bean;

import java.util.Date;

public class Notice {
    private Integer id;

    private String title;

    private String body;

    private String message;

    private Integer senduserid;

    private String type;

    private Date createtime;

    private Integer recivedeptid;

    private Integer reciveuserid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(Integer senduserid) {
        this.senduserid = senduserid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRecivedeptid() {
        return recivedeptid;
    }

    public void setRecivedeptid(Integer recivedeptid) {
        this.recivedeptid = recivedeptid;
    }

    public Integer getReciveuserid() {
        return reciveuserid;
    }

    public void setReciveuserid(Integer reciveuserid) {
        this.reciveuserid = reciveuserid;
    }
}