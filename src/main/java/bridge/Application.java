package bridge;

public class Application {
    static int gameCnt = 1;
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame(inputView, bridgeMaker, outputView);
        while(bridgeGame.startGame()){
            gameCnt++;
            bridgeGame = new BridgeGame(inputView, bridgeMaker, outputView);
        }
        outputView.printGameCnt(gameCnt);


    }
}
