package bridge;

import java.util.List;

public class UserConsole {
    /// user console class bridge class  - >  user interaction calss
    private InputView inputView;
    private OutputView outputView;
    private int round;
    private int totalNumber;
    private Bridge bridge;
    private BridgeGame bridgeGame;

    //input view class
    //output view class
    public UserConsole() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        this.round = 0;
        this.totalNumber = 1;
    }

    public void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println(" ");
        bridgeGame.initGame(inputView.readBridgeSize());
    }

    public void startGame() {
        bridge = bridgeGame.getBridgeInstance();
        while (round < bridgeGame.getBridgeSize()) {
            String moveCommand = inputView.readMoving();
            boolean result = bridge.getComparison(round,moveCommand);
            round++;
            move(result,moveCommand);
        }
    }

    public void move(boolean result,String moveCommand) {
        bridgeGame.move(result,moveCommand);
        outputView.printMap(bridgeGame.getUserUpNumbers(),bridgeGame.getUserDownNumbers());
        if (!result) {
            round--;
            retry(inputView.readGameCommand());
        }
    }

    public void endGame() {
        outputView.printResultTotalMap(bridgeGame.getUserUpNumbers(),bridgeGame.getUserDownNumbers());
        outputView.printResultSuccess(round, bridgeGame.getBridgeSize());
        outputView.printResultTotalNumber(totalNumber);
    }

    public void retry(String userInput) {
        if (bridgeGame.retry(userInput)) {
            resetGame();
            startGame();
        }
        if (!bridgeGame.retry(userInput)) {
            round=bridgeGame.getBridgeSize()+1;
        }
    }
    public void resetGame(){
        round = 0;
        totalNumber++;
        bridgeGame.resetUserList();
    }
}
