package bridge;

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

    public void createMap(String move, boolean correctBridge){
        if (topBridge.length() != 0 && bottomBridge.length() != 0){
            topBridge.append(MAP_SEPARATED_CHARACTER);
            bottomBridge.append(MAP_SEPARATED_CHARACTER);
        }
        if (correctBridge)
            createMapCorrectMove(move);
        if (!correctBridge)
            createMapIncorrectMove(move);
    }

    public void createMapCorrectMove(String move){
        if(move.equals(UP)){
            topBridge.append(CORRECT);
            bottomBridge.append(MAP_BLANK);
        }
        if(move.equals(DOWN)) {
            topBridge.append(MAP_BLANK);
            bottomBridge.append(CORRECT);
        }
    }

    public void createMapIncorrectMove(String move){
        if(move.equals(UP)){
            topBridge.append(INCORRECT);
            bottomBridge.append(MAP_BLANK);
        }
        if(move.equals(DOWN)) {
            topBridge.append(MAP_BLANK);
            bottomBridge.append(INCORRECT);
        }
    }

    public void printMap(){
        System.out.println(MAP_PREFIX + topBridge + MAP_SUFFIX);
        System.out.println(MAP_PREFIX + bottomBridge + MAP_SUFFIX);
    }




}
