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
    private int limitSize;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> getMapUpper() {
        return mapUpper;
    }

    public List<String> getMapLower() {
        return mapLower;
    }

    public List<String> makeBridge(int size) {
        limitSize = size;
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

    public void extendMap(int index) {
        if (index>0) {
            mapUpper.set(mapUpper.size()-1,"|");
            mapLower.set(mapLower.size()-1,"|");
        }
    }

    public boolean checkWhenInputIsD(String answer) {
        if (answer.equals("D")) {
            makeMapLower(true);
            return true;
        }
        if (!answer.equals("D")) {
            makeMapLower(false);
        }
        return false;
    }

    public boolean checkWhenInputIsU(String answer) {
        if (answer.equals("U")) {
            makeMapUpper(true);
            return true;
        }
        if (!answer.equals("U")) {
            makeMapUpper(false);
        }
        return false;
    }

    public boolean runMap(String moving, String answer) {
        boolean isWin = false;
        if (moving.equals("D")) {
            isWin = checkWhenInputIsD(answer);
        }
        if (moving.equals("U")) {
            isWin = checkWhenInputIsU(answer);
        }
        return isWin;
    }

    public boolean makeMap(List<String> crossable) {
        String moving;
        boolean isWin;
        int index = 0;

        startMap();
        while (true) {
            if (index>=limitSize) {
                return true;
            }
            outputView.printWhereToGoInputRequest();
            moving = inputView.readMoving();
            extendMap(index);
            isWin= runMap(moving, crossable.get(index));
            endMap();
            index++;
            outputView.printMap(mapUpper,mapLower);
            if (!isWin) {
                return false;
            }
        }
    }

}


