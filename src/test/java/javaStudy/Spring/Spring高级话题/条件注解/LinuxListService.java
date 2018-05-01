package javaStudy.Spring.Spring高级话题.条件注解;

public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
