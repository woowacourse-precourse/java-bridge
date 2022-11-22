package bridge;

public class TotalViewController {
    private final OutputView outputView;
    private final InputView inputView;
    public TotalViewController(){
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
    public TotalViewController startMessage(){
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
    public TotalViewController gameSuccessMessage(BridgeDTO bridgeDTO){
        outputView.printSuccessResult(bridgeDTO);
        return this;
    }
    public TotalViewController gameFailedMessage(BridgeDTO bridgeDTO){
        outputView.printFailedResult(bridgeDTO);
        return this;
    }
    public void gameTriedMessage(int gameCount){
        outputView.printGameCount(gameCount);
    }

}
