package com.zjf.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("测试断言")
public class AssertionsTest {


    /**
     * 断言：前面的断言失败，后面的代码就不会执行了
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(2,3);
        //相等
//        assertEquals(2,cal,"计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    @Test
    @DisplayName("array assertions")
    public void array(){
        assertArrayEquals(new int[]{2,1},new int[]{1,2},"数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    public void all(){
        /**
         * 所有断言全部成功
         */
        assertAll("test",
                ()-> assertTrue(true && true,"不为true"),
                ()-> assertEquals(1,2,"结果不是1"));
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        //断定业务逻辑一定正常
        assertThrows(ArithmeticException.class,()->{int i = 10/1;},"数学正常运行");
    }

    @Test
    @DisplayName("快速失败")
    void testFail(){

        fail("测试失败");

    }

    int cal(int i,int j){
        return i+j;
    }
}
