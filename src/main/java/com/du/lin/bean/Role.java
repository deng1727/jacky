package com.du.lin.bean;

public class Role {
    private Integer id;

    private String roles;

    private String tips;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", roles=" + roles + ", tips=" + tips + "]";
	}
    
    
    
}