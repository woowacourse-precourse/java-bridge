package bridge.output;

import bridge.console.OutputView;
import bridge.data.FinalResult;
import bridge.data.MoveResult;

import java.util.List;

public class ResultDemonstrator {
    private final OutputView outputView;

    public ResultDemonstrator() {
        this.outputView = new OutputView();
    }

    public void printCurrentResult(List<MoveResult> moveResults) {
        this.outputView.printMap(moveResults);
    }

    public void printFinalResult(FinalResult finalResult) {
        this.outputView.printResult(finalResult);
    }
}
