package bridge.domain;

import java.util.Arrays;

import static bridge.domain.ValidationString.NO_MATCH_BLANK_TO_MOVE;

public enum BridgePair {
    UP("U", 0),
    DOWN("D", 1);

    private String content;
    private int listIndex;

    BridgePair(String content, int listIndex){
        this.content = content;
        this.listIndex = listIndex;
    }

    public static BridgePair findPair(String input){
        return Arrays.stream(BridgePair.values()).filter(pair -> pair.content.equals(input))
                .findAny().orElseThrow(() -> {throw new IllegalStateException(NO_MATCH_BLANK_TO_MOVE.toString());});
    }

    public int getListIndex(){
        return listIndex;
    }

    public String getValue(){
        return content;
    }
}
