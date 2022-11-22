package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeState {

    private List<String> upBridgeState;
    private List<String> downBridgeState;

    public CurrentBridgeState() {
        upBridgeState = new ArrayList<>();
        downBridgeState = new ArrayList<>();
    }

    public void recordBridgeMove(String moveCommand, boolean isPossibleMove) {

        if (isPossibleMove == true) {
            successMove(moveCommand, upBridgeState, downBridgeState);
        } else if (isPossibleMove == false) {
            failMove(moveCommand, upBridgeState, downBridgeState);
        }
    }

    private void failMove(String moveCommand, List<String> upBridgeState, List<String> downBridgeState) {

        if (moveCommand.equals("U")) {
            upBridgeState.add("X");
            downBridgeState.add(" ");
        } else if (moveCommand.equals("D")) {
            upBridgeState.add(" ");
            downBridgeState.add("X");
        }
    }

    private void successMove(String moveCommand, List<String> upBridgeState, List<String> downBridgeState) {

        if (moveCommand.equals("U")) {
            upBridgeState.add("O");
            downBridgeState.add(" ");
        } else if (moveCommand.equals("D")) {
            upBridgeState.add(" ");
            downBridgeState.add("O");
        }
    }


    public List<String> getUpBridgeState() {
        return upBridgeState;
    }

    public List<String> getDownBridgeState() {
        return downBridgeState;
    }
}
