package bridge.view;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";


    public void startPrint() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printBridgeLength(int length) {
        System.out.println(length);
    }


}