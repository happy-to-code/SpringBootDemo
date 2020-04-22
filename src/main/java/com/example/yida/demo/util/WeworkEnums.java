package com.example.yida.demo.util;

import javassist.expr.Instanceof;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class WeworkEnums {

    /**
     * 企业微信会话存档业务类型
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum BusinessType {

        /**
         * 售前
         */
        PRESALE("售前"),

        /**
         * 售后回访
         */
        REVISIT("回访"),

        /**
         * 售后邀约
         */
        RESELL("邀约"),

        /**
         * 其他类型
         */
        OTHER("其他"),
        ;

        @Getter
        private String value;
    }

    /**
     * 企业微信好友添加状态 已添加/已通过/已删除
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum FriendshipStatus {

        /**
         * 已添加好友，但对方尚未通过好友验证
         */
        ADDED("已添加"),

        /**
         * 对方已通过好友验证
         */
        CONFIRMED("已通过"),

        /**
         * 已验证通过的好友，一方删除了另一方
         */
        DELETED("已删除"),

        /**
         * 从未添加过
         */
        TO_ADD("未添加"),

        ;

        @Getter
        private String value;
    }

    /**
     * 企业微信聊天人员类型 CC坐席/售后专员/销售经理/客户
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum RoleType {

        /**
         * CC坐席
         */
        CC("CC坐席"),

        /**
         * 销售SA
         */
        SA("售后专员"),

        /**
         * 销售SC
         */
        SC("销售经理"),
        /**
         * 客户
         */
        CUSTOMER("客户"),
        ;

        @Getter
        private String value;
    }

    public static void main(String[] args) {
        System.out.println(BusinessType.REVISIT.name());

        // BusinessType businessType
        // RESELL
        System.out.println(BusinessType.REVISIT);
        BusinessType resell = BusinessType.valueOf("RESELL");

        System.out.println("------------------");
        String name = FriendshipStatus.CONFIRMED.name();
        System.out.println(FriendshipStatus.CONFIRMED.name());


    }
}
