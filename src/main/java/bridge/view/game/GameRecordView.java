package bridge.view.game;

import static bridge.message.SystemMessage.RETRY_COUNT;

import bridge.domain.game.GameRecord;

public class GameRecordView {

    private final GameRecord gameRecord;

    public GameRecordView(GameRecord gameRecord) {
        this.gameRecord = gameRecord;
    }

    public static GameRecordView makeGameRecordView(GameRecord gameRecord) {
        return new GameRecordView(gameRecord);
    }

    public String render() {
        return String.format("%s: %d", RETRY_COUNT.getMessage(), gameRecord.getRetryCount());
    }
}
