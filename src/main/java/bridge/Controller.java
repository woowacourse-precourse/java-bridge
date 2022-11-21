package bridge;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;
    public Controller(){
        outputView = new OutputView();
        inputView = new InputView();
    }
    public int inputBridgeSize(){
      return inputView.readBridgeSize();
    }
    public String inputMovingCommand(){
        return inputView.readMoving();
    }
    public String inputReadGameCommand(){
        return inputView.readGameCommand();
    }
    public Controller startMessage(){
        outputView.printStart();
        return this;
    }
    public void bridgeSizeMessage(){
        outputView.printAskBridgeLength();
    }
    public void movingCommandMessage(){
        outputView.printAskMovingButton();
    }
    public void gameRetriedMessage(){
        outputView.printAskGameRestart();
    }
    public void mapMessage(int [] upCase, int [] downCase, int bridgeLength){
        outputView.printMap(upCase, downCase, bridgeLength);
    }
    public void gameSuccessMessage(int [] upCase, int [] downCase, int gameCount){
        outputView.printSuccessedResult(upCase, downCase);
        gameTriedMessage(gameCount);
    }
    public void gameFailedMessage(int [] upCase, int [] downCase, int bridgeLength){
        outputView.printFailedResult(upCase, downCase, bridgeLength);
    }
    public void gameTriedMessage(int gameCount){
        outputView.printGameCount(gameCount);
    }

}
