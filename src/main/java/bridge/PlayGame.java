package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    private static boolean Playing = true;
    private static int total = 1;
    private static int count = 1;
    private static int index;
    private static String answer = "";

    OutputView outputView;
    InputView inputView;
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    BridgeMaker bridgemaker;
    BridgeGame bridgeGame;
    List<String> Bridge;

    public PlayGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgemaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridgeGame = new BridgeGame(this);
        this.Bridge = new ArrayList<>();
    }

    public int sizeStart() {
        outputView.printStart();
        outputView.printInputSize();
        return inputView.readBridgeSize();
    }

    public void upTotal() {
        total++;
    }

    public void changePlayingState(boolean state) {
        Playing = state;
    }

    public String moveStart(String result, List<String> Bridge) {
        outputView.printMoving();
        String inputMoving = inputView.readMoving();
        index = count - 1;
        return checkMove(result, Bridge, inputMoving);
    }

    public String checkMove(String result, List<String> Bridge, String inputMoving) {
        if (bridgeGame.move(Bridge.get(index), inputMoving)) {
            return result = outputView.printMap(result, inputMoving, count);
        }
        result = outputView.printFailMap(result, inputMoving, count);
        return checkReGameAnswer(result);
    }

    public String checkReGameAnswer(String result) {
        String regameanswer = reGameAnswer();
        if (regameanswer.equals("R")) {
            return bridgeGame.retry();
        }
        count = 1;
        return bridgeGame.gameOver(result);
    }

    public String reGameAnswer() {
        outputView.printReGame();
        String regame = inputView.readGameCommand();
        return regame;
    }

    public void setBridge() {
        int size = sizeStart();
        this.Bridge = bridgemaker.makeBridge(size);
    }

    public void Startgame() {

        setBridge();
        run();
    }

    public void run() {
        while (Playing) {
            answer = moveStart(answer, this.Bridge);
            if (isEqualsAnswer(answer)) {
                continue;
            }
            if (checkWinCondition()) {
                return;
            }
            count++;
        }
        outputView.printResult(answer, total, false);
        return;
    }

    public boolean isEqualsAnswer(String answer) {
        if (answer.equals("")) {
            count = 1;
            return true;
        }
        return false;
    }

    public boolean checkWinCondition() {
        if (count == Bridge.size()) {
            outputView.printResult(answer, total, true);
            return true;
        }
        return false;
    }
}



