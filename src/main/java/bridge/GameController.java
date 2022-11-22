package bridge;

public class GameController {
    public static void setGame() {
        final OutputView Output = new OutputView();    
        BridgeGame.makeGame(InputView.readBridgeSize());
        while (BridgeGame.playing()) {
            printMove(Output);
            if (BridgeGame.stop()) 
                resetGame(Output);
        }
        Output.printResult(BridgeGame.stop(), BridgeGame.getGameCount());
    }

    public static void printMove(OutputView Output) {
        BridgeGame.move(InputView.readMoving());
        Output.printMap(BridgeGame.getLocation(), BridgeGame.stop());
    }

    public static void resetGame(OutputView Output) {
        String cmd = InputView.readGameCommand();
        if(cmd.equals(Constant.Restart)){
            BridgeGame.retry();
            Output.ResetAll();
        }
    }
}
