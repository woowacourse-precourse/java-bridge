package bridge.view;

import bridge.domain.BridgeStatus;
import bridge.view.draw.BridgeDrawer;
import bridge.view.draw.BridgeDrawerFactory;

public class OutputView extends View {

    private static final String LETS_START = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_STATUS = "게임 성공 여부: %s";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: %d";

    public void printMap(BridgeStatus bridgeStatus) {
        BridgeDrawer drawer = BridgeDrawerFactory.createDrawer(bridgeStatus);
        String drawResult = drawer.draw();
        print(drawResult);
    }

    public void printResult(BridgeStatus bridgeStatus) {
        print(FINAL_RESULT);
        printMap(bridgeStatus);
        printEmptyLine();
        print(String.format(GAME_STATUS, bridgeStatus.getGameStatus().getDetails()));
        print(String.format(TOTAL_TRY_COUNT, bridgeStatus.getTryCount()));
    }

    public void printEmptyLine() {
        print();
    }

    public void printStart() {
        print(LETS_START);
    }
}
