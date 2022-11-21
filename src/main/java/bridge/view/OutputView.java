package bridge.view;

import static bridge.util.BridgeGameConstant.GAME_STATUS_MESSAGE;
import static bridge.util.BridgeGameConstant.TRY_COUNT_MESSAGE;

import bridge.model.BridgeGame;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public OutputView() {
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getRoundMapToString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);

        printEmptyLine();

        Map<String, String> result = bridgeGame.getResultToString();

        System.out.println(GAME_STATUS_MESSAGE + ": " + result.get(GAME_STATUS_MESSAGE));
        System.out.println(TRY_COUNT_MESSAGE + ": " + result.get(TRY_COUNT_MESSAGE));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
