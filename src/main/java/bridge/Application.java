package bridge;

public class Application {

    public static void main(String[] args) {
        PrintCommand printCommand= new PrintCommand();
        BridgeGame game = new BridgeGame();
        InputView input = new InputView();

        printCommand.gameStart();
        int bridgeLength=input.readBridgeSize();


    }
}
