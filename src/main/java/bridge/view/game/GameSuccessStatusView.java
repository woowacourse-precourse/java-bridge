package bridge.view.game;

import static bridge.message.SystemMessage.SUCCESS_RESULT;

import bridge.value.GameSuccessStatus;

public class GameSuccessStatusView {

    private final GameSuccessStatus gameSuccessStatus;

    public GameSuccessStatusView(GameSuccessStatus gameSuccessStatus) {
        this.gameSuccessStatus = gameSuccessStatus;
    }

    public static GameSuccessStatusView makeGameSuccessStatusView(GameSuccessStatus gameSuccessStatus) {
        return new GameSuccessStatusView(gameSuccessStatus);
    }

    public String render() {
        return String.format("%s: %s", SUCCESS_RESULT.getMessage(), gameSuccessStatus.getMessage());
    }
}
