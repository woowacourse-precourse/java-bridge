package bridge.view;


import java.util.List;
import java.util.StringJoiner;

import static bridge.message.OutputMessage.GAME_START;
import static bridge.message.OutputMessage.FINAL_GAME_RESULT;
import static bridge.message.OutputMessage.SUCCESS_OR_FAILURE;
import static bridge.message.OutputMessage.TOTAL_NUMBER_OF_ATTEMPTS;
import static bridge.util.View.DELIMITER;
import static bridge.util.View.VIEW_PREFIX;
import static bridge.util.View.VIEW_SUFFIX;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printDivisionLine() {
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeMap) {
        StringJoiner stringJoiner = initStringJoiner();
        for (List<String> partOfBridge : bridgeMap) {

            for (String bridgeOfPosition : partOfBridge) {
                stringJoiner.add(bridgeOfPosition);
            }

            System.out.println(stringJoiner);
            stringJoiner = initStringJoiner();
        }
    }

    private StringJoiner initStringJoiner() {
        return new StringJoiner(DELIMITER, VIEW_PREFIX, VIEW_SUFFIX);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridgeMap, String clearMessage, int tryCount) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridgeMap);

        printDivisionLine();

        System.out.println(SUCCESS_OR_FAILURE + clearMessage);
        System.out.println(TOTAL_NUMBER_OF_ATTEMPTS + tryCount);
    }
}
