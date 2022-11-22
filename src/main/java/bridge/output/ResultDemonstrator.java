package bridge.output;

import bridge.console.OutputView;
import bridge.data.FinalResult;
import bridge.data.MoveResult;

import java.util.List;

public class ResultDemonstrator {
    private static ResultDemonstrator instance;

    private final OutputView outputView;

    private ResultDemonstrator() {
        this.outputView = new OutputView();
    }

    public static ResultDemonstrator getResultDemonstrator() {
        if (instance == null) {
            instance = new ResultDemonstrator();
        }
        return instance;
    }

    public void printCurrentResult(List<MoveResult> moveResults) {
        this.outputView.printMap(moveResults);
    }

    public void printFinalResult(FinalResult finalResult) {
        this.outputView.printResult(finalResult);
    }
}
