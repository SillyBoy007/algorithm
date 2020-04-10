package com.wxy.learn.algorithm.practice.stack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 *
 * @author wangxiayun
 * @since 2020/4/3
 **/
public class EffectiveBrackets {


    private Map<Character, Character> bracketMap = new HashMap<>();

    public EffectiveBrackets() {
        this.bracketMap.put(')', '(');
        this.bracketMap.put('}', '{');
        this.bracketMap.put(']', '[');
    }

    /**
     * 解法一:栈(时间(On，空间On))
     * 初始化栈 S。
     * 一次处理表达式的每个括号。
     * 如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
     * 如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
     * 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
     *
     * @param
     * @return
     */
    public boolean isValidate(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.bracketMap.containsKey(c)) {

                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.bracketMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }


        return stack.isEmpty();
    }

    public static void main(String[] args) {
        EffectiveBrackets effectiveBrackets = new EffectiveBrackets();
        System.out.println(effectiveBrackets.isValidate("(){}[]"));
    }
}
