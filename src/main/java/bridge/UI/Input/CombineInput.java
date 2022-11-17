package bridge.UI.Input;

public class CombineInput {

    public int startReadBridgeSize() throws IllegalArgumentException{
        InputView inputView = new InputView();
        System.out.println(InputString.BRIDGE_SIZE.getMessage());
        return inputView.readBridgeSize();
    }

    public String startReadMoving() throws IllegalArgumentException {
        InputView inputView = new InputView();
        System.out.println(InputString.PLAYER_CHOICE.getMessage());
        return inputView.readMoving();
    }
    public String startReadGameCommand() throws IllegalArgumentException {
        InputView inputView = new InputView();
        System.out.println(InputString.RESTART.getMessage());
        return inputView.readGameCommand();
    }

}
