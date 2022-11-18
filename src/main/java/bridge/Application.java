package bridge;

public class Application {

    public static void main(String[] args) {
        PrintCommand printCommand= new PrintCommand();
        printCommand.printGameStart();
        BridgeGame game = new BridgeGame();

    }
}
