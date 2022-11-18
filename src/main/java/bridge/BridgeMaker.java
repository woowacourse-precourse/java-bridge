package bridge;

import java.util.List;
import java.util.ArrayList;
import bridge.InputView;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final InputView inputView = new InputView();
    private List<String> mapUpper;
    private List<String> mapLower;
    private int limitSize;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> crossable = new ArrayList<>();
        int addNumber;
        for (int index = 0; index < size; index++) {
            addNumber = bridgeNumberGenerator.generate();
            if (addNumber == 0) {
                crossable.add("D");
            } else if (addNumber == 1) {
                crossable.add("U");
            }
        }
        return crossable;
    }

    public void startMap() {
        mapUpper.add("[");
        mapLower.add("[");
    }

    public void endMap() {
        mapUpper.add("]");
        mapLower.add("]");
    }

    public void makeMapLower(boolean isCorrect) {
        if (isCorrect) {
            mapUpper.add("   ");
            mapLower.add(" O ");
        }
        if (!isCorrect) {
            mapUpper.add("   ");
            mapLower.add(" X ");
        }
    }

    public void makeMapUpper(boolean isCorrect) {
        if (isCorrect) {
            mapUpper.add(" O ");
            mapLower.add("   ");
        }
        if (!isCorrect) {
            mapUpper.add(" X ");
            mapLower.add("   ");
        }
    }

    public void extendMap() {
        mapUpper.set(mapUpper.size()-1,"|");
        mapLower.set(mapLower.size()-1,"|");
    }

    public boolean checkWhenInputIsD(String answer) {
        if (answer.equals("D")) {
            makeMapLower(true);
            return false;
        }
        if (!answer.equals("D")) {
            makeMapLower(false);
        }
        return true;
    }

    public boolean checkWhenInputIsU(String answer) {
        if (answer.equals("U")) {
            makeMapUpper(true);
            return false;
        }
        if (!answer.equals("U")) {
            makeMapUpper(false);
        }
        return true;
    }

    public boolean runMap(String gameCommand, String answer) {
        boolean endGame = false;
        if (gameCommand.equals("D")) {
            endGame = checkWhenInputIsD(answer);
        }
        if (gameCommand.equals("U")) {
            endGame = checkWhenInputIsU(answer);
        }
        makeMapBoundary();
        return endGame;
    }

    public void makeMap(List<String> crossable) {
        String gameCommand = inputView.readGameCommand();
        boolean endGame = false;
        int index = 0;

        startMap();
        while (index<limitSize&&!endGame) {
            endGame = runMap(gameCommand, crossable.get(index++));
        }
        endMap();
    }

}


