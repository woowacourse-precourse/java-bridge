package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> moveStates;

    public Bridge(List<String> moveStates) {
        this.moveStates = moveStates;
    }

    public void drawResult(Bridge userBridge, int tryCounts) {
        OutputView.printResult(new Bridge(moveStates), userBridge, tryCounts);
    }

    public Bridge move(Bridge userBridge) {
        String nextMove = InputView.readMoving();
        userBridge.addMoveState(nextMove);
        OutputView.printMap(new Bridge(moveStates), userBridge);

        return userBridge;
    }

    public boolean compareStates(int index, Bridge bridge) {
        String userState = bridge.getMoveState(index);
        String computerState = getMoveState(index);
        if (computerState.equals(userState)) {
            return true;
        }
        return false;
    }

    public boolean checkSuccess(Bridge bridge) {
        int size = getSize();
        if (size != bridge.getSize()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!compareStates(i, bridge)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRetry() {
        String command = InputView.readGameCommand();
        String retry = BridgeValue.Information
                .RE_TRY
                .getValue();

        if (retry.equals(command)) {
            return true;
        }

        return false;
    }

    public void addMoveState(String state) {
        moveStates.add(state);
    }

    public void removeLastState() {
        int lastIndex = getLastIndex();
        moveStates.remove(lastIndex);
    }

    public String getMapToString(Bridge bridge) {
        String map = getUpMap(bridge);
        map += GameMessage.LINE_BREAK;
        map += getDownMap(bridge);

        return map;
    }

    public int getSize() {
        return moveStates.size();
    }

    public int getLastIndex() {
        int lastIndex = getSize() - 1;
        return lastIndex;
    }

    private List<String> getMoveStates() {
        return moveStates;
    }

    private String getMoveState(int index) {
        return moveStates.get(index);
    }

    private String getUpMap(Bridge bridge) {
        List<String> upBridge = new ArrayList<>();
        upBridge.add(BridgeValue.getNothing());

        String up = getUpMoves(bridge, upBridge)
                .toString();
        String answer = up.replaceAll(BridgeValue.getComma(), BridgeValue.getNothing());
        return answer;
    }

    private String getDownMap(Bridge bridge) {
        List<String> downBridge = new ArrayList<>();
        downBridge.add(BridgeValue.getNothing());

        String down = getDownMoves(bridge, downBridge)
                .toString();
        String answer = down.replaceAll(BridgeValue.getComma(), BridgeValue.getNothing());
        return answer;
    }

    private List<String> getUpMoves(Bridge bridge, List<String> upBridge) {
        int size = bridge.getSize();

        for (int i = 0; i < size; i++) {
            upBridge = getUpMove(bridge, upBridge, i);
        }
        return upBridge;
    }

    private List<String> getDownMoves(Bridge bridge, List<String> downBridge) {
        int size = bridge.getSize();

        for (int i = 0; i < size; i++) {
            downBridge = getDownMove(bridge, downBridge, i);
        }
        return downBridge;
    }

    private List<String> getUpMove(Bridge bridge, List<String> upBridge, int bridgeIndex) {
        String computerState = getMoveState(bridgeIndex);
        String userState = bridge.getMoveState(bridgeIndex);
        String move = BridgeValue.getMoveState(computerState, userState);
        String divisionOrNot = BridgeValue.getDivisionOrBracket(bridge.getSize() - 1, bridgeIndex);

        if (BridgeValue.checkUpState(userState)) {
            upBridge = updateMove(upBridge, move, divisionOrNot);
            return upBridge;
        }
        upBridge = updateMove(upBridge, BridgeValue.getSpace(), divisionOrNot);
        return upBridge;
    }

    private List<String> getDownMove(Bridge bridge, List<String> downBridge, int bridgeIndex) {
        String computerState = getMoveState(bridgeIndex);
        String userState = bridge.getMoveState(bridgeIndex);
        String move = BridgeValue.getMoveState(computerState, userState);
        String divisionOrNot = BridgeValue.getDivisionOrBracket(bridge.getSize() - 1, bridgeIndex);

        if (BridgeValue.checkUpState(userState)) {
            downBridge = updateMove(downBridge, BridgeValue.getSpace(), divisionOrNot);
            return downBridge;
        }
        downBridge = updateMove(downBridge, move, divisionOrNot);
        return downBridge;
    }

    private List<String> updateMove(List<String> moves, String move, String divisionOrNot) {
        moves.add(move);
        moves.add(divisionOrNot);
        return moves;
    }


}
