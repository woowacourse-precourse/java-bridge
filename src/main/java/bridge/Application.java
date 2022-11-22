package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeLength = bridgeGame.bridgeLength;

        setUpGame(bridgeGame);
        gamePlay(bridgeGame);
        totalResult(bridgeGame);
    }

        public static void setUpGame(BridgeGame bridgeGame) {
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        System.out.println("다리 건너기 게임을 시작합니다.");

        int bridgelength = inputView.readBridgeSize();

        List<String> bridgeYongJong = bridgeMaker.makeBridge(bridgelength);
        bridgeGame.bridgePosion = bridgeYongJong;

        }

    public static void gamePlay(BridgeGame bridgeGame) {
        InputView inputView = new InputView();
        bridgeGame.trialCount += 1;
        Boolean isQuit;
        Boolean isSuccess;
        while (true) {
            isSuccess = gameMove(bridgeGame);
            if (isSuccess) {
                bridgeGame.isSuccess=isSuccess;
                break;
            }
            isQuit = bridgeGame.retry(inputView.readGameCommand());
            if (isQuit) {
                break;
            }
        }
    }

    public static Boolean gameMove(BridgeGame bridgeGame) {
        InputView input = new InputView();
        int bridgeLength = bridgeGame.bridgeLength;
        Boolean isSuccess;
        for (int i = 0; i < bridgeLength; i++) {
            isSuccess = bridgeGame.move(input.readMoving(), i);
            if (!isSuccess) {
                return false;
            }
        }
        return true;
    }

    public static void totalResult(BridgeGame bridgeGame) {
        OutputView outputView = new OutputView();
        outputView.printResult(bridgeGame.bridgeLength,bridgeGame.bridgePosion,bridgeGame.playerPosion);
    }
}

