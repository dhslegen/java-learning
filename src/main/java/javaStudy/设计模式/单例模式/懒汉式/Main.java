package javaStudy.设计模式.单例模式.懒汉式;

public class Main {
    public static void main(String[] args) {
        //以下编译不通过
        //Singleton singleton = new Singleton();
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}
