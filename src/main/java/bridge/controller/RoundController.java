package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class RoundController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public boolean start(int roundCnt, Bridge bridge){
        outputView.printInputMoveOptionGuide();
        String movingOption = inputView.readMoving();
        // 결과 출력
        return bridge.isCorrect(roundCnt, movingOption);
    }

}
