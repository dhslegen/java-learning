package javaStudy.java.内部类学习.局部内部类;

/**
 * 【注意】局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。
 *
 * @author ZhaoWH
 */
public class People {
    int age = 10;

    public void testGetGetAge() {
        getGetAge();
    }

    public void getAge() {
        System.out.println("I am " + age + " years old");
    }

    private void getGetAge() {
        getAge();
    }
}

class Man {
    public People getWoman() {
        class Woman extends People {
            public int age = 20;

            @Override
            public void getAge() {
                System.out.println("I am " + age + " years old");
            }
        }
        return new Woman();
    }
}