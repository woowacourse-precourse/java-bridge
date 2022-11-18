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
        makeBridge();
        crossToOtherSide();
    }

    private void makeBridge() {
        outputView.printBrideSizeOpening();
        try {
            bridge = new Bridge(inputView.readBridgeSize());
            outputView.printEmptyLine();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            makeBridge();
        }
        bridgeGame = new BridgeGame(bridge);
    }

    private void crossToOtherSide() {
        while (!bridgeGame.hasCrossed()) {
            outputView.printUserChoiceOpening();
            String choice = inputView.readMoving();
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
        validateCommand(cmd);
//        if (cmd == "R"){
//            bridgeGame.retry();
//        }
        // 종료.... -> 바로 결과 출력 !
    }

    private void validateCommand(String cmd) {
        if (!cmd.matches("^[RQ]$")){
            throw new IllegalArgumentException(INVALID_GAME_CMD.message);
        }
    }
}
