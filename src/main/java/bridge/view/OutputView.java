package bridge.view;

import bridge.constant.BridgePhrase;
import bridge.domain.service.BridgeGame;

public class OutputView {

    public void print(final BridgePhrase message) {
        System.out.println(message.getMessage());
    }

    public void print(final BridgePhrase message, final int count) {
        System.out.printf(message.getMessage(), count);
    }

    public void printMap(final BridgeGame output) {
        System.out.println(output + "\n");
    }

    public void printResult(final BridgeGame output) {
        System.out.println(output + "\n");
    }

}