package javaStudy.java.四种访问权限的思考;

/**
 * @author dhslegen
 */
public class EmployeeExtends extends Employee {

    /**
     * 同包子类可访问：public，protected，default，拒绝：private
     */
    private void check() {
        String name = this.name;
        Integer age = this.age;
        String occupation = this.occupation;

        // 'educationBackground' has private access in 'javaStudy.java.四种访问权限的思考.Employee'
        // String educationBackground = this.educationBackground;
    }

}
