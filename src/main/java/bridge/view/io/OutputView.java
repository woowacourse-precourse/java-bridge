package bridge.view.io;

import bridge.message.SystemMessage;
import bridge.view.game.GameResultView;
import bridge.view.game.GameStatusView;

public class OutputView {

    public void printMap(GameStatusView gameStatusView) {
        println(gameStatusView.renderStatus());
    }

    public void printMessage(SystemMessage message) {
        println(message.getMessage());
    }

    public void printResult(GameResultView gameResultView) {
        print(gameResultView.render());
    }

    public void lineSeparate() {
        println("");
    }
    private static void println(String content) {
        System.out.println(content);
    }
    public static void print(String content) {
        System.out.print(content);
    }

}
