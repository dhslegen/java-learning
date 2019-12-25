package javaStudy.java.hashcode和equals的思考;

import java.util.HashMap;

/**
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        HashMap<Equals, String> equalsStringHashMap = new HashMap<>(1);
        Equals equals = new Equals("1", "dhslegen");
        equalsStringHashMap.put(equals, "通过");
        String s = equalsStringHashMap.get(new Equals("1", "dhslegen"));
        System.out.println(s);
    }

}
