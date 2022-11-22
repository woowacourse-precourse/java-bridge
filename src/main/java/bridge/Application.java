package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.");

        int bridgelength = inputView.readBridgeSize();
        List<String> bridgeYongJong = bridgeMaker.makeBridge(bridgelength);
//        System.out.println(bridgeYongJong);
        bridgeGame.bridgePosion= bridgeYongJong;
        bridgeGame.trialCount+=1;

        gameInit(bridgeGame, bridgelength);


    }

    private static void gameInit(BridgeGame bridgeGame, int bridgelength) {
        InputView inputView = new InputView();
        Boolean isQuit;
        Boolean isSuccess;
        while(true){
            isSuccess = gameMove(bridgeGame, bridgelength);
            if(isSuccess){
                break;
            }
            isQuit = bridgeGame.retry(inputView.readGameCommand());
            if(isQuit){
                break;
            }
        }
    }

    private static Boolean gameMove(BridgeGame bridgeGame, int bridgelength) {
        InputView input = new InputView();
        Boolean isSuccess;
        for (int i = 0; i < bridgelength; i++) {
            isSuccess = bridgeGame.move(input.readMoving(), i);

        }
    }
}
