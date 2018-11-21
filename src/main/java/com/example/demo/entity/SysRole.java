package com.example.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_role")
public class SysRole {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "roleId", unique = true, nullable = false, length = 32)
    private String roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    private SysUser SUser;//角色对应的用户实体

    @Column(name = "name", length = 100)
    private String name;//角色名称

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysUser getSUser() {
        return SUser;
    }

    public void setSUser(SysUser sUser) {
        SUser = sUser;
    }

    public SysRole(SysUser SUser, String name) {
        this.SUser = SUser;
        this.name = name;
    }

    public SysRole() {
    }
}

