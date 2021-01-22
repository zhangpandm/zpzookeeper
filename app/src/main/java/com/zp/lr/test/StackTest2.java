package com.zp.lr.test;

import org.junit.Test;


import java.util.Stack;

/**
 * @Auther: zhangpanm
 * @Date: 2021/1/4
 * @Description:
 *
 *
 *
 */
public class StackTest2 {
    /**
     *
     * @param path
     * @return
     * 示例 1：

    输入："/home/"
    输出："/home"
    解释：注意，最后一个目录名后面没有斜杠。

    示例 2：

    输入："/../"
    输出："/"
    解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。

    示例 3：

    输入："/home//foo/"
    输出："/home/foo"
    解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

    示例 4：

    输入："/a/./b/../../c/"
    输出："/c"

    示例 5：

    输入："/a/../../b/../c//.//"
    输出："/c"

    示例 6：

    输入："/a//b////c/d//././/.."
    输出："/a/b/c"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/simplify-path
     */
    public String simplifyPath(String path) {
        String[] p= path.split("/");

        Stack<String> st = new Stack<>();
        for(String s : p){
            if(s.equals("..")){
                if(!st.empty())
                    st.pop();
            }else if(s.equals(".")||s.isEmpty()){
                continue;
            }else {
                st.push(s);
            }
        }
        String res ="";
        for(String s : st){
            res+="/"+s;
        }
        return res.isEmpty() ? "/":res;
    }
    @Test
    public void test(){
        System.out.println( simplifyPath("/a/../../b/../c//.//"));
        System.out.println( simplifyPath("/../"));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * height = [0,1,0,2,1,0,1,3,2,1,2,1]
     输出：6
     解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

     来源：力扣（LeetCode）

     * @param height
     * @return
     */
    public int trap(int[] height) {
        return 0;
    }
}
