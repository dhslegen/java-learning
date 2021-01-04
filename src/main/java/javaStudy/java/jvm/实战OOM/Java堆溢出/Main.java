package javaStudy.java.jvm.实战OOM.Java堆溢出;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhslegen
 */
public class Main {

    static class OutOfMemoryErrorObject {
    }

    public static void main(String[] args) {
        List<OutOfMemoryErrorObject> list = new ArrayList<>();

        while (true) {
            list.add(new OutOfMemoryErrorObject());
        }
    }

}
