package bridge.constant;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final Integer code;
    private final String firstLetter;
    
    Direction(int code, String firstLetter) {
        this.code = code;
        this.firstLetter = firstLetter;
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public String getFirstLetter() {
        return this.firstLetter;
    }
    
    public static String getFirstLetter(Integer code) {
        return Arrays.stream(Direction.values()).filter((direction) -> (direction.getCode().equals(code)))
                .findFirst().get().getFirstLetter();
    }
    
    public static Direction getDirection(String firstLetter) {
        return Arrays.stream(Direction.values()).filter((direction) -> (direction.getFirstLetter().equals(firstLetter)))
                .findFirst().get();
    }
}