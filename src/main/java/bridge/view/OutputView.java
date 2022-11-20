package bridge.view;

import bridge.constant.message.OutputViewMessage;
import bridge.constant.utils.MessageFormatUtil;
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
    public static void printMap(List<List<String>> bridgeMap) {
        for (List<String> side : bridgeMap) {
            String format = MessageFormatUtil.START_BRACKET
                    + String.join(MessageFormatUtil.VERTICAL_BAR, side)
                            + MessageFormatUtil.END_BRACKET;
            System.out.println(format);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> bridgeMapFormat, String successOrNot, int numberOfAttempts) {
        System.out.println(OutputViewMessage.FINAL_GAME_RESULT);
        printMap(bridgeMapFormat);
        System.out.println(OutputViewMessage.GAME_SUCCESS_OR_NOT + successOrNot);
        System.out.println(OutputViewMessage.TOTAL_NUMBER_OF_ATTEMPTS + numberOfAttempts + "\n");

    }

    public static void printGameStart() {
        System.out.println(OutputViewMessage.GAME_START_NOTICE);
    }
}
