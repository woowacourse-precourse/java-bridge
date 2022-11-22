package bridge;

import bridge.UI.Output.CountRound;

public class Application {

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame(new CountRound());
        playGame.start();
    }
}
