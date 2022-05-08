package com.zjf.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

/*@RunWith*/
/*
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith({SpringExtension.class})
 */
@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5Test {

    @DisplayName("测试testDisplayName")
    @Test
    void testDisplayName(){
        System.out.println("1");
    }

    @Disabled
    @DisplayName("测试testDisplayName2")
    @Test
    void testDisplayName2(){
        System.out.println("2");
    }

    //Timeout 超出时间就报错
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @DisplayName("测试testDisplayName3")
    @Test
    void testDisplayName3() throws InterruptedException {
        System.out.println("3");
        Thread.sleep(600);
    }

    @RepeatedTest(5)
    @DisplayName("测试testDisplayName4")
    @Test
    void testDisplayName4() {
        System.out.println("4");
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了");
    }
}
