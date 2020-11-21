package com.sirifeng.service;

import com.sirifeng.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ElService {

    public String[] getString() {
        String[] arrs = new String[]{"林圣杰", "雷小桥", "何法霖", "徐伟杰"};
        return arrs;
    }

    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        return list;
    }

    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "李旭华");
        map.put("b", "杨久军");
        map.put("c", "李芮");
        map.put("d", "李凤");
        return map;
    }

    public User getUser() {
        User user = new User("1", "aaa", 123);
        return user;
    }

    public Map<String, User> getUserMap() {
        User user = new User("1", "aaa", 123);
        User user1 = new User("2", "bbb", 123);
        User user2 = new User("3", "ccc", 123);
        Map<String, User> map = new HashMap<>();
        map.put("user1", user);
        map.put("user2", user1);
        map.put("user3", user2);
        return map;

    }

}
