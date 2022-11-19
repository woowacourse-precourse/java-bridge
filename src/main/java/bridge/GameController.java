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
                bridgeGame.move(choice); //얘가 책임질 범위?? -> [--일단 움직이기--], 움직이고 나서 결과 비교하고 출력하기, 그 결과에 따라서 게임 재시
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
