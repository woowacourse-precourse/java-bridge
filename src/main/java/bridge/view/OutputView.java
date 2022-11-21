package bridge.view;

import bridge.constant.BridgePhrase;

public class OutputView {

    public void print(BridgePhrase message) {
        System.out.println(message.getMessage());
    }

    public void print(BridgePhrase message, int count) {
        System.out.printf(message.getMessage(), count);
    }

    public void printMap(String output) {
        System.out.println(output + "\n");
    }

    public void printResult(String output) {
        System.out.println(output + "\n");
    }

}
