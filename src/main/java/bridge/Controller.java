package bridge;

public class Controller {
    int gameCount;
    BridgeGame bridgeGame;
    public Controller(){
        this.gameCount = 1;
        bridgeGame = new BridgeGame();
    }
    public void start(){
        OutputView.printGameStart();
        setBridgeSize();
        bridgeGame.setBridge();
        gameStart();
    }
    public void gameStart(){
        run();
        checkRetry();
    }
    private void run(){
        while (bridgeGame.getUserInputSize()< bridgeGame.getBridgeSize()){
            OutputView.printMove();
            boolean moveCheck = bridgeGame.move(InputView.readMoving());
            OutputView.printUpDownBridge(bridgeGame.bridge,bridgeGame.userInput);
            if(!moveCheck){break;}
        }
    }
    private void checkRetry(){
        if(bridgeGame.gameOver()){
            OutputView.printResult(bridgeGame.bridge, bridgeGame.userInput, gameCount);
            return;
        }
        askRetry();
    }
    private void askRetry(){
        OutputView.printRetry();
        String command = InputView.readGameCommand();
        if(bridgeGame.retry(command)){
            gameCount+=1;
            gameStart();
        }
        if(!bridgeGame.retry(command)){
            OutputView.printResult(bridgeGame.bridge,bridgeGame.userInput,gameCount);
        }
    }
    public void setBridgeSize(){
        OutputView.printBridgeSize();
        bridgeGame.setBridgeSize(InputView.readBridgeSize());
        checkBridgeSize(bridgeGame.bridgeSize);
    }
    public void checkBridgeSize(int bridgeSize){
        if(bridgeSize==BridgeStatus.FALSE.getValueInteger()){
            setBridgeSize();
        }
    }
}
