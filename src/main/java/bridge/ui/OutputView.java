package bridge.ui;

import bridge.model.Answer;
import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.GameMessage;
import java.util.List;

public class OutputView {

    public void printMap(List<Answer> upperBridge, List<Answer> downBridge) {
        printEachBridge(upperBridge);
        printEachBridge(downBridge);
    }

    public void printResult(String isSuccess, String totalTry) {
        System.out.println(isSuccess);
        System.out.print(totalTry);
    }

    private void printEachBridge(List<Answer> bridge){
        StringBuilder result = new StringBuilder();
        result.append(Bridge.START.getView());
        bridge.forEach(answer -> {
                    result.append(answer.getOutput());
                    result.append(Bridge.MID.getView());
                }
                );
        result.append(Bridge.END.getView());
        System.out.println(result);
    }

}
