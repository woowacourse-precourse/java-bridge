package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    BridgeNumberGenerator bng = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bng);
    BridgeGame game = new BridgeGame(bridgeMaker);
    game.playGame();


    }
}
