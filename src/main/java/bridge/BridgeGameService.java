package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(generator);
    private static final BridgeGame bridgeGame = new BridgeGame();

    public Integer askBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String askMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String askCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> makeBridge(Integer bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isMovable(List<String> bridge, List<String> map) {
        if (bridgeGame.move(bridge, map) && bridge.size() != map.size()) {
            return true;
        }
        return false;
    }

    public void printMapStatus(List<String> bridge, List<String> map) {
        outputView.printMap(generateMapStatus(bridge, map, "U"));
        outputView.printMap(generateMapStatus(bridge, map, "D"));
    }

    private List<String> generateMapStatus(List<String> bridge, List<String> map, String direction) {
        List<String> mapStatus = new ArrayList<>();
        for (int index = 0; index < map.size(); index++) {
            mapStatus.add(calculateStatus(bridge.get(index), map.get(index), direction));
        }
        return mapStatus;
    }

    private String calculateStatus(String bridge, String map, String direction) {
        if (direction.equals(map)) {
            if (bridge.equals(map)) {
                return "O";
            }
            return "X";
        }
        return " ";
    }

    public boolean isRetry(String selectCommand) {
        return bridgeGame.retry(selectCommand);
    }

    public boolean isSuccess(List<String> bridge, List<String> map) {
        if (bridge.size() != map.size()) {
            return false;
        }
        for (int index = 0; index < map.size(); index++) {
            if (!bridge.get(index).equals(map.get(index))) {
                return false;
            }
        }
        return true;
    }

}
