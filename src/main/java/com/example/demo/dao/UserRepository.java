package com.example.demo.dao;

import com.example.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer> {

    SysUser findSysUserByName(String userName);
}
