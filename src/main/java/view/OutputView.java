package view;

import constants.BridgeForm;
import constants.Message;
import constants.Text;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printMessage(Message message) {
        System.out.println(message);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMap(Map<String, List<String>> result) {
        System.out.println(makeMap(result));
    }

    private StringBuilder makeMap(Map<String, List<String>> result) {
        StringBuilder map = new StringBuilder();
        map.append(Text.START_BRIDGE).append(String.join(Text.SEPARATOR, result.get(BridgeForm.UP.getDirection())));
        map.append(Text.END_BRIDGE).append("\n");
        map.append(Text.START_BRIDGE).append(String.join(Text.SEPARATOR, result.get(BridgeForm.DOWN.getDirection())));
        map.append(Text.END_BRIDGE);

        return map;
    }

    public void printResult(Map<String, List<String>> result, String successOrFail, int totalTry) {
        System.out.println(Message.NOTICE_RESULT);
        printMap(result);
        System.out.println(Message.SUCCESS_OR_FAIL + successOrFail);
        System.out.print(Message.TOTAL_TRY);
        System.out.println(totalTry);
    }
}
