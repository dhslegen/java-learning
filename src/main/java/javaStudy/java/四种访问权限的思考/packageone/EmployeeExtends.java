package javaStudy.java.四种访问权限的思考.packageone;

import javaStudy.java.四种访问权限的思考.Employee;

/**
 * @author dhslegen
 */
public class EmployeeExtends extends Employee {

    private void check() {
        // 'name' has private access in 'javaStudy.java.四种访问前线的思考.Employee'
        // String name = this.name;

        Integer age = this.age;
        String occupation = this.occupation;

        // 'educationBackground' is not public in 'javaStudy.java.四种访问前线的思考.Employee'. Cannot be accessed from outside package
        // String educationBackground = this.educationBackground;
    }
}
