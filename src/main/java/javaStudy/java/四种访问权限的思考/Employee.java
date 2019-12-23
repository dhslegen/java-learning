package javaStudy.java.四种访问权限的思考;

/**
 * @author dhslegen
 */
public class Employee {

    public String name = "dhslegen";
    protected Integer age = 25;
    String occupation = "java工程师";
    private String educationBackground = "本科";

    /**
     * 本类全部可访问
     */
    private void check() {
        String name = this.name;
        Integer age = this.age;
        String occupation = this.occupation;
        String educationBackground = this.educationBackground;
    }

}
