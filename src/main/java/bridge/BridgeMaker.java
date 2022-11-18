package bridge;

import java.util.List;
import java.util.ArrayList;
import bridge.InputView;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<String> mapUpper = new ArrayList<>();
    private List<String> mapLower = new ArrayList<>();
    private int limitSize = 3;

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

    public int makeMap(List<String> crossable) {
        String moving;
        boolean endGame = false;
        int index = 0;

        startMap();
        while (true) {
            if (index>=limitSize||endGame) {
                if (endGame) {
                    index=-1;
                }
                break;
            }
            outputView.printWhereToGoInputRequest();
            moving = inputView.readMoving();
            if (index>0) {
                extendMap();
            }
            endGame = runMap(moving, crossable.get(index));
            index++;
            endMap();
            outputView.printMap(mapUpper,mapLower);
            System.out.println(crossable.toString());
        }
        return index;
    }

}


