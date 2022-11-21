package bridge.model;

import static global.advice.ErrorMessage.CHECK_OUTBOUND;
import static global.advice.ErrorMessage.makeErrorMessage;
import static global.advice.InputValidator.checkIsDigit;
import static global.advice.InputValidator.checkLength;
import static global.advice.InputValidator.checkRange;

import bridge.BridgeFactory;
import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public Bridge(final BridgeFactory bridgeFactory, final String size) {
        validation(size);
        this.bridge = bridgeFactory.makeBridge(Integer.parseInt(size));
    }

    private void validation(final String size) {
        checkLength(size);
        checkIsDigit(size);
        checkRange(size);
    }

    public boolean canGoOrNot(final List<String> step, final String userPick) {
        return bridge.get(step.size() - 1).equals(userPick);
    }

    public boolean isCrossing(final int step) {
        if (step > this.bridge.size()) {
            throw new IllegalStateException(
                    makeErrorMessage(CHECK_OUTBOUND) + makeErrorMessage(step, this.bridge.toString()));
        }
        return this.bridge.size() == step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge1 = (Bridge) o;
        return Objects.equals(bridge, bridge1.bridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge);
    }
}
