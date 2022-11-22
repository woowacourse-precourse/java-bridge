package bridge;

import java.util.List;

public class GameService {
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static ErrorCheck errorCheck = new ErrorCheck();
    static int indexOfBridge = 0;
    static int gameTryNumber = 1;
    static String correctOrFailSign = "";
    static List<String> bridges;
    static boolean gameStartOrNot = true;
    static boolean stillgameSign;

    public void playGame(int size) {
        bridges = bridgeMaker.makeBridge(size);    // 다리 "UDU" String 으로 List에 담김
        while (gameStartOrNot && indexOfBridge < size) {
            String upOrDown = printUpOrDownMessageAndInput();
            bridgeMove(upOrDown);
            reOrQuit();
            indexOfBridge++;
        }
        showResult();
    }

    public void showResult() {
        outputView.printfinalResult();
        outputView.printMap(bridges, correctOrFailSign);
        if (correctOrFailSign.contains("X")) {
            outputView.printResult("실패", gameTryNumber - 1);
        } else {
            outputView.printResult("성공", gameTryNumber);
        }
    }

    public String printUpOrDownMessageAndInput() {
        outputView.printUpOrDownMessage();
        boolean moveRightSign = false;
        String upOrDown = "";
        while (!moveRightSign) {
            upOrDown = inputView.readMoving();
            moveRightSign = errorCheck.errorCheckReadMovig(upOrDown);
        }
        return upOrDown;
    }

    public void bridgeMove(String upOrDown) {
        stillgameSign = bridgeGame.move(bridges, upOrDown, indexOfBridge);
        if (!stillgameSign) {
            correctOrFailSign += "X";
        } else {
            correctOrFailSign += "O";
        }
        outputView.printMap(bridges, correctOrFailSign);
    }

    public void reOrQuit() {
        if (!stillgameSign) {
            reOrQuitMessageAndInput();
            gameTryNumber++;
        }
    }

    public void reOrQuitMessageAndInput() {
        outputView.printReOrStart();
        String reOrquit = "";
        boolean reorNotSign = false;
        while (!reorNotSign) {
            reOrquit = inputView.readGameCommand();
            reorNotSign = errorCheck.errorCheckReadGameCommand(reOrquit);
        }
        gameStartOrNot = bridgeGame.retry(reOrquit);
    }
}
