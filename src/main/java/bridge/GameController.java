package bridge;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void executeGame() {
        outputView.printOpening();
        bridgeGame = new BridgeGame(makeBridge());
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
            String choice = null;
            try {
                choice = inputView.readMoving();
                bridgeGame.move(choice);
                // bridgeGame.matchResults(); //-> 이걸 출력해야댐 -> OutputView로 넘기기!!
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
                continue;
            }
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
