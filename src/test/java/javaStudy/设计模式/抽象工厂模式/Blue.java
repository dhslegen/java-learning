package javaStudy.设计模式.抽象工厂模式;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}