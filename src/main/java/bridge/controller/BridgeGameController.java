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

    public BridgeGameController() {
        this.INPUT_VIEW = new InputView();
        this.OUTPUT_VIEW = new OutputView();
    }

    public void startGame() {
        int bridgeSize = INPUT_VIEW.readBridgeSize();
        endGame(doGame(bridgeSize));
    }

    private boolean doGame(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        List<String> inputResults = new ArrayList<>();

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = INPUT_VIEW.readMoving();
            inputResults.add(bridgeGame.move(moveAnswer, i));
            OUTPUT_VIEW.printMap(inputResults, i, moveAnswer);

            if (inputResults.get(i).equals("X")) {
                return false;
            }
        }

        return true;
    }

    private void replayGame() {
    }

    private void endGame(boolean isWinning) {
        System.out.print("게임 성공 여부: ");
        if (isWinning) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
            String retryAnswer = INPUT_VIEW.readGameCommand();
            if (retryAnswer.equals("R")) {
                replayGame();
            }
        }
        System.out.print("총 시도한 횟수: ");
    }
}
