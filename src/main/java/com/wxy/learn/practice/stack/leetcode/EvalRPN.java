package com.wxy.learn.practice.stack.leetcode;

import java.util.Stack;

/**
 *
 根据逆波兰表示法，求表达式的值。

 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

 说明：

 整数除法只保留整数部分。
 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * @author wangxiayun
 * @since 2020/4/14
 **/
public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            // 遍历每个字符串，如果遇到四种运算符就将栈顶前两个元素做对应的运算
            if (s.equals("+")) {
                // 将栈顶前两个元素做“+”运算后的结果再压入栈中
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                // 如果不是运算符，就将该字符串拆箱成 int 后入栈
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] a = {"2", "1", "+", "3", "*"};
        System.out.println(EvalRPN.evalRPN(a));
    }
}
