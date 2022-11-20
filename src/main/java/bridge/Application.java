package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);

        OutputView.printStart();
        System.out.println();

        OutputView.printInputBridgeSize();
        BridgeGame game = new BridgeGame(maker.makeBridge(InputView.readBridgeSize()));
        System.out.println();

        String last, result;
        while(true){
            OutputView.printInputForward();
            last = InputView.readMoving();
            result = game.judge(last);
            if(result.equals("O")){
                OutputView.printMap(game, last);
                if(game.isGameWin(last))
                    break;
                continue;
            }
            if(result.equals("X")) {
                OutputView.printMap(game, last);
                OutputView.printIsGameRetry();
                if (InputView.readGameCommand().equals("R")) {
                    System.out.println();
                    game.retry();
                    continue;
                }
            }
            break;
        }
        OutputView.printResult(game,last);
    }
}
