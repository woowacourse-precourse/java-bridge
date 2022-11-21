package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<String> bridge;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    private int gameNumber = 0;
    private int gameTryNumber = 1;
    private String gameFlag = "";
    private List<String> movingList = new ArrayList<>();

    public enum GameStatus {
        WIN("WIN"),
        SAFE("SAFE"),
        R("RETRY"),
        Q("QUIT");
        private String status;
        private GameStatus(String status) {
            this.status = status;
        }
    }

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
        if (gameFlag.equals(GameStatus.WIN.status)) {
            outputView.printResult(bridge, movingList, gameTryNumber);
        }
        if (gameFlag.equals(GameStatus.SAFE.status)) {
            gameNumber++;
        }
        if (gameFlag.equals(GameStatus.R.status)) {
            retryGame();
        }
    }

    private void retryGame(){
        String gameCommand = inputView.readGameCommand();
        checkRetryOrQuit(gameCommand);
    }

    private void checkRetryOrQuit(String gameCommand){
        if (gameCommand.equals(GameStatus.R.name())) {
            resetStatus();
        }
        if (gameCommand.equals(GameStatus.Q.name())) {
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
        gameFlag = GameStatus.Q.status;
    }

    private boolean isGameEnd(String gameFlag) {
        if (gameFlag.equals(GameStatus.WIN.status) || gameFlag.equals(GameStatus.Q.status)) {
            return true;
        }
        return false;
    }
}
