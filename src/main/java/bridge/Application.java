package bridge;

import bridge.domain.GamePlayer;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.init();
        gamePlayer.run();
    }
}
