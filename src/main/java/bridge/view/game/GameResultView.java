package bridge.view.game;

import static bridge.view.game.GameRecordView.makeGameRecordView;
import static bridge.view.game.GameStatusView.makeGameResultStatusView;
import static bridge.view.game.GameSuccessStatusView.makeGameSuccessStatusView;

import bridge.domain.game.GameResult;

public class GameResultView {

    private final GameStatusView gameStatusView;
    private final GameSuccessStatusView gameSuccessStatusView;
    private final GameRecordView gameRecordView;

    public GameResultView(GameResult gameResult) {
        this.gameStatusView = makeGameResultStatusView(gameResult.getBridgeAndPasser());
        this.gameSuccessStatusView = makeGameSuccessStatusView(gameResult.getGameSuccessStatus());
        this.gameRecordView = makeGameRecordView(gameResult.getGameRecord());
    }

    public static GameResultView makeGameResultView(GameResult gameResult) {
        return new GameResultView(gameResult);
    }

    public String render() {
        StringBuffer renderBuffer = new StringBuffer();

        renderBuffer.append(gameStatusView.renderStatus());
        renderBuffer.append(System.lineSeparator());

        renderBuffer.append(gameSuccessStatusView.render());
        renderBuffer.append(System.lineSeparator());

        renderBuffer.append(gameRecordView.render());

        return renderBuffer.toString();
    }
}
