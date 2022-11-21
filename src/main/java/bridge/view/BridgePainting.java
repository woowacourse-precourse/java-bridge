package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BridgePainting {
    private ArrayList<String> line1, line2;

    BridgePainting(){
        line1 = new ArrayList<>();
        line2 = new ArrayList<>();
    }

    public void init(){
        clear();
        line1.add(PaintingInformation.OPEN_BRACKET);
        line2.add(PaintingInformation.OPEN_BRACKET);
    }

    public List<String> getLine1(){
        return line1;
    }

    public List<String> getLine2(){
        return line2;
    }

    private void clear(){
        line1.clear();
        line2.clear();
    }

    public void correctStep(String position){
        if(position.equals(Position.UP)){
            pushLine1Correct();
            return;
        }
        pushLine2Correct();
    }

    public void inCorrectStep(String position){
        if(position.equals(Position.UP)){
            pushLine1InCorrect();
            pushCloseBRACKET();
            return;
        }
        pushLine2InCorrect();
        pushCloseBRACKET();
    }

    private void pushLine1Correct(){
        line1.add(PaintingInformation.CORRECT);
        line2.add(PaintingInformation.BLANK);
    }

    private void pushLine2Correct(){
        line1.add(PaintingInformation.BLANK);
        line2.add(PaintingInformation.CORRECT);
    }

    private void pushLine1InCorrect(){
        line1.add(PaintingInformation.INCORRECT);
        line2.add(PaintingInformation.BLANK);
    }

    private void pushLine2InCorrect(){
        line1.add(PaintingInformation.BLANK);
        line2.add(PaintingInformation.INCORRECT);
    }

    public void pushCloseBRACKET(){
        line1.add(PaintingInformation.CLOSE_BRACKET);
        line2.add(PaintingInformation.CLOSE_BRACKET);
    }

    public void pushBoundary(){
        line1.add(PaintingInformation.BOUNDARY);
        line2.add(PaintingInformation.BOUNDARY);
    }
}