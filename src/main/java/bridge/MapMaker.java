package bridge;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MapMaker {
    private static final String MAP_PREFIX = "[ ";
    private static final String MAP_SUFFIX = " ]";
    private static final String MAP_SEPARATED_CHARACTER = " | ";
    private static final String MAP_BLANK = " ";

    private static final String CORRECT = "O";
    private static final String INCORRECT = "X";

    private static final String UP = "U";
    private static final String DOWN = "D";

    private final StringBuilder topBridge = new StringBuilder();
    private final StringBuilder bottomBridge = new StringBuilder();
    private Queue<String> bridge;

    public MapMaker(List<String> bridge){
        this.bridge = new LinkedList<>(bridge);
    }

    public void createMap(boolean correctBridge){
        if(topBridge.length() != 0 && bottomBridge.length() != 0){
            topBridge.append(MAP_SEPARATED_CHARACTER);
            bottomBridge.append(MAP_SEPARATED_CHARACTER);
        }
        if(correctBridge)
            createMapCorrectMove(bridge.remove());
        if(!correctBridge)
            createMapIncorrectMove(bridge.remove());
    }

    private void createMapCorrectMove(String correctBridge){
        if(correctBridge.equals(UP)){
            topBridge.append(CORRECT);
            bottomBridge.append(MAP_BLANK);
        }
        if(correctBridge.equals(DOWN)) {
            topBridge.append(MAP_BLANK);
            bottomBridge.append(CORRECT);
        }
    }

    private void createMapIncorrectMove(String correctBridge){
        if(correctBridge.equals(DOWN)){
            topBridge.append(INCORRECT);
            bottomBridge.append(MAP_BLANK);
        }
        if(correctBridge.equals(UP)) {
            topBridge.append(MAP_BLANK);
            bottomBridge.append(INCORRECT);
        }
    }

    public List<String> makeMap(){
        return List.of(MAP_PREFIX + topBridge + MAP_SUFFIX
                , MAP_PREFIX + bottomBridge + MAP_SUFFIX);
    }
}
