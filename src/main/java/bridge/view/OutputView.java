package bridge.view;

import bridge.view.stringenum.PrintMessage;
import bridge.util.MapConverter;
import java.util.List;

public class OutputView {

    public void printMap(List<List<String>> moveResult) {
        moveResult.forEach(this::printEachMap);
        System.out.println();
    }

    public void printResult(List<List<String>> moveResult, int tryCount, boolean isSuccess) {
        System.out.println(PrintMessage.END.print());
        printMap(moveResult);
        printFinalGameResult(tryCount, isSuccess);
    }

    public void printStart() {
        System.out.println(PrintMessage.START.print() + "\n");
    }

    private void printEachMap(List<String> crossedBridge) {
        System.out.println(MapConverter.convertToMap(crossedBridge));
    }

    private void printFinalGameResult(int tryCount, boolean isSuccess) {
        System.out.println(PrintMessage.RESULT.print(isSuccess));
        System.out.println(PrintMessage.TRY.print(tryCount));
    }
}
