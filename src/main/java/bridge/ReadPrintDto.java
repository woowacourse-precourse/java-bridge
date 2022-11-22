package bridge;

import java.util.List;

public class ReadPrintDto {
    private InputView inputView;
    private OutputView outputView;
    public ReadPrintDto() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    public void exitPrint(List<List<String>> userMap, boolean exitCode,int cnt) {
        outputView.printResult(userMap, cnt, exitCode);
    }

    public void printTable(List<List<String>> userMap) {
        outputView.printMap(userMap);
    }
    public String inputMove() {
        return inputView.readMoving();
    }
    public String inputCommand() {
        return inputView.readGameCommand();
    }
}
