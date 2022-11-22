package bridge.view;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_CONTENT = "[ %s ]%n";
    private final String BRIDGE_PLACE_CONTOUR = " | ";
    private final String GAME_RESULT = "최종 게임 결과";
    private final String IS_GAME_SUCCESSFUL = "게임 성공 여부: %s%n";
    private final String GAME_SUCCESS = "성공";
    private final String GAME_FAIL = "실패";
    private final String RETRY_COUNT = "총 시도한 횟수: %d";

    public void startPrint() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printBridgeLength(int length) {
        System.out.println(length);
    }


    public void printMoving(String moving) {
        System.out.println(moving);
    }


}