package bridge;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    private static String UP_BRIDGE = "U";
    private static String DOWN_BRIDGE = "D";
    private static final boolean CORRECT_BRIDGE = true;
    private static final boolean WRONG_BRIDGE = false;
    private static final String OPEN_BRACKET = "[ ";
    private static final String CLOSE_BRACKET = " ]";
    private static final String SEPARATOR = " | ";
    private static final String CORRECT_BRIDGE_RESULT = "O";
    private static final String WRONG_BRIDGE_RESULT = "X";
    private static final String EMPTY_BRIDGE = " ";

    public void printStart() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<Boolean> movingResult) {
        printBridge(getUpperBridge(bridge, movingResult));
        printBridge(getLowerBridge(bridge, movingResult));
        System.out.println();
    }

    private void printBridge(List<String> upperOrLowerBridge) {
        String bridge = upperOrLowerBridge
                .stream()
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(OPEN_BRACKET + bridge + CLOSE_BRACKET);
    }

    private List<String> getLowerBridge(List<String> bridge, List<Boolean> movingResult) {
        List<String> lowerBridgeResult = new LinkedList<>();
        for(int i=0;i< movingResult.size();i++){
            lowerBridgeResult.add(calculateLowerBridge(bridge.get(i), movingResult.get(i)));
        }
        return lowerBridgeResult;
    }

    private List<String> getUpperBridge(List<String> bridge, List<Boolean> movingResult) {
        List<String> upperBridgeResult = new LinkedList<>();
        for(int i=0;i< movingResult.size();i++){
            upperBridgeResult.add(calculateUpperBridge(bridge.get(i), movingResult.get(i)));
        }
        return upperBridgeResult;
    }

    private String calculateLowerBridge(String bridge, boolean move) {
        if(move==CORRECT_BRIDGE && bridge.equals(DOWN_BRIDGE)) {
            return CORRECT_BRIDGE_RESULT;
        }
        if(move==WRONG_BRIDGE && bridge.equals(UP_BRIDGE)) {
            return WRONG_BRIDGE_RESULT;
        }
        return EMPTY_BRIDGE;
    }

    private String calculateUpperBridge(String bridge, boolean move) {
        if(move==CORRECT_BRIDGE && bridge.equals(UP_BRIDGE)){
            return CORRECT_BRIDGE_RESULT;
        }
        if(move==WRONG_BRIDGE && bridge.equals(DOWN_BRIDGE)) {
            return WRONG_BRIDGE_RESULT;
        }
        return EMPTY_BRIDGE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT);
        printMap(bridge, bridgeGame.getMovingResult());
        System.out.println(SUCCESS_OR_FAIL + getGameResult(bridge, bridgeGame.getMovingResult()));
        System.out.println(TOTAL_TRY_COUNT + bridgeGame.getTryCount());
    }

    private String getGameResult(List<String> bridge, List<Boolean> getMovingResult) {
        if(bridge.size() != getMovingResult.size()) {
            return "실패";
        }
        if(getMovingResult.get(getMovingResult.size()-1).equals(WRONG_BRIDGE)){
            return "실패";
        }
        return "성공";
    }
}
