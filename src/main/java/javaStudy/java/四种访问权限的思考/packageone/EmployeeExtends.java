package javaStudy.java.四种访问权限的思考.packageone;

import javaStudy.java.四种访问权限的思考.Employee;

/**
 * @author dhslegen
 */
public class EmployeeExtends extends Employee {

    /**
     * 非同包子类可访问：public，protected，拒绝：default，private
     */
    private void check() {
        String name = this.name;
        Integer age = this.age;

        // 'occupation' is not public in 'javaStudy.java.四种访问权限的思考.Employee'. Cannot be accessed from outside package
        // String occupation = this.occupation;

        // 'educationBackground' has private access in 'javaStudy.java.四种访问权限的思考.Employee'
        // String educationBackground = this.educationBackground;
    }
}
