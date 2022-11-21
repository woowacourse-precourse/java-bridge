package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final int MAX_HEIGHT = 2;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String START_ROW = "[";
    private static final String SPLIT_UNIT = "|";
    private static final String END_ROW = "]";
    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String END_BRIDGE_GAME = "최종 게임 결과";
    private static final String GAME_SUCCESS_FLAG_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_NUMBER_OF_TRIES = "총 시도한 횟수: ";

    public static void printGameStartMessage() {
        System.out.println(START_BRIDGE_GAME);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(int currentPosition, List<List<String>> bridgeMap) {
        for(int height=0; height<MAX_HEIGHT; height++){
            System.out.print(START_ROW);
            System.out.print(String.join(SPLIT_UNIT, bridgeMap.get(height).subList(0, currentPosition)));
            System.out.println(END_ROW);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int currentPosition, BridgeGame bridgeGame) {
        if (!bridgeGame.isSuccess()) {
            currentPosition += 1;
        }
        System.out.println(END_BRIDGE_GAME);
        printMap(currentPosition, bridgeGame.getBridgeMap());
        System.out.println(GAME_SUCCESS_FLAG_MESSAGE + getResult(bridgeGame.isSuccess()));
        System.out.print(TOTAL_NUMBER_OF_TRIES + bridgeGame.getNumberOfTries());
    }

    private static String getResult(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }
}
