package bridge.view;

import bridge.domain.GameResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_NUMBER_MESSAGE = "총 시도한 횟수: ";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeResult) {
        System.out.printf("[ ");
        System.out.printf(bridgeResult.get(0));
        for (int i = 1; i < bridgeResult.size(); i++) {
            System.out.printf(" | ");
            System.out.printf(bridgeResult.get(i));
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult, String checkGameResult, int tryNumber) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(gameResult.getUpBridgeResult());
        printMap(gameResult.getDownBridgeResult());
        System.out.println(SUCCESS_OR_FAILURE_MESSAGE + checkGameResult);
        System.out.println(TRY_NUMBER_MESSAGE + tryNumber);
    }
}
