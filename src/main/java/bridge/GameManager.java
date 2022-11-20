package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final String WIN = "WIN";
    private final String SAFE = "SAFE";
    private final String RETRY = "RETRY";
    private final String QUIT = "QUIT";
    private int gameNumber = 0;
    private int gameTryNumber = 1;
    private String gameFlag = "";
    private List<String> movingList = new ArrayList<>();

    private final List<String> bridge;

    public GameManager(List<String>  bridge) {
        this.bridge = bridge;
    }

    public void gameStart() {
        while (!isGameEnd(gameFlag)) {
            gameFlag = oneMove(movingList, gameNumber, bridge);
            checkStatus();
        }
    }

    private String oneMove(List<String> movingList, int gameNumber, List<String> bridge) {
        String moving = inputView.readMoving();
        movingList.add(moving);
        String gameFlag = bridgeGame.move(bridge, moving, gameNumber);
        outputView.makeMap(bridge, movingList);
        return gameFlag;
    }

    private void checkStatus(){
        if (gameFlag.equals(WIN)) {
            outputView.printResult(bridge, movingList, gameTryNumber);
        }
        if (gameFlag.equals(SAFE)) {
            gameNumber++;
        }
        if (gameFlag.equals(RETRY)) {
            retryGame();
        }
    }

    private void retryGame(){
        String gameCommand = inputView.readGameCommand();
        checkRetryOrQuit(gameCommand);
    }

    private void checkRetryOrQuit(String gameCommand){
        if (gameCommand.equals("R")) {
            resetStatus();
        }
        if (gameCommand.equals("Q")) {
            quitGame();
        }
    }

    private void resetStatus(){
        gameNumber = 0;
        gameTryNumber++;
        movingList = new ArrayList<>();
    }

    private void quitGame(){
        outputView.printResult(bridge, movingList, gameTryNumber);
        gameFlag = QUIT;
    }

    private boolean isGameEnd(String gameFlag) {
        if (gameFlag.equals(WIN) || gameFlag.equals(QUIT)) {
            return true;
        }
        return false;
    }
}
