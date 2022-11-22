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
    private final List<String> fullUpperMap;
    private final List<String> fullLowerMap;
    private int trials;
    private int currentPosition;

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
            fillMapForAnswerUp();
            return;
        }
        fillMapForAnswerDown();
    }

    private void fillMapForAnswerUp() {
        fullUpperMap.add(PrintMessage.MAP_RIGHT.getString());
        fullLowerMap.add(PrintMessage.MAP_BLANK.getString());
    }

    private void fillMapForAnswerDown() {
        fullUpperMap.add(PrintMessage.MAP_BLANK.getString());
        fullLowerMap.add(PrintMessage.MAP_RIGHT.getString());
    }

    public boolean move(String moving) {
        return bridge.get(currentPosition++).equals(moving);
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals(GameCommand.R.toString())) {
            increaseTrials();
            resetPosition();
            return true;
        }
        return false;
    }

    private void increaseTrials() {
        trials++;
    }

    private void resetPosition() {
        currentPosition = 0;
    }

    public boolean isPlaying() {
        return (currentPosition < bridge.size());
    }

    public List<String> getMap(boolean isCorrect) {
        List<String> totalMap = generateFullMapForRightAnswer();
        if (!isCorrect) {
            totalMap.set(currentPosition - 1, changeSymbolForWrongAnswer(totalMap.get(currentPosition - 1)));
            totalMap.set(2 * currentPosition - 1, changeSymbolForWrongAnswer(totalMap.get(2 * currentPosition - 1)));
        }
        return totalMap;
    }

    private List<String> generateFullMapForRightAnswer() {
        List<String> fullMap = new ArrayList<>(fullUpperMap.subList(0, currentPosition));
        fullMap.addAll(fullLowerMap.subList(0, currentPosition));
        return fullMap;
    }

    private String changeSymbolForWrongAnswer(String s) {
        if (s.equals(PrintMessage.MAP_RIGHT.getString())) {
            return PrintMessage.MAP_BLANK.getString();
        }
        return PrintMessage.MAP_WRONG.getString();
    }

    public int getTrials() {
        return trials;
    }

}
