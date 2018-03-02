package com.du.lin.bean;

public class Dept {
    private Integer id;

    private Integer num;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "Dept [id=" + id + ", num=" + num + ", name=" + name + "]";
	}
    
    
    
}