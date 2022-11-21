package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private static final String BLANK = " ";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String UP = "U";
    private static final String DOWN = "D";


    private final List<String> bridge;

    public List<String> upperLine = new ArrayList<>();
    public List<String> lowerLine = new ArrayList<>();

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }


    public void markCorrect(String userInput){
        if ( userInput.equals(UP)) {
            upperLine.add(CORRECT);
            lowerLine.add(BLANK);
        }
        if ( userInput.equals(DOWN)){
            upperLine.add(BLANK);
            lowerLine.add(CORRECT);
        }
    }

    public void markIncorrect(String userInput){
        if ( userInput.equals(UP)) {
            upperLine.add(WRONG);
            lowerLine.add(BLANK);
        }
        if ( userInput.equals(DOWN)){
            upperLine.add(BLANK);
            lowerLine.add(WRONG);
        }
    }

    public void makeMap(boolean correct,String userInput){
        if ( correct ){
            markCorrect(userInput);
        }
        if ( !correct ){
            markIncorrect(userInput);
        }
    }
    public boolean move(int index,String userInput) {
        if(!bridge.get(index).equals(userInput)){
            makeMap(false,userInput);
            return false;
        }
        makeMap(true,userInput);
        return true;
    }

    public boolean retry(String readCommand) {
        if (readCommand.equals("R")) { return true; }
        return false;
    }
}
