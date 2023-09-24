package com.example.log_apo_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 1. @ClassName User
 * 2. @Description 用户类
 * 3. @Author huo
 * 4. @Date 2023/9/21 22:52
 */

@Data
@AllArgsConstructor
public class User {
    Integer id;
    String name;
}
