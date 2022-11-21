package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.GameCommand;
import bridge.constant.Moving;
import bridge.constant.PrintMessage;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private int trials;
    private int currentPosition;
    private boolean isCorrect;
    private final List<String> fullUpperMap;
    private final List<String> fullLowerMap;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.trials = 1;
        this.currentPosition = 0;
        fullUpperMap = new ArrayList<>();
        fullLowerMap = new ArrayList<>();
        makeFullMap();
    }

    private void makeFullMap() {
        for (String answer : bridge) {
            fillMap(answer.equals(Moving.U.toString()));
        }
    }

    private void fillMap(boolean isAnswerUp) {
        if (isAnswerUp) {
            fullUpperMap.add(PrintMessage.MAP_RIGHT.getString());
            fullLowerMap.add(PrintMessage.MAP_BLANK.getString());
            return;
        }
        fullUpperMap.add(PrintMessage.MAP_BLANK.getString());
        fullLowerMap.add(PrintMessage.MAP_RIGHT.getString());
    }

    public boolean move(String moving) {
        isCorrect = bridge.get(currentPosition++).equals(moving);
        return isCorrect;
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals(GameCommand.R.toString())) {
            trials++;
            currentPosition = 0;
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        return (currentPosition < bridge.size());
    }

    public List<String> getMap() {
        List<String> totalMap = new ArrayList<>(fullUpperMap.subList(0, currentPosition));
        totalMap.addAll(fullLowerMap.subList(0, currentPosition));
        if (!isCorrect) {
            totalMap.set(currentPosition - 1, changeSymbol(totalMap.get(currentPosition - 1)));
            totalMap.set(2 * currentPosition - 1, changeSymbol(totalMap.get(2 * currentPosition - 1)));
        }
        return totalMap;
    }

    private String changeSymbol(String s) {
        if (s.equals(PrintMessage.MAP_RIGHT.getString())) {
            return PrintMessage.MAP_BLANK.getString();
        }
        return PrintMessage.MAP_WRONG.getString();
    }

    public int getTrials() {
        return trials;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
