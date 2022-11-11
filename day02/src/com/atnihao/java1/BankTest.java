package com.atnihao.java1;

/**
 *
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author nihao
 * @create 2022-11-06 20:45
 */
public class BankTest {
    public static void main(String[] args) {

    }

}

class Bank{

    private Bank(){

    }

    private static Bank instance = null;

    public static synchronized Bank getIstance(){
        if(instance == null){
            instance = new Bank();

        }
        return instance;
    }
}
