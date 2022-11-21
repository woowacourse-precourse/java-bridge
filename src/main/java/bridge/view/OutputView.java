package bridge.view;

import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String LOSE_SYMBOL = "X";

    private static final String LINE_SPACE = "";
    private static final String INTRO = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_START_SYMBOL = "[ ";
    private static final String BRIDGE_END_SYMBOL = " ]\n";
    private static final String BRIDGE_SPACE_SIGN = " | ";
    private static final String GAME_RESULT_INTRO = "최종 게임 결과\n";
    private static final String GAME_WIN_OR_LOSE_INTRO = "게임 성공 여부: ";
    private static final String TRY_NUMBER_INTRO = "총 시도한 횟수: ";
    private static final String WIN = "성공";
    private static final String LOSE = "실패";

    public static void printStart() {
        System.out.println(INTRO);
        System.out.println(LINE_SPACE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upperBridge, List<String> lowerBridge) {

        System.out.print(BRIDGE_START_SYMBOL);
        System.out.print(printUpper(upperBridge));
        System.out.print(BRIDGE_END_SYMBOL);
        System.out.print(BRIDGE_START_SYMBOL);
        System.out.print(printLower(lowerBridge));
        System.out.print(BRIDGE_END_SYMBOL);
    }

    public static String printUpper(List<String> upperBridge) {;
        return String.join(BRIDGE_SPACE_SIGN, upperBridge);
    }

    public static String printLower(List<String> lowerBridge) {
        return String.join(BRIDGE_SPACE_SIGN, lowerBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        if (printWinOrLose(bridgeGame).equals(WIN)) {
            System.out.println(LINE_SPACE);
        }
        System.out.print(GAME_RESULT_INTRO);
        printMap(bridgeGame.upperBridge, bridgeGame.lowerBridge);
        System.out.println(LINE_SPACE);
        System.out.print(GAME_WIN_OR_LOSE_INTRO);
        System.out.println(printWinOrLose(bridgeGame));
        System.out.print(TRY_NUMBER_INTRO);
        System.out.print(bridgeGame.attempt);
    }

    public static String printWinOrLose(BridgeGame bridgeGame) {
        int bridgeIndex = bridgeGame.bridgeIndex - 1;

        if (bridgeGame.upperBridge.get(bridgeIndex).equals(LOSE_SYMBOL)) {
            return LOSE;
        }
        if (bridgeGame.lowerBridge.get(bridgeIndex).equals(LOSE_SYMBOL)) {
            return LOSE;
        }
        return WIN;
    }
}
