package bridge.controller;

import bridge.model.Record;
import bridge.util.Constant;
import bridge.util.GuideMessage;
import bridge.view.OutputView;

import java.util.List;

public class OutputController {
    private final OutputView outputView;

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void getChoiceResult(Record record, List<String> bridge) {
        outputView.printMap(record, bridge);
    }

    public void getFinalResult(Record record, List<String> bridge) {
        String result = GuideMessage.FAIL;
        if (record.equalsToResultBoard(Constant.SUCCESS_OR_FAIL, 1)) {
            result = GuideMessage.SUCCESS;
        }
        outputView.endOfGame();
        getChoiceResult(record, bridge);
        outputView.printResult(result, record.getValueByKey(Constant.NUMBER_OF_ATTEMPTS));
    }
}
