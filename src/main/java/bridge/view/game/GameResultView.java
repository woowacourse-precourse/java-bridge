package bridge.view.game;

import static bridge.view.game.GameRecordView.makeGameRecordView;
import static bridge.view.game.GameStatusView.makeGameResultStatusView;
import static bridge.view.game.GameSuccessStatusView.makeGameSuccessStatusView;

import bridge.domain.game.GameResult;

public class GameResultView {

    private final GameStatusView gameStatusView;
    private final GameSuccessStatusView gameSuccessStatusView;
    private final GameRecordView gameRecordView;
    private final StringBuffer renderBuffer;

    public GameResultView(GameResult gameResult) {
        this.gameStatusView = makeGameResultStatusView(gameResult.getBridgeAndPasser());
        this.gameSuccessStatusView = makeGameSuccessStatusView(gameResult.getGameSuccessStatus());
        this.gameRecordView = makeGameRecordView(gameResult.getGameRecord());

        this.renderBuffer = new StringBuffer();
    }

    public static GameResultView makeGameResultView(GameResult gameResult) {
        return new GameResultView(gameResult);
    }

    public String render() {

        appendGameStatus();
        appendSuccessStatus();
        appendGameRecord();

        return renderBuffer.toString();
    }

    private void appendGameRecord() {
        renderBuffer.append(gameRecordView.render());
    }

    private void appendSuccessStatus() {
        renderBuffer.append(gameSuccessStatusView.render());
        renderBuffer.append(System.lineSeparator());
    }

    private void appendGameStatus() {
        renderBuffer.append(gameStatusView.renderStatus());
        renderBuffer.append(System.lineSeparator());
    }
}
