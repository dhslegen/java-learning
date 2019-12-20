package javaStudy.java.四种访问权限的思考.packageone;

import javaStudy.java.四种访问权限的思考.Employee;

/**
 * @author dhslegen
 */
public class HumanResource {
    public void check() {
        Employee employee = new Employee();

        // 'name' has private access in 'javaStudy.java.四种访问前线的思考.Employee'
        // String name = employee.name;

        // 'age' has protected access in 'javaStudy.java.四种访问前线的思考.Employee'
        // Integer age = employee.age;

        String occupation = employee.occupation;

        // 'educationBackground' is not public in 'javaStudy.java.四种访问前线的思考.Employee'. Cannot be accessed from outside package
        // String educationBackground = employee.educationBackground;
    }
}
