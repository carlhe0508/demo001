package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_user")//code11
public class SysUser implements java.io.Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "userId", unique = true, nullable = false, length = 32)
    private String userId;
    @Column(name = "name", length = 120)
    private String name; //用户名
    @Column(name = "email", length = 50)
    private String email;//用户邮箱
    @Column(name = "password", length = 120)
    private String password;//用户密码
    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;//时间

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

    public SysUser() {
    }

    public SysUser(String name, String email, String password, Date dob, Set<SysRole> SysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.SysRoles = SysRoles;
    }

    public SysUser(String name, String email, String password, Date dob) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
    public Set<SysRole> getSysRoles() {
        return this.SysRoles;
    }

    public void setSRoles(Set<SysRole> SysRoles) {
        this.SysRoles = SysRoles;
    }

}
