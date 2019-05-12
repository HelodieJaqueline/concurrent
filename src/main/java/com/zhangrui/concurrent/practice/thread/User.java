package com.zhangrui.concurrent.practice.thread;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String phone;

    private String qq;

    private String email;
}
