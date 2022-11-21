package bridge;

public class Application {

    private static BridgeGame initiate(){
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);

        OutputView.printStart();
        System.out.println();

        OutputView.printInputBridgeSize();
        BridgeGame game = new BridgeGame(maker.makeBridge(InputView.readBridgeSize()));
        System.out.println();
        return game;
    }

    private static String startLoop(BridgeGame game){
        String last ="";
        while(true){
            if(actLoopContent(game, last)){
                break;
            }
        }
        return last;
    }

    private static boolean actLoopContent(BridgeGame game, String last){
        OutputView.printInputForward();
        last = InputView.readMoving();
        String result = game.judge(last);
        if(actIfRight(game,last,result)){   //true 게임 완료 종료
            return true;
        }
        if(actIfWrong(game,last,result)){   //true 게임 재시도 x 종료
            return true;
        }
        return false;
    }

    private static boolean actIfRight(BridgeGame game, String last, String result){
        if(result.equals("O")){
            OutputView.printMap(game, last);
            return game.isGameWin(last);
        }
        return false;
    }

    private static boolean actIfWrong(BridgeGame game, String last, String result){
        if(result.equals("X")) {
            OutputView.printMap(game, last);
            OutputView.printIsGameRetry();
            if (InputView.readGameCommand().equals("Q")) {
                return true;
            }
            System.out.println();
            game.retry();
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame game = initiate();
        String last = startLoop(game);
        OutputView.printResult(game,last);
    }
}
