package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> states;

    public Bridge(List<String> states) {
        this.states = states;
    }

    public void bridgeDraw(Bridge userBridge, int tryCounts) {
        OutputView outputView = new OutputView();
        outputView.printResult(new Bridge(states), userBridge, tryCounts);
    }

    public Bridge bridgeMove(Bridge userBridge) {
        String nextMove = new InputView().readMoving();
        userBridge.addState(nextMove);
        OutputView outputView = new OutputView();
        outputView.printMap(new Bridge(states), userBridge);

        return userBridge;
    }

    public String getMapToString(Bridge bridge) {
        String map = getUpMap(bridge);
        map += GameMessage.LINE_BREAK;
        map += getDownMap(bridge);

        return map;
    }

    public boolean checkSuccess(Bridge bridge) {
        int size = getSize();
        if (size != bridge.getSize()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!compareState(i, bridge)) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return states.size();
    }

    public void addState(String state) {
        states.add(state);
    }

    public void removeState() {
        int lastIndex = getSize() - 1;
        states.remove(lastIndex);
    }

    public int getLastIndex() {
        int lastIndex = getSize() - 1;
        return lastIndex;
    }

    public boolean compareState(int index, Bridge bridge) {
        String userState = bridge.getState(index);
        String computerState = getState(index);
        if (computerState.equals(userState)) {
            return true;
        }
        return false;
    }

    public boolean checkRetry() {
        String command = new InputView().readGameCommand();
        return BridgeValue.checkReTry(command);
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
        String computerState = getState(bridgeIndex);
        String userState = bridge.getState(bridgeIndex);
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
        String computerState = getState(bridgeIndex);
        String userState = bridge.getState(bridgeIndex);
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

    private List<String> getStates() {
        return states;
    }

    private String getState(int index) {
        return states.get(index);
    }


}
