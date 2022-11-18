package bridge;

public class Application {

    public static void main(String[] args) {
        PrintCommand printCommand= new PrintCommand();
        printCommand.gameStart();
        BridgeGame game = new BridgeGame();
        InputView input = new InputView();


    }
}
