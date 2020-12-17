package com.zp.lr.test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Auther: zhangpanm
 * @Date: 2020/12/17
 * @Description:
 */
public class StackTest1 {


    public boolean isValidString(String s){
        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');

        Map<Character,Character> right = new HashMap<>();
        right.put(')','(');
        right.put(']','[');
        right.put('}','{');

        Stack<Character> st = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(left.contains(c)){
                st.push(c);
            }else if(right.containsKey(c)){
                if(st.size()<1||!st.pop().equals(right.get(c))){
                    return false;
                }
            }
        }
        return st.size()==0;
    }

    @Test
    void test1(){
        String str = "sdffs()][";
        System.out.println(isValidString(str));
    }

}
