package bridge.controller;

import bridge.view.OutputView;
import bridge.util.Constant;
import bridge.util.GuideMessage;

import java.util.List;
import java.util.Map;

public class OutputController {
    private final OutputView outputView;

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void getChoiceResult(List<String> board, List<String> bridge) {
        outputView.printMap(board, bridge);
    }

    public void getFinalResult(List<String> board, List<String> bridge, Map<String, Integer> resultBoard) {
        String result = GuideMessage.FAIL;
        if (resultBoard.get(Constant.SUCCESS_OR_FAIL) == 1) {
            result = GuideMessage.SUCCESS;
        }

        outputView.endOfGame();
        getChoiceResult(board, bridge);
        outputView.printResult(result, resultBoard.get(Constant.NUMBER_OF_ATTEMPTS));
    }
}
