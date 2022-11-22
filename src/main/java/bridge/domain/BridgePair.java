package bridge.domain;

import java.util.Arrays;

import static bridge.domain.ValidationString.NO_MATCH_BLANK_TO_MOVE;

public enum BridgePair {
    UP(1,"U", 0),
    DOWN(0,"D", 1);

    private int createNumber;
    private String content;
    private int listIndex;

    BridgePair(int randomNumber, String content, int listIndex){
        this.createNumber = randomNumber;
        this.content = content;
        this.listIndex = listIndex;
    }

    public static BridgePair findPair(String input){
        return Arrays.stream(BridgePair.values()).filter(pair -> pair.content.equals(input))
                .findAny().orElseThrow(() -> {throw new IllegalStateException(NO_MATCH_BLANK_TO_MOVE.toString());});
    }

    public static BridgePair findPair(int randomNumber){
        return Arrays.stream(BridgePair.values()).filter(pair -> pair.createNumber==randomNumber)
                .findAny().orElseThrow(() -> {throw new IllegalStateException(NO_MATCH_BLANK_TO_MOVE.toString());});
    }

    public int getListIndex(){
        return listIndex;
    }

    public String getValue(){
        return content;
    }

    public int getRandomNumber(){
        return createNumber;
    }
}
