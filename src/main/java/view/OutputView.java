package view;

import bridge.BridgeGame;
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
     *
     * @param currentPosition 이동할 칸의 위치
     * @param bridgeMap       다리의 상태를 기록한 리스트
     */
    public static void printMap(int currentPosition, List<List<String>> bridgeMap) {
        for (int height = 0; height < MAX_HEIGHT; height++) {
            System.out.print(START_ROW);
            System.out.print(String.join(SPLIT_UNIT, bridgeMap.get(height).subList(0, currentPosition)));
            System.out.println(END_ROW);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * @param currentPosition 이동할 칸의 위치
     * @param bridgeGame      bridgeGame 객체(다리 상태와 결과, 시도 횟수를 얻기 위함)
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
