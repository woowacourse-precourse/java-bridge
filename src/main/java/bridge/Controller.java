package bridge;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;
    public Controller(){
        outputView = new OutputView();
        inputView = new InputView();
    }
    //Input section
    public int inputBridgeSize(){
      return inputView.getBrideSize();
    }
    public String inputMovingCommand(){
        return inputView.getReadMoving();
    }
    public String inputReadGameCommand(){
        return inputView.getRestartCommand();
    }

    //Outview Section
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
    public void mapMessage(BridgeDTO bridgeDTO){
        outputView.printMap(bridgeDTO);
    }
    public Controller gameSuccessMessage(BridgeDTO bridgeDTO){
        outputView.printSuccessResult(bridgeDTO);
        return this;
    }
    public Controller gameFailedMessage(BridgeDTO bridgeDTO){
        outputView.printFailedResult(bridgeDTO);
        return this;
    }
    public void gameTriedMessage(int gameCount){
        outputView.printGameCount(gameCount);
    }

}
