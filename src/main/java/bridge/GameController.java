package bridge;

public class GameController {
    public static void setGame() {
        final OutputView output = new OutputView(); 
        output.resetAll();   
        BridgeGame.makeGame(InputView.readBridgeSize());
        while (BridgeGame.play()) {
            printMove(output);
            if (BridgeGame.getstop()) 
                resetGame(output);
        }
        output.printResult(BridgeGame.getstop(), BridgeGame.getGameCount());
    }

    public static void printMove(OutputView output) {
        BridgeGame.move(InputView.readMoving());
        output.printMap(BridgeGame.getLocation(), BridgeGame.getstop());
    }

    public static void resetGame(OutputView output) {
        String cmd = InputView.readGameCommand();
        if(cmd.equals(Constant.RESTART)){
            BridgeGame.replay();
            output.resetAll();
        }
    }
}
