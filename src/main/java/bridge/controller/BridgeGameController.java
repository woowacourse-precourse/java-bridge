package bridge.controller;

import bridge.model.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    // view 에서 입력받은 값을 model로 전달하는 컨트롤러
    private final InputView INPUT_VIEW;
    private final OutputView OUTPUT_VIEW;
    private BridgeGame bridgeGame;
    private int count;

    public BridgeGameController() {
        this.INPUT_VIEW = new InputView();
        this.OUTPUT_VIEW = new OutputView();
        this.count = 0;
    }

    public void startGame(boolean isReGame) {
        if (isReGame) {
            endGame(doGame(bridgeGame.getBridge().getBridge().size()));
            return;
        }
        int bridgeSize = INPUT_VIEW.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);

        endGame(doGame(bridgeSize));
    }

    private boolean doGame(int bridgeSize) {
        List<String> inputResults = new ArrayList<>();

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = INPUT_VIEW.readMoving();
            inputResults.add(bridgeGame.move(moveAnswer, i));   // 모델로 가야하는 코드
            OUTPUT_VIEW.printMap(inputResults, i, moveAnswer);

            if (inputResults.get(i).equals("X")) {  // 모델에서 처리
                count++;
                return false;
            }
        }

        count++;
        return true;
    }

    private void endGame(boolean isWinning) {
        OUTPUT_VIEW.printResult(isWinning);
        String retryAnswer = INPUT_VIEW.readGameCommand();
        if (bridgeGame.retry(retryAnswer)) {
            startGame(true);   // 하드코딩 수정하기
        }
        OUTPUT_VIEW.printCountResult(count);
    }
}
