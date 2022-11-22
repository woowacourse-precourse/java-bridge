package bridge;

import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;


public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        int gameCount = 1;
        OutputView outputView = new OutputView();
        outputView.gameStart();

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        int numberOfTriedAnswers;
        String command = null;
        int a = 0;
        boolean gameQuit = false;
        do {
            String direction = getMoveCommand(outputView, inputView);
            System.out.println("정답개수11");
            System.out.println(numberOfTriedAnswers = BridgeGame.getAnswerCount(direction));

            getPrintMapAfterMove(outputView, bridge, bridgeGame, numberOfTriedAnswers, direction);

            if (!bridgeGame.checkWrongAnswer(upstairsBridge, downstairsBridge)) {
                command = getContinueCommand(outputView, inputView, bridgeGame);
                System.out.println("정답개수22");
                System.out.println(numberOfTriedAnswers);
                System.out.println("게임타운트11");
                System.out.println(gameCount++);
                gameQuit = getGameQuit(gameCount, outputView, bridgeGame, command);
            }
        }
        while (!bridgeGame.getGameCompleteStatus(upstairsBridge, downstairsBridge, size) &&
                !gameQuit);
//        while (!bridgeGame.checkWrongAnswer(upstairsBridge, downstairsBridge)
//                || size > upstairsBridge.size());

        outputView.printResult(upstairsBridge, downstairsBridge, gameCount);
    }

    private static String getMoveCommand(OutputView outputView, InputView inputView) {
        outputView.enterMoveDirection();
        String direction = inputView.readMoving();
        return direction;
    }

    private static String getContinueCommand(OutputView outputView, InputView inputView, BridgeGame bridgeGame) {
        outputView.getRestartButton();
        String command = inputView.readGameCommand();
        getGameRestart(bridgeGame, command);
        return command;
    }

    private static void getPrintMapAfterMove(OutputView outputView, List<String> bridge, BridgeGame bridgeGame, int numberOfTriedAnswers, String direction) {
        bridgeGame.move(direction, bridge, numberOfTriedAnswers);
        outputView.printMap(upstairsBridge, downstairsBridge);
    }

    private static boolean getGameQuit(int gameCount, OutputView outputView, BridgeGame bridgeGame, String command) {
        if (!bridgeGame.retry(command)) {
            System.out.println(bridgeGame.retry(command));
            System.out.println("게임타운트22");
            System.out.println(gameCount = gameCount - 1);
            outputView.printResult(upstairsBridge, downstairsBridge, gameCount);
        }
        return true;
    }

    private static void getGameRestart(BridgeGame bridgeGame, String command) {
        if (bridgeGame.retry(command)) {
            System.out.println(upstairsBridge);
            System.out.println(downstairsBridge);
            bridgeGame.returnToPreviousStatus(upstairsBridge, downstairsBridge);
            System.out.println(upstairsBridge.size());
            System.out.println(downstairsBridge);
        }
    }
}

//게임 카운트 집계 안됨
//게임 실패시 게임 종료 얀됨