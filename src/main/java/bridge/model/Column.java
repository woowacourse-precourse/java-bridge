package bridge.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Column {
    TOP_ROW("U", 1,0),
    DOWN_ROW("D", 0,1),
    NONE("",-1, -1);

    private final int randomNumber;
    private final String capitalLetter;
    private final int index;

    Column(String capitalLetter, int randomNumber, int index) {
        this.randomNumber = randomNumber;
        this.capitalLetter = capitalLetter;
        this.index = index;
    }

    private String capitalLetter() {
        return capitalLetter;
    }
    private int randomNumber() {
        return randomNumber;
    }
    public int getIndex() {
        return index;
    }

    public int getOppositeIndex(){
        if(index == 1){
            return 0;
        }
        return 1;
    }

    private static final Map<Integer, Column> BY_RANDOM_NUMBER = Stream.of(values()).collect(Collectors.toMap(Column::randomNumber, Function.identity()));
    public static final Map<String, Column> BY_CAPITAL_LETTER = Stream.of(values()).collect(Collectors.toMap(Column::capitalLetter, Function.identity()));


    public static Column valueOfCapitalLetter(String capitalLetter) {
        return Arrays.stream(values())
                .filter(row -> row.capitalLetter.equals(capitalLetter) && !row.capitalLetter.equals(""))
                .findFirst()
                .get();
    }
    public static String changeNumToLetter(int randomNumber) {
        return BY_RANDOM_NUMBER.get(randomNumber).capitalLetter;
    }

    public boolean isAnswer(){
        if(!capitalLetter.equals("")){
            return true;
        }
        return false;
    }

    public boolean equals(Column column){
        if(this.capitalLetter.equals(column.capitalLetter)) {
            return true;
        }
        return false;
    }

}
