package com.ygz.library.pojo;

import lombok.Data;

@Data
public class Reader {
    private int id;
    private String name;
    private String sex;
    private String phone;
    private String department;
    private String registerDate;
    private String lendableTime;

}
