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
    public void mapMessage(BridgeDTO bridgeDTO){
        outputView.printMap(bridgeDTO);
    }
    public void gameSuccessMessage(BridgeDTO bridgeDTO){
        outputView.printSuccessedResult(bridgeDTO);
        gameTriedMessage(bridgeDTO.getCount());
    }
    public void gameFailedMessage(BridgeDTO bridgeDTO){
        outputView.printFailedResult(bridgeDTO);
    }
    public void gameTriedMessage(int gameCount){
        outputView.printGameCount(gameCount);
    }

}
