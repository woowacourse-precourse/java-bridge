package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String DELIMITER = " | ";
    public static final String PREFIX = "[ ";
    public static final String SUFFIX = " ]";
    public static final String GAME_RESULTS = "최종 게임 결과";
    public static final String GAME_CLEARED = "게임 성공 여부: ";
    public static final String TOTAL_ATTEMPT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        BridgeMap bridgeMap = bridgeGame.getBridgeMap();

        List<String> upperRow = bridgeMap.getUpperRow();
        List<String> lowerRow = bridgeMap.getLowerRow();

        printRowWithPrefixAndSuffix(joinByDelimiter(upperRow));
        printRowWithPrefixAndSuffix(joinByDelimiter(lowerRow));
        System.out.println();
    }

    private static String joinByDelimiter(List<String> row) {
        return String.join(DELIMITER, row);
    }

    private static void printRowWithPrefixAndSuffix(String row) {
        System.out.println(PREFIX + row + SUFFIX);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULTS);
        printMap(bridgeGame);
        String result = getResult(bridgeGame);
        System.out.println(GAME_CLEARED + result);
        System.out.println(TOTAL_ATTEMPT + bridgeGame.getAttempt());
    }

    private String getResult(BridgeGame bridgeGame) {
        if (bridgeGame.isGameClear()) {
            return "성공";
        }
        return "실패";
    }
}
