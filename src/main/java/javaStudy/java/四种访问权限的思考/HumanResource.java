package javaStudy.java.四种访问权限的思考;

/**
 * @author dhslegen
 */
public class HumanResource {

    /**
     * 同包其他类可访问：public，protected，default，拒绝：private（同同包子类）
     */
    public void check() {
        Employee employee = new Employee();
        String name = employee.name;
        Integer age = employee.age;
        String occupation = employee.occupation;

        // 'educationBackground' has private access in 'javaStudy.java.四种访问权限的思考.Employee'
        // String educationBackground = employee.educationBackground;
    }

}
