package bridge.game;

import bridge.message.GameMessage;
import bridge.view.OutputView;
import java.util.StringJoiner;

public class BridgeStatus {
    private static final String SPACE = " ";
    private static final String MID_SYMBOL = " | ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    private static StringJoiner TOP_BRIDGE;

    private static StringJoiner BOTTOM_BRIDGE;
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private static boolean CLEAR = false;
    private static int CURRENT_LOCATION = 0;
    private static int RETRY_COUNT = 1;

    public BridgeStatus() {
        clearMap();
    }

    // 상태 값 변경
    public void clearMap() {
        TOP_BRIDGE = new StringJoiner(MID_SYMBOL);
        BOTTOM_BRIDGE = new StringJoiner(MID_SYMBOL);
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
            return SUCCESS;
        }
        return FAILURE;
    }

    // 다리 지도 그리기
    public void drawingBridge(String move, String division) {
        if (move.equals("U")) {
            TOP_BRIDGE.add(division);
            BOTTOM_BRIDGE.add(SPACE);
        }
        if (move.equals("D")) {
            TOP_BRIDGE.add(SPACE);
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
