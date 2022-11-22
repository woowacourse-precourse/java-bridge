package bridge;

public class GameController {
    public static void setGame() {
        final OutputView Output = new OutputView(); 
        Output.ResetAll();   
        BridgeGame.makeGame(InputView.readBridgeSize());
        while (BridgeGame.play()) {
            printMove(Output);
            if (BridgeGame.getstop()) 
                resetGame(Output);
        }
        Output.printResult(BridgeGame.getstop(), BridgeGame.getGameCount());
    }

    public static void printMove(OutputView Output) {
        BridgeGame.move(InputView.readMoving());
        Output.printMap(BridgeGame.getLocation(), BridgeGame.getstop());
    }

    public static void resetGame(OutputView Output) {
        String cmd = InputView.readGameCommand();
        if(cmd.equals(Constant.RESTART)){
            BridgeGame.replay();
            Output.ResetAll();
        }
    }
}
