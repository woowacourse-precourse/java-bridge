package bridge.utils;

public enum Stairs {
    UP_STAIRS(1, "U"),
    DOWN_STAIRS(0, "D");

    private int randomValue;
    private String abbreviation;

    Stairs(int randomValue, String abbreviation) {
        this.randomValue = randomValue;
        this.abbreviation = abbreviation;
    }

    public static String convertIntToStr(int randomValue) {
        if(randomValue == Stairs.UP_STAIRS.randomValue){
            return UP_STAIRS.abbreviation;
        }
        if(randomValue == Stairs.DOWN_STAIRS.randomValue) {
            return DOWN_STAIRS.abbreviation;
        }
        throw new IllegalStateException("올바른 랜덤 값이 아닙니다.");
    }
}
