package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        gameStart(inputView,outputView);
    }

    public static void gameStart(InputView inputView, OutputView outputView){
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        String retry = "R";
        while(retry.equals("R")){
            continueGame(bridgeGame,inputView,outputView);
            retry = retry(bridgeGame, inputView);
        }
        outputView.printResult(bridgeGame);
    }

    public static String retry(BridgeGame bridgeGame, InputView inputView){
        String retry = "Q";
        if(!bridgeGame.isMoveOk()) {
            retry = inputView.readGameCommand();
            if(retry.equals("R"))
                bridgeGame.retry();
        }
        return retry;
    }

    public static void continueGame(BridgeGame bridgeGame, InputView inputView, OutputView outputView){
        while (!bridgeGame.isGameOver()){
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
        }
    }
}
