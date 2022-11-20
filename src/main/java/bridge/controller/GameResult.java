package bridge.controller;

import bridge.view.OutputView;

import java.util.ArrayList;

public class GameResult {
    private final static OutputView outputView = new OutputView();

    public static void gameResult(int retryCnt) {
        outputView.printResult(new ArrayList<>(), new ArrayList<>(), retryCnt);
    }
}
