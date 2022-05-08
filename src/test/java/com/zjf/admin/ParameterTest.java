package com.zjf.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@DisplayName("参数化测试")
public class ParameterTest {

    @ParameterizedTest
    @DisplayName("参数化测试1")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterized1(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化测试2")
    @MethodSource("stringStream")
    void testParameterized2(String i){
        System.out.println(i);
    }

    static Stream<String> stringStream(){
        return Stream.of("apple","banana");
    }
}
