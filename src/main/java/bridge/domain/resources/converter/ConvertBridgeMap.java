package bridge.domain.resources.converter;

import bridge.constant.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConvertBridgeMap {

    private final List<String> bridgeMap;
    private final List<String> printedUp;
    private final List<String> printedDown;
    private int counter;

    public ConvertBridgeMap(final List<String> bridgeMapInput, final int inputCount, final boolean flag) {
        this.printedUp = new ArrayList<>();
        this.printedDown = new ArrayList<>();
        this.bridgeMap = bridgeMapInput;
        this.counter = inputCount;
        classifyCase(flag);
    }

    private void classifyCase(final boolean flag) {
        if (flag) {
            correctCase();
        }
        if (!flag) {
            --counter;
            correctCase();
            wrongCase();
        }
    }

    private void correctCase() {
        bridgeMap.stream()
                .limit(counter)
                .forEach(this::transform);
    }

    private void wrongCase() {
        if (Objects.equals(bridgeMap.get(counter), Constant.UP.getValue())) {
            printedUp.add(Constant.WRONG.getValue());
            printedDown.add(Constant.WHITE_SPACE.getValue());
        }
        if (Objects.equals(bridgeMap.get(counter), Constant.DOWN.getValue())) {
            printedUp.add(Constant.WHITE_SPACE.getValue());
            printedDown.add(Constant.WRONG.getValue());
        }
    }

    private void transform(final String input) {
        if (Objects.equals(input, Constant.UP.getValue())) {
            printedUp.add(Constant.CORRECT.getValue());
            printedDown.add(Constant.WHITE_SPACE.getValue());
        }
        if (Objects.equals(input, Constant.DOWN.getValue())) {
            printedUp.add(Constant.WHITE_SPACE.getValue());
            printedDown.add(Constant.CORRECT.getValue());
        }
    }

    @Override
    public String toString() {
        return String.join(Constant.NEXT_LINE.getValue(),
                printedUp.toString().replace(Constant.COMMA.getValue(), Constant.DELIMITER.getValue()),
                printedDown.toString().replace(Constant.COMMA.getValue(), Constant.DELIMITER.getValue()));
    }
}
