package javaStudy.Spring.Spring高级话题.条件注解;

public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
