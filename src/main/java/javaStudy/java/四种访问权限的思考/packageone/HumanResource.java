package javaStudy.java.四种访问权限的思考.packageone;

import javaStudy.java.四种访问权限的思考.Employee;

/**
 * @author dhslegen
 */
public class HumanResource {

    /**
     * 非同包非子类可访问：public，拒绝：protected，default，private
     */
    public void check() {
        Employee employee = new Employee();
        String name = employee.name;

        // 'age' has protected access in 'javaStudy.java.四种访问权限的思考.Employee'
        // Integer age = employee.age;

        // 'occupation' is not public in 'javaStudy.java.四种访问权限的思考.Employee'. Cannot be accessed from outside package
        // String occupation = employee.occupation;

        // 'educationBackground' has private access in 'javaStudy.java.四种访问权限的思考.Employee'
        // String educationBackground = employee.educationBackground;
    }

}
