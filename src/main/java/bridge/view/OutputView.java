package bridge.view;

import bridge.Bridge;
import bridge.view.utils.CustomStringBuilderForBridge;

import java.util.List;

import static bridge.constant.Constants.SUCCESS_OR_NOT_MESSAGE;
import static bridge.constant.Constants.TOTAL_NUMBER_OF_ATTEMPTS_MESSAGE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, List<String> userAnswer) {
        CustomStringBuilderForBridge stringBuilderBridge = new CustomStringBuilderForBridge();

        stringBuilderBridge.addStartBracket();
        compareUserAndAnswer(bridge, userAnswer, stringBuilderBridge);
        stringBuilderBridge.addEndBracket();
        printUpperAndLowerBridge(stringBuilderBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int attempt) {
        System.out.println(SUCCESS_OR_NOT_MESSAGE + result);
        System.out.println(TOTAL_NUMBER_OF_ATTEMPTS_MESSAGE + attempt);
    }

    public static void printGameMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void compareUserAndAnswer(Bridge bridge, List<String> userAnswer, CustomStringBuilderForBridge stringBuilderBridge) {
        for (int i = 0; i < userAnswer.size(); i++) {
            if (bridge.getBridge().get(i).equals(userAnswer.get(i))) {
                stringBuilderBridge.addO(userAnswer.get(i));
            } else if (!bridge.getBridge().get(i).equals(userAnswer.get(i))) {
                stringBuilderBridge.addX(userAnswer.get(i));
            }
            if (i != userAnswer.size() - 1) {
                stringBuilderBridge.addStick();
            }
        }
    }

    private void printUpperAndLowerBridge(CustomStringBuilderForBridge stringBuilderBridge) {
        System.out.println(stringBuilderBridge.getUpperBridge());
        System.out.println(stringBuilderBridge.getLowerBridge());
        System.out.println();
    }

}
