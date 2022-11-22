package bridge.view;

import bridge.constant.BridgePhrase;
import bridge.domain.service.BridgeGame;

public class OutputView {

    public final void print(final BridgePhrase message) {
        System.out.println(message.getMessage());
    }

    public final void print(final BridgePhrase message, final int count) {
        System.out.printf(message.getMessage(), count);
    }

    public final void printMap(final BridgeGame output) {
        System.out.println(output + "\n");
    }

    public final void printResult(final BridgeGame output) {
        System.out.println(output + "\n");
    }

}