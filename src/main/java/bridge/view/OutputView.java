package bridge.view;

import bridge.domain.BridgeLocation;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String FINAL_TEST_RESULT = "\n최종 게임 결과";
    private static final String NUMBER_OF_TRY_RESULT = "총 시도한 횟수: %d";
    private static final String GAME_SUCCESS_OR_NOT = "\n게임 성공 여부: %s";
    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<BridgeLocation> bridgeLocations) {
        return new StringJoiner("\n")
                .add(createBridgeMap(bridgeLocations, UP_BRIDGE))
                .add(createBridgeMap(bridgeLocations, DOWN_BRIDGE)).toString();
    }

    private String createBridgeMap(List<BridgeLocation> bridgeLocations, String location) {
        StringJoiner bridge = new StringJoiner(" | ", "[ ", " ]");
        bridgeLocations.stream()
                .map(bridgeLocation -> bridgeLocation.getStateLocation(location))
                .forEach(bridge::add);
        return bridge.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printResult(List<BridgeLocation> bridgeLocations, int numberOfTry) {
        StringJoiner stringJoiner = new StringJoiner("\n").add(FINAL_TEST_RESULT);
        stringJoiner.add(printMap(bridgeLocations));
        stringJoiner.add(successGame(bridgeLocations));
        stringJoiner.add(String.format(NUMBER_OF_TRY_RESULT, numberOfTry));
        return stringJoiner.toString();
    }

    private String successGame(List<BridgeLocation> bridgeLocations) {
        int compareIndex = bridgeLocations.size() - 1;
        if (bridgeLocations.get(compareIndex).getCorrectLocation()) {
            return String.format(GAME_SUCCESS_OR_NOT, GAME_SUCCESS);
        }
        return String.format(GAME_SUCCESS_OR_NOT, GAME_FAIL);
    }

}
