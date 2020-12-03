package com.zp.lr;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: zhangpanm
 * @Date: 2020/10/29
 * @Description:
 */
public class Test8 {

    @Test
    public void testStream(){

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        strings.forEach(System.out::println);
        List<String> notStrings =strings.stream().filter(s-> !s.isEmpty()).collect(Collectors.toList());
        notStrings.forEach(System.out::println);
        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);
    }
}
