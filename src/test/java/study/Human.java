package study;

import java.util.List;

public class Human {

    private final String name;
    private final int age;
    private final List<String> friend;

    public Human(String name, int age, List<String> friend) {
        this.friend = friend;
        this.name = name;
        this.age = age;
    }
}
