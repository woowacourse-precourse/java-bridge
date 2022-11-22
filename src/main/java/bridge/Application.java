package bridge;

import java.util.List;

public class Application {

    private static String output;
    private static GameStart gameStart;
    public static int ManageGame(List<String> Bridge,OutputView outputView) {
        boolean reGame = true;
        do {
            BridgeGame bridgeGame = new BridgeGame(Bridge);
            gameStart = new GameStart(bridgeGame);
            reGame = gameStart.getReGame();
        } while (reGame);
        output = (gameStart.Success(Bridge.size()));
        int tryNum = gameStart.getTryNum();
        outputView.printResultMap(gameStart.getBridgeGame());
        return tryNum;
    }


    public static void ManageGameSettings(int size) {
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> Bridge = bridgeMaker.makeBridge(size);
        int tryNum = ManageGame(Bridge,outputView);
        outputView.printResult(tryNum, output);
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView SizeInputView = new InputView();
        int size = SizeInputView.readBridgeSize();
        ManageGameSettings(size);
    }

