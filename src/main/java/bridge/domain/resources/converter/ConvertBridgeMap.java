package bridge.domain.resources.converter;

import bridge.domain.resources.bridge.BridgeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConvertBridgeMap {

    private static final String WHITE_SPACE = "   ";
    private static final String DELIMITER = "|";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";

    private int counter;
    private final List<String> printedUp;
    private final List<String> printedDown;

    public ConvertBridgeMap(BridgeMap bridgeMap) {
        this.printedUp = new ArrayList<>();
        this.printedDown = new ArrayList<>();
        this.counter = bridgeMap.getInputCount().get();
    }

    public String makePrinted(BridgeMap bridgeMap) {
        classifyCase(bridgeMap);
        return String.join("\n",
            printedUp.toString().replace(", ", DELIMITER),
            printedDown.toString().replace(", ", DELIMITER));
    }

    private void classifyCase(BridgeMap bridgeMap) {
        if (bridgeMap.getFlag()) {
            correctCase(bridgeMap);
        }
        if (!bridgeMap.getFlag()) {
            counter--;
            wrongCase(bridgeMap);
        }
    }
    private void correctCase(BridgeMap bridgeMap) {
        bridgeMap.getBridgeMap().stream()
            .limit(counter)
            .forEach(this::transform);
    }

    private void wrongCase(BridgeMap bridgeMap) {
        if (Objects.equals(bridgeMap.getBridgeMap().get(counter), "U")) {
            correctCase(bridgeMap);
            printedUp.add(WRONG);
            printedDown.add(WHITE_SPACE);
        }
        if (Objects.equals(bridgeMap.getBridgeMap().get(counter), "D")) {
            correctCase(bridgeMap);
            printedUp.add(WHITE_SPACE);
            printedDown.add(WRONG);
        }
    }

    private void transform(String input) {
        if (Objects.equals(input, "U")) {
            printedUp.add(CORRECT);
            printedDown.add(WHITE_SPACE);
        }
        if (Objects.equals(input, "D")) {
            printedUp.add(WHITE_SPACE);
            printedDown.add(CORRECT);
        }
    }
}
