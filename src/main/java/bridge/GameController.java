package bridge;

import static bridge.MessageUtil.INVALID_GAME_CMD;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Bridge bridge;
    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void executeGame() {
        outputView.printOpening();
        bridge = makeBridge();
        bridgeGame = new BridgeGame(bridge);
        crossToOtherSide();
    }

    private Bridge makeBridge() {
        outputView.printBrideSizeOpening();
        int bridgeSize = 0;
        try{
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            makeBridge();
        }
        outputView.printEmptyLine();
        return new Bridge(bridgeSize);
    }

    private void crossToOtherSide() {
        while (!bridgeGame.playerHasCrossed()) {
            outputView.printUserChoiceOpening();
            String choice = "";
            try {
                choice = inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
                continue;
            }
            if (!bridgeGame.matches(choice)){
                chooseNextStep();
                continue;
            }
            bridgeGame.move();
        }
    }

    private void chooseNextStep() {
        // 만약 R를 고르면 재시작, Q를 고르면 종료
        String cmd = inputView.readGameCommand();
//        validateCommand(cmd);
//        if (cmd == "R"){
//            bridgeGame.retry();
//        }
        // 종료.... -> 바로 결과 출력 !
    }
}
