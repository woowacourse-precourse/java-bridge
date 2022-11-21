package bridge.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Column {
    TOP_ROW("U", 1),
    DOWN_ROW("D", 0),
    NONE("",-1);

    private final int randomNumber;
    private final String capitalLetter;


    private int randomNumber() {
        return randomNumber;
    }

    Column(String capitalLetter, int randomNumber) {
        this.randomNumber = randomNumber;
        this.capitalLetter = capitalLetter;
    }


    private static final Map<Integer, Column> BY_RANDOM_NUMBER = Stream.of(values()).collect(Collectors.toMap(Column::randomNumber, Function.identity()));

    public boolean equals(Column column){
        if(this.capitalLetter == column.capitalLetter)
            return true;
        return false;
    }
    public static Column valueOfCapitalLetter(String capitalLetter) {
        return Arrays.stream(values())
                .filter(row -> row.capitalLetter.equals(capitalLetter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
    public static String judge(int randomNumber) {
        return BY_RANDOM_NUMBER.get(randomNumber).capitalLetter;
    }

    public static boolean isValidateLetter(String input) {
        return BY_RANDOM_NUMBER.containsKey(input);
    }
}
