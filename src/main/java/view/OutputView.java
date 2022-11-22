package view;

import static bridge.constant.GameMessage.GAME_RESULT_MESSAGE;
import static bridge.constant.GameMessage.GAME_SUCCESS_OR_FAILURE_MESSAGE;
import static bridge.constant.GameMessage.TOTAL_NUMBER_OF_ATTEMPTS_MESSAGE;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String>[] bridgeMove) {
        List<String> upperBridgeMove = bridgeMove[0];
        List<String> lowerBridgeMove = bridgeMove[1];
        System.out.println(addMap(upperBridgeMove));
        System.out.println(addMap(lowerBridgeMove));
        System.out.println();
    }

    private String addMap(List<String> bridgeMove) {
        String map = "[";
        for (String correct : bridgeMove) {
            map = map + (" " + correct + " |");
        }
        int size = map.length();
        map = map.substring(0, size - 1) + "]";
        return map;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String>[] bridgeMove, String successful, int count) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(addMap(bridgeMove[0]));
        System.out.println(addMap(bridgeMove[1]));
        System.out.println(GAME_SUCCESS_OR_FAILURE_MESSAGE + successful);
        System.out.println(TOTAL_NUMBER_OF_ATTEMPTS_MESSAGE + count);
    }

    public void printException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
