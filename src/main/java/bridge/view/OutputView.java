package bridge.view;

import bridge.constant.BridgePhrase;
import bridge.domain.service.BridgeGame;

public class OutputView {

    public void print(BridgePhrase message) {
        System.out.println(message.getMessage());
    }

    public void print(BridgePhrase message, int count) {
        System.out.printf(message.getMessage(), count);
    }

    public void printMap(BridgeGame output) {
        System.out.println(output + "\n");
    }

    public void printResult(BridgeGame output) {
        System.out.println(output + "\n");
    }

}
