package bridge.UI.Input;

public class CombineInput {
    public void startReadBridgeSize(InputView command) {
        System.out.println(InputString.BRIDGE_SIZE.getMessage());
        command.readBridgeSize();
    }

    public void startReadMoving(InputView command) {
        System.out.println(InputString.PLAYER_CHOICE.getMessage());
        command.readMoving();
    }
    public void startReadGameCommand(InputView command) {
        System.out.println(InputString.RESTART.getMessage());
        command.readGameCommand();
    }

}
