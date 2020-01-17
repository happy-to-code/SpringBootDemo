package com.example.yida.demo.util;

import com.example.yida.demo.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2019/12/24
 */
public class BeanUtilTest {
    public static void main(String[] args) {
        // private Long id;
        // private String loginName;
        // private String userName;
        // private String passWord;
        User old = new User("loginName1", "userName1", "123");
        System.out.println(old);

        User new1 = new User();
        System.out.println("new1:before:" + new1);
        BeanUtils.copyProperties(old, new1);
        System.out.println("new1:after:" + new1);
        System.out.println("------------------");
        User new2 = new User();
        new2.setLoginName("wang");
        myCopyProperties(old, new2);
        System.out.println("new2:after:" + new2);

    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void myCopyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
}
