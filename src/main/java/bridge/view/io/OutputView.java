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
        println(gameResultView.render());
    }

    public void lineSeparate() {
        println("");
    }
    public static void println(String content) {
        System.out.println(content);
    }

}
