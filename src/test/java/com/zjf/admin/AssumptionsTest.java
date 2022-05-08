package com.zjf.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTest {

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testAssumptionTest(){
        assumeTrue(false,"结果不是true");
        System.out.println(1);
    }
}
