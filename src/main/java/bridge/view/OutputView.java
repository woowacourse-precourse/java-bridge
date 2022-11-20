package bridge.view;

import bridge.domain.Bridge;
import bridge.view.utils.CustomStringBuilderForBridge;

import java.util.List;

import static bridge.constant.Constants.SUCCESS_OR_NOT_MESSAGE;
import static bridge.constant.Constants.TOTAL_NUMBER_OF_ATTEMPTS_MESSAGE;

public class OutputView {

    public void printMap(Bridge bridge, List<String> userAnswer) {
        CustomStringBuilderForBridge stringBuilderBridge = new CustomStringBuilderForBridge();

        stringBuilderBridge.addStartBracket();
        compareUserAndAnswer(bridge, userAnswer, stringBuilderBridge);
        stringBuilderBridge.addEndBracket();
        printUpperAndLowerBridge(stringBuilderBridge);
    }

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
            if (bridge.isSameStringWithUser(i,userAnswer.get(i))) {
                stringBuilderBridge.addO(userAnswer.get(i));
            } else if (!bridge.isSameStringWithUser(i,userAnswer.get(i))) {
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
