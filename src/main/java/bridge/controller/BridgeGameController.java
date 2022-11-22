package bridge.controller;

import bridge.model.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final InputView INPUT_VIEW;
    private final OutputView OUTPUT_VIEW;
    private BridgeGame bridgeGame;
    private int count;

    public BridgeGameController() {
        this.INPUT_VIEW = new InputView();
        this.OUTPUT_VIEW = new OutputView();
        this.count = 0;
    }

    public void startGame() {
        int bridgeSize = INPUT_VIEW.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);

        doGame(bridgeSize);
    }

    private void doGame(int bridgeSize) {
        List<String> upResults = new ArrayList<>();
        List<String> downResults = new ArrayList<>();

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = INPUT_VIEW.readMoving();

            if (moveAnswer.equals("U")) {
                upResults.add(bridgeGame.move(moveAnswer, i));
                downResults.add(" ");
            } else {
                downResults.add(bridgeGame.move(moveAnswer, i));
                upResults.add(" ");
            }

            OUTPUT_VIEW.printMap(upResults, downResults, i);

            if (upResults.get(i).equals("X") || downResults.get(i).equals("X")) {  // 모델에서 처리
                count++;
                String retryAnswer = INPUT_VIEW.readGameCommand();

                if (retryAnswer.equals("R")) {
                    doGame(bridgeSize);
                } else {
                    endGame(false, bridgeSize, upResults, downResults);
                }

                return;
            }
        }

        count++;
        endGame(true, bridgeSize, upResults, downResults);
    }

    private void endGame(boolean isWinning, int bridgeSize, List<String> upResults, List<String> downResults) {
        System.out.println("최종 게임 결과");
        OUTPUT_VIEW.printMap(upResults, downResults, bridgeSize - 1);
        OUTPUT_VIEW.printResult(isWinning, count, bridgeSize);
    }
}
