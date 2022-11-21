package bridge;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static int trials = 1;

    public void start() {
        outputView.gameStartMessage();
        int size = askBridgeSize();
        List<String> answer_bridge = bridgeMaker.makeBridge(size);
        System.out.println(answer_bridge);
        BridgeGame bridgeGame = new BridgeGame(answer_bridge);
        boolean keepgo = true;
        while (keepgo) {
            move(bridgeGame);//끝까지 성공하거나 중간에 실패하기전까지 이동

            //성공하거나 Q를 입력받으면 false return
            keepgo = successOrRetry(bridgeGame);
            trials++;
        }
    }

    private boolean successOrRetry(BridgeGame bridgeGame) {
        if (bridgeGame.isSuccess()) {
            outputView.printResult("성공", bridgeGame, trials);
            return false;
        }


        String command = askRestart();
        if (command.equals("R")) {
            bridgeGame.retry();
        }

        if (command.equals("Q")) {
            outputView.printResult("실패", bridgeGame, trials);
            return false;
        }
        return true;
    }

    private void move(BridgeGame bridgeGame) {
        boolean isEnd = false;
        while (!isEnd) {
            move1Step(bridgeGame);
            isEnd = bridgeGame.isEnd();
        }
    }

    private void move1Step(BridgeGame bridgeGame) {

        //input move
        String way = askMoving();
        //move
        bridgeGame.move(way);
        //printMap
        outputView.printMap(bridgeGame);

    }

    private int askBridgeSize() {
        try {
            outputView.bridgeSizeMessage();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBridgeSize();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return askBridgeSize();
        }
    }

    private String askMoving() {
        try {
            outputView.moveMessage();//move message 출력
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askMoving();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return askMoving();
        }
    }

    private String askRestart() {
        try {
            outputView.restartMessage();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askRestart();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return askRestart();
        }
    }
}
