package com.test.pojo;

import com.test.dao.DBOper;

public class Test {
    public static void main(String[] args) {
        new DBOper().RegUsers("张三","123456","123456");
    }
}
