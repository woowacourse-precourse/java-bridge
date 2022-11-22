package bridge;

import java.util.HashMap;
import java.util.List;

public class BridgeGameSplit {
    List<String> bridge;
    HashMap<String, String> moveMap = new HashMap<>();
    HashMap<String, Integer> numData = new HashMap<>() {{
        put("gameCount", 0);
    }};
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public List<String> bridgeStart() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);

        outputView.printStart();

        int size = inputView.readBridgeSize();

        bridge = maker.makeBridge(size);
        return bridge;
    }

    public String bridgeFinalWord(String moving) {
        if (moving.equals("O")) {
            return "Q";
        }

        return inputView.readGameCommand();
    }

    public void gameMain(List<String> bridge) {
        String command;

        do {
            numData = bridgeGame.retry(numData);

            do {
                moveMap = bridgeMove(bridge, numData.get("index"));

                numData.put("index", numData.get("index") + 1);

            } while (((bridge.size() > numData.get("index")) && (moveMap.get("moving").equals("O"))));

            command = bridgeFinalWord(moveMap.get("moving"));

        } while (command.equals("R"));

        outputView.printFinish(moveMap, numData, bridge);
    }


    public HashMap<String, String> bridgeMove(List<String> bridge, int index) {

        moveMap.put("move", inputView.readMoving());

        moveMap.put("moving", bridgeGame.move(bridge.get(index), moveMap.get("move")));

        outputView.printMap(bridge.subList(0, index), moveMap);

        return moveMap;
    }

}
