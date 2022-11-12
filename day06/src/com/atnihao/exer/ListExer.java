package com.atnihao.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 一道面试题
 * 区分:List中的remove(int index) 和 remove(Object obj)
 *
 * @author nihao
 * @create 2022-11-12 14:34
 */
public class ListExer {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//[1, 2] ：选择执行容易的，自动装箱和int类型相比，编译器识别为int类型
    }
    private static void updateList(List list) {
        list.remove(2);
        //如果想要删除值为2的
//      list.remove(new Integer(2));
    }
}
