package bridge.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Row {
    TOP_ROW("U",1),
    DOWN_ROW("D",0);

    private final int randomNumber;
    private final String capitalLetter;
    private int randomNumber(){
        return randomNumber;
    }

    Row(String capitalLetter, int randomNumber){
        this.randomNumber = randomNumber;
        this.capitalLetter = capitalLetter;
    }
    private static final Map<Integer,Row> BY_RANDOM_NUMBER = Stream.of(values()).collect(Collectors.toMap(Row::randomNumber, Function.identity()));
    public static String judge(int randomNumber){
        return BY_RANDOM_NUMBER.get(randomNumber).capitalLetter;
    }
    public static boolean isValidateLetter(String input){
        return BY_RANDOM_NUMBER.containsKey(input);
    }
}
