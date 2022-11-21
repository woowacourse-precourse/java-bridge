package bridge.view;

import bridge.model.BridgeHistory;

import java.util.List;
import java.util.Map;

import static bridge.commom.constant.LocationTable.getKeyWithIndex;
import static bridge.commom.constant.GameMessage.OutputMessage.*;

public class OutputView {

    public void printGreeting() {
        System.out.println(PRINT_GREETING);
    }

    public void printResult(BridgeHistory bridgeHistory) {
        System.out.println(PRINT_RESULT_HEADER);
        printMap(bridgeHistory);
        System.out.println(getGameStateMessage(bridgeHistory));
        System.out.println(getTotalMessage(bridgeHistory));
    }

    public void printMap(BridgeHistory bridgeHistory) {
        Map<String, List<String>> history = bridgeHistory.getHistory();
        for (int index = 1; index >= 0; index--) {
            printMapByOneLine(history, index);
        }
    }

    private void printMapByOneLine(Map<String, List<String>> history, int index) {
        String key = getKeyWithIndex(index);
        String result = String.join(RESULT_DELIMITER, history.get(key));
        System.out.println(getResult(result));
    }

    private String getGameStateMessage(BridgeHistory bridgeHistory) {
        return IS_SUCCESS + bridgeHistory.getProgress().getMessage();
    }

    private String getTotalMessage(BridgeHistory bridgeHistory) {
        return TOTAL_TRY + bridgeHistory.getRetry();
    }

    private String getResult(String result) {
        return RESULT_OPEN_BRACKET + result + RESULT_CLOSE_BRACKET;
    }
}
