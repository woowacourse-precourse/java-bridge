package bridge;

import java.util.ArrayList;
import java.util.List;


public class OutputView {
    private static final String MAP_BEGIN = "[ ";
    private static final String MAP_END = " ]";
    private static final String MAP_DELIMITER = " | ";
    public void printBeforeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(BridgeGame bridgeGame) {
        List<String> upMap = bridgeGame.getMap(MovingEnum.U);
        List<String> downMap = bridgeGame.getMap(MovingEnum.D);

        String upMapResult = MAP_BEGIN + String.join(MAP_DELIMITER, upMap) + MAP_END;
        String downMapResult = MAP_BEGIN + String.join(MAP_DELIMITER, downMap) + MAP_END;
        System.out.println(upMapResult);
        System.out.println(downMapResult);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println();
        System.out.println("게임 성공 여부: " + bridgeGame.getGameResult());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}
