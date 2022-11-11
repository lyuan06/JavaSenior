package com.atnihao.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * 集合元素的遍历，使用迭代器Iterator接口
 * hasNext() 和 next()
 *
 * 说明：1.iterator并不一个容器，只是用来遍历集合中元素
 *       2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 *       3.内部定义了一个remove方法，可以在遍历的时候删除集合中的元素。此方法不同于集合直接调用remove()
 *
 *
 * @author nihao
 * @create 2022-11-11 17:35
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        Iterator iterator = coll.iterator();

//        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //NoSuchElementException
////        System.out.println(iterator.next());

//        //方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        //hasNest():判断是否还有下一个元素
        while(iterator.hasNext()){
            //next():①指针下移②将下移以后的集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        //错误方式一：
        Iterator iterator = coll.iterator();
        while(iterator.next() != null){
            System.out.println(iterator.next());//相当于调了两次next()方法，间隔输出，最终越界报异常
        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
        while(coll.iterator().hasNext()){
            System.out.println(iterator.next());//陷入死循环，一直输出123，因为每次循环判断相当于创建了一个新的迭代器
        }

    }
    //测试Iterator中的remove()
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(false);
        coll.add(231);
        coll.add(new String("Tom"));
        coll.add(new Person("Jerry",20));

        //删除集合中“Tom”
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        //遍历集合
        //注意：之前的迭代器已经执行完毕，必须重写创建一个迭代器
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }


    }

}
