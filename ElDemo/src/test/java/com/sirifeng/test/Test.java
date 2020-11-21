package com.sirifeng.test;

import com.sirifeng.service.ElService;

public class Test {

    @org.junit.Test
    public void test() {
        ElService elService = new ElService();
        String[] str = elService.getString();
        System.out.println(str[0]);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}
