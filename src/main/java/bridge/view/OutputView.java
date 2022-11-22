package bridge.view;

import static bridge.Moving.DOWN;
import static bridge.Moving.UP;
import static bridge.constant.BridgeSymbol.BRIDGE_DELIMITER;
import static bridge.constant.BridgeSymbol.BRIDGE_END;
import static bridge.constant.BridgeSymbol.BRIDGE_START;
import static bridge.constant.BridgeSymbol.MOVING_EMPTY;
import static bridge.constant.BridgeSymbol.MOVING_O;
import static bridge.constant.BridgeSymbol.MOVING_X;
import static bridge.constant.Message.FAIL;
import static bridge.constant.Message.GAME_RESULT;
import static bridge.constant.Message.GAME_START;
import static bridge.constant.Message.GAME_SUCCESS;
import static bridge.constant.Message.INPUT_BRIDGE_SIZE;
import static bridge.constant.Message.INPUT_GAME_COMMAND;
import static bridge.constant.Message.INPUT_MOVING;
import static bridge.constant.Message.SUCCESS;
import static bridge.constant.Message.TOTAL_TRIAL_COUNT;

import bridge.BridgeGame;
import bridge.Moving;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printMap(BridgeGame bridgeGame) {
        Map<Moving, List<String>> map = generateMap(bridgeGame);
        printRow(map.get(UP));
        printRow(map.get(DOWN));
    }

    private void printRow(List<String> row) {
        System.out.println(BRIDGE_START + String.join(BRIDGE_DELIMITER, row) + BRIDGE_END);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT);
        printMap(bridgeGame);
        System.out.println();
        System.out.println(GAME_SUCCESS + getSuccessWord(bridgeGame.isSuccess()));
        System.out.println(TOTAL_TRIAL_COUNT + Integer.toString(bridgeGame.getTrialCount()));
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START);
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printMovingInputMessage() {
        System.out.println(INPUT_MOVING);
    }

    public void printGameCommandInputMessage() {
        System.out.println(INPUT_GAME_COMMAND);
    }

    private String getSuccessWord(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAIL;
    }

    private Map<Moving, List<String>> generateMap(BridgeGame bridgeGame) {
        int round = bridgeGame.getRound();
        List<String> bridge = bridgeGame.getBridge();
        Map<Moving, List<String>> map = new HashMap<>();
        map.put(UP, new ArrayList<>());
        map.put(DOWN, new ArrayList<>());
        for (int i = 0; i < round - 1; i++) {
            cross(map, Moving.of(bridge.get(i)), true);
        }
        cross(map, Moving.of(bridge.get(round - 1)), bridgeGame.isSuccess());
        return map;
    }

    private void cross(Map<Moving, List<String>> row, Moving moving, boolean isCorrectMoving) {
        Moving otherSide = getOtherSide(moving);
        if (isCorrectMoving) {
            row.get(otherSide).add(MOVING_EMPTY);
            row.get(moving).add(MOVING_O);
            return;
        }
        row.get(otherSide).add(MOVING_X);
        row.get(moving).add(MOVING_EMPTY);
    }

    private Moving getOtherSide(Moving moving) {
        return Moving.values()[(moving.ordinal() + 1) % 2];
    }
}
