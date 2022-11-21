package controller;

import bridge.OutputView;

public class OutputController {
    public static void deliverStatus(String up, String down) {
        OutputView.printMap(up,down);
    }
}
