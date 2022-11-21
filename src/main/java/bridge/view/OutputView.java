package bridge.view;

import bridge.dto.GameResult;
import bridge.dto.PathTravel;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_START = "[";
    private final String BRIDGE_END = "]";
    private final String BRIDGE_DIVIDING_LINE = "|";
    private final String FINAL_GAME_RESULT = "최종 게임 결과";
    private final String SUCCESS = "성공";
    private final String FAIL = "실패";
    private final String GAME_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private final String TOTAL_NUMBER_OF_SUCCESS = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PathTravel pathTravel) {
        printPlayerMap(pathTravel.getUpperBridge());
        printPlayerMap(pathTravel.getLowerBridge());
    }

    private void printPlayerMap(final List<String> map) {
        System.out.print(BRIDGE_START);

        int mapSize = map.size();
        for (int i = 0; i < mapSize; i++) {
            System.out.print(map.get(i));
            if (canPrintDividingLine(i, mapSize)) {
                System.out.print(BRIDGE_DIVIDING_LINE);
            }
        }
        System.out.println(BRIDGE_END);
    }

    private boolean canPrintDividingLine(int currentPosition, int mapSize) {
        if (currentPosition < mapSize - 1) {
            return true;
        }
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(FINAL_GAME_RESULT);
        printPlayerMap(gameResult.getUpperBridge());
        printPlayerMap(gameResult.getLowerBridge());
        printPlayerGameResult(gameResult.getResult());
        printTotalNumberOfTry(gameResult.getNumberOfTry());
    }

    private void printTotalNumberOfTry(Long numberOfTry) {
        System.out.println(TOTAL_NUMBER_OF_SUCCESS + numberOfTry);
    }

    private void printPlayerGameResult(Boolean result) {
        if (result) {
            System.out.println(GAME_SUCCESS_OR_FAIL + SUCCESS);
            return;
        }
        System.out.println(GAME_SUCCESS_OR_FAIL + FAIL);
    }

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printError(String message) {
        System.out.println(message);
    }

}