package com.example.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_resource")
public class SysResource {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "sourceId", unique = true, nullable = false, length = 32)
    private String sourceId;

    @Column(name = "resourceString", length = 1000)
    private String resourceString;//url

    @Column(name = "resourceId", length = 50)
    private String resourceId;//资源ID

    @Column(name = "remark", length = 200)
    private String remark;//备注

    @Column(name = "resourceName", length = 400)
    private String resourceName;//资源名称

    @Column(name = "methodName", length = 400)
    private String methodName;//资源所对应的方法名

    @Column(name = "methodPath", length = 1000)
    private String methodPath;//资源所对应的包路径

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }


}

