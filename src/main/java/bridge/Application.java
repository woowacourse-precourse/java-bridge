package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        try {
            List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            System.out.println(bridge);
            BridgeGame bridgeGame = new BridgeGame();


            OutputView outputView = new OutputView();
            // 0성공, 1실패
            // move의 리턴이 0이라면 게임 move 계속 진행
            int status = 0;
            int stage = 1;
            int trial = 1;
            int success = 0;
            while (status == 0) {
                if (stage == bridge.size() + 1) {
                    success = 1;
                    break;
                }
                status = bridgeGame.move(bridge, stage);
                outputView.printMap(bridge, stage, status);
                stage++;
                if (status == 1) {
                    System.out.println();
                    outputView.printGameOver();
                    if (inputView.readGameCommand().equals("R")) {
                        stage = 1;
                        status = 0;
                        trial++;
                    }
                }
            }
            System.out.println();
            outputView.printResult();
            outputView.printMap(bridge, bridge.size(), 0);

            System.out.println();
            outputView.printSuccess(success);
            outputView.printTrialAmount(trial);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
