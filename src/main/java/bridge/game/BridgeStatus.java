package bridge.game;

import bridge.resource.GameConstant;
import bridge.resource.GameMessage;
import bridge.view.OutputView;
import java.util.StringJoiner;

public class BridgeStatus {
    private static StringJoiner TOP_BRIDGE;
    private static StringJoiner BOTTOM_BRIDGE;
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static boolean CLEAR = false;
    private static int CURRENT_LOCATION = 0;
    private static int RETRY_COUNT = 1;

    public BridgeStatus() {
        clearMap();
    }

    public void clearMap() {
        TOP_BRIDGE = new StringJoiner(GameConstant.MID_SYMBOL);
        BOTTOM_BRIDGE = new StringJoiner(GameConstant.MID_SYMBOL);
    }

    public void checkGameOver(int size) {
        if (size == CURRENT_LOCATION) {
            CLEAR = true;
        }
    }

    public void clearCurrentLocation() {
        CURRENT_LOCATION = 0;
    }

    public void plusCurrentLocation() {
        CURRENT_LOCATION++;
    }

    public void plusRetryCount() {
        RETRY_COUNT++;
    }

    // 게임 현황 관련 메세지
    public void printBridgeStatus() {
        OUTPUT_VIEW.printMap(TOP_BRIDGE.toString(), BOTTOM_BRIDGE.toString());
    }

    public void printGameOver() {
        System.out.println(GameMessage.GAME_FINISH_MSG);
        printBridgeStatus();
        OUTPUT_VIEW.printResult(gameClearStatusUpdate(), RETRY_COUNT);
    }

    // 게임 성공 여부 확인
    private String gameClearStatusUpdate() {
        if (CLEAR) {
            return GameConstant.SUCCESS;
        }
        return GameConstant.FAILURE;
    }

    // 다리 지도 그리기
    public void drawingBridge(String move, String division) {
        if (move.equals(GameConstant.TOP)) {
            TOP_BRIDGE.add(division);
            BOTTOM_BRIDGE.add(GameConstant.SPACE);
        }
        if (move.equals(GameConstant.BOTTOM)) {
            TOP_BRIDGE.add(GameConstant.SPACE);
            BOTTOM_BRIDGE.add(division);
        }
    }

    // getter
    public int getCurrentLocation() {
        return CURRENT_LOCATION;
    }

    public boolean getClear() {
        return CLEAR;
    }
}
