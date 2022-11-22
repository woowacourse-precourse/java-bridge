package bridge.controller;

import bridge.model.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    // view 에서 입력받은 값을 model로 전달하는 컨트롤러
    private InputView inputView;
    private OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        int bridgeSize = inputView.readBridgeSize();

        boolean isWinning = doGame(bridgeSize);
        endGame(isWinning);
    }

    private boolean doGame(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        List<String> inputResults = new ArrayList<>();
        boolean isWinning = true;

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = inputView.readMoving();
            inputResults.add(bridgeGame.move(moveAnswer, i));
            outputView.printMap(inputResults, i, moveAnswer);

            if (inputResults.get(i).equals("X")) {
                isWinning = false;
                break;
            }
        }

        return isWinning;
    }

    private void endGame(boolean isWinning) {
        if (isWinning) {
            System.out.print("게임 성공");
            return;
        }

        System.out.print("게임 실패");
    }
}
