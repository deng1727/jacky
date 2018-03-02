package com.du.lin.bean;

public class Memo {
    private Integer id;

    private String title;

    private String text;

    private String time;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public Memo() {
    	super();
	}
    
    
    
    
    public Memo(String title, String text, String time, Integer userid) {
		super();
		this.title = title;
		this.text = text;
		this.time = time;
		this.userid = userid;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}