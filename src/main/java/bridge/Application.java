package bridge;

import bridge.domain.BridgeGame;
import bridge.type.Bridge;
import bridge.type.Result;
import bridge.type.TextType;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        /**
         * 초기 시작
         */
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printStart();
        outputView.printSize();
        int size = 0;
        boolean pass = false;
        while (!pass) {
            try {
                size = inputView.readBridgeSize();
                pass = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridges = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridges);

        /**
         * 게임 플레이
         */

        while (true) {
            List<Bridge> results = bridgeGame.getResults();

            pass = false;
            outputView.printMove();
            String move = "";
            while (!pass){
                try {
                    move = inputView.readMoving();
                    pass =true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            boolean correct = bridgeGame.move(move);

            outputView.printMap(results);
            if (!correct) {
                outputView.printRestart();
                pass = false;
                String command = "";
                while (!pass) {
                    try {
                        command = inputView.readGameCommand();
                        pass = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (command.equals(TextType.RESTART.getText())) {
                    bridgeGame.retry();
                    continue;
                } else if (command.equals(TextType.EXIT.getText())) {
                    outputView.printResult(results, Result.FAIL,bridgeGame.getTryCount());
                }
                break;
            }

            if (bridgeGame.getPos() == bridgeGame.getBridges().size()) {
                outputView.printResult(results, Result.SUCCESS,bridgeGame.getTryCount());
                break;
            }
        }
    }
}
