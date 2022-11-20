package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.constant.Constant.*;

public class Controller {

    private final InputView inputView;
    private BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;

    public Controller(InputView inputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker, OutputView outputView) {
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.outputView = outputView;
    }

    void play() {
        String quit;
        outputView.printGameStart();
         do{
            outputView.printBridgeSize();
            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            System.out.println(bridge.toString());

            quit = whileQuitIsR(bridge);
        } while(!quit.equals(QUIT.getValue()));
    }
    public String whileQuitIsR(List<String> bridge) {
        int attempt = 0;
        String failed;
        String quit = RESTART.getValue();
        do {
            failed = crossingBridge(bridge);
            attempt = bridgeGame.retry(attempt, quit);
            quit = askQuit(failed);
        } while (!quit.equals(QUIT.getValue()));
        printResult(failed, attempt);
        return quit;
    }

    public void printResult(String failed, int attempt) {
        outputView.printResult(bridgeGame.getBridges());
        outputView.gameAttemptCount(failed, attempt);
    }
    public String crossingBridge(List<String> bridge) {
        int count = 0;
        bridgeGame = new BridgeGame();
        List<List<String>> bridges = bridgeGame.getBridges();
        while(true) {
            outputView.printWhereToMove();
            String direction = inputView.readMoving();
            count++;
            bridgeGame.move(direction, bridge.get(count-1));
            outputView.printMap(bridges);
            if(!endOfTheGame(bridges, bridge, count).equals("continue")) {
                return endOfTheGame(bridges, bridge, count);
            }
        }
    }

    public String endOfTheGame(List<List<String>> bridges, List<String> bridge,int count) {
        for (List<String> strings : bridges) {
            if (strings.contains(X.getValue())) {
                return "실패";
            }
        }
        if (count == bridge.size()) {
            return "성공";
        }
        return "continue";
    }

    public String askQuit(String failed) {
        String quit;

        if(failed.equals("실패")) {
            outputView.askRestartGame();
            quit = inputView.readGameCommand();
            return quit;
        }
        quit = QUIT.getValue();
        return quit;
    }
}
