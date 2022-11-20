package bridge.view;

import bridge.message.GameSuccess;
import bridge.util.BridgePart;
import bridge.util.UpDown;

import java.util.List;

public class OutputView {
    private StringBuilder upOut;
    private StringBuilder downOut;

    public void printMap(int current, String input, List<String> bridge) {
        upOut = new StringBuilder();
        downOut = new StringBuilder();

        appendEdge(BridgePart.START_EDGE.getValue());

        beforeState(current, bridge);
        currentState(current, input, bridge);

        appendEdge(BridgePart.END_EDGE.getValue());

        System.out.print(upOut + System.lineSeparator()
                + downOut + System.lineSeparator());
    }

    private void appendEdge(String edge){
        upOut.append(edge);
        downOut.append(edge);
    }

    private void beforeState(int current, List<String> bridge){
        for(int i=0; i<current; i++){
            String state = bridge.get(i);
            setUpState(state, BridgePart.OK.getValue());
            setDownState(state, BridgePart.OK.getValue());

            upOut.append(BridgePart.PARTITION.getValue());
            downOut.append(BridgePart.PARTITION.getValue());
        }
    }

    private void currentState(int current, String input, List<String> bridge){
        if(input.equals(bridge.get(current))){
            setUpState(input, BridgePart.OK.getValue());
            setDownState(input, BridgePart.OK.getValue());
        }else{
            setUpState(input, BridgePart.NO.getValue());
            setDownState(input, BridgePart.NO.getValue());
        }
    }

    private void setUpState(String state, String answer){
        if(state.equals(UpDown.UP.getValue())){
            upOut.append(BridgePart.BLANK.getValue())
                    .append(answer)
                    .append(BridgePart.BLANK.getValue());

            downOut.append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue());
        }
    }

    private void setDownState(String state, String answer){
        if(state.equals(UpDown.DOWN.getValue())){
            upOut.append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue());

            downOut.append(BridgePart.BLANK.getValue())
                    .append(answer)
                    .append(BridgePart.BLANK.getValue());
        }
    }

    public void printResult(boolean isSuccess, int gameTry) {
        System.out.println("최종 게임 결과");
        GameSuccess gameSuccess = GameSuccess.findMessage(isSuccess);
        System.out.print(gameSuccess.getMessage() + System.lineSeparator());
        System.out.printf("총 시도한 횟수: %d%n", gameTry);
    }
}
