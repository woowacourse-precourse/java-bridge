package bridge.controller;

public abstract class AbstractGameController {

    public final void run() {
        try {
            startGame();
            playGame();
            endGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    protected abstract void startGame();

    protected abstract void playGame();

    protected abstract void endGame();
}
