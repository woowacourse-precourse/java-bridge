package bridge;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    OutputView outputView;

    void play() {
        String quit = "R";
        System.out.println("겜 시작");
        while(!quit.equals("Q")) {
            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            System.out.println(bridge.toString());

            quit = whileQuitIsR(quit, bridge);


        }
    }
    public String whileQuitIsR(String quit, List<String> bridge) {
        int attempt = 1;
        boolean failed;
        while(quit.equals("R")) {
            outputView = new OutputView();
            bridgeGame = new BridgeGame();
            List<List<String>> bridges = bridgeGame.getBridges();
            failed = crossingBridge(bridges, bridge);
            quit = askQuit(bridges,failed, attempt);
            if(quit.equals("Q")) {
                break;
            }
        }
        return quit;
    }

    public boolean crossingBridge(List<List<String>> bridges, List<String> bridge) {
        int count = 0;
        while(true) {

            String direction = inputView.readMoving();
            count++;
            bridgeGame.move(direction, bridge.get(count-1));

            outputView.printMap(bridges);

            try {
                return endOfTheGame(bridges, bridge ,count);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public boolean endOfTheGame(List<List<String>> bridges, List<String> bridge,int count) {

        for (List<String> strings : bridges) {
            if (strings.contains("X")) {
                return true;
            }
        }
        if (count == bridge.size()) {
            return false;
        }
        throw new IllegalArgumentException("회피용");
    }

    public String askQuit(List<List<String>> bridges,boolean failed,int attempt) {
        String quit = "R";
        int tmp = attempt;

        if(failed) {

            quit = inputView.readGameCommand();
            attempt = bridgeGame.retry(attempt, quit);
        }
        if(tmp == attempt) {
            quit = "Q";
            outputView.printResult(bridges);
            outputView.gameAttemptCount(!failed, attempt);
        }
        return quit;
    }


}
