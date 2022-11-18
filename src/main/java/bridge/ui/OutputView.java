package bridge.ui;

import bridge.model.Answer;
import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.GameMessage;
import java.util.List;

public class OutputView {

    public void printMap(List<Direction> bridge, int step) {
        drawBridge(bridge, step, Direction.UP);
        drawBridge(bridge, step, Direction.DOWN);
    }

    public void printResult(String isSuccess, String totalTry) {
        System.out.println(isSuccess);
        System.out.print(totalTry);
    }

    private void drawBridge(List<Direction> bridge, int step, Direction direction){
        System.out.println(Bridge.START.getView()
                + getProgress(bridge, step, direction)
                + getFinalProgress(bridge, step, direction));
    }

    private String getProgress(List<Direction> bridge, int step, Direction direction){
        StringBuilder result = new StringBuilder();
        for(int stepCount = 0; stepCount < step - 2; stepCount++){
            if(bridge.get(stepCount) == direction){
                result.append(Answer.CORRECT.getOutput());
            }else if(bridge.get(stepCount) != direction){
                result.append(Answer.NONE.getOutput());
            }
            result.append(Bridge.MID.getView());
        }
        return result.toString();
    }

    private String getFinalProgress(List<Direction> bridge, int step, Direction direction){
        StringBuilder result = new StringBuilder();
        if(bridge.get(step - 1) == direction){
            result.append(Answer.CORRECT.getOutput());
        }else if(bridge.get(step - 1) != direction){
            result.append(Answer.INCORRECT.getOutput());
        }
        result.append(Bridge.END.getView());
        return result.toString();
    }
}
