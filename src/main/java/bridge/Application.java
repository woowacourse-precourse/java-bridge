package bridge;

import java.util.IllformedLocaleException;

public class Application {
    static InputView input = new InputView();
    static OutputView output = new OutputView();
    static BridgeGame game = new BridgeGame();
    public static void main(String[] args) {
        try {
            output.printStartGame();
            game.init(input.readBridgeSize());
            play();
            output.printResult(game.getBridge(), game.getCurrent(), game);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void play() throws IllegalArgumentException {
        try{
            do {
                game.retry();
            } while (!game.isClear() && isRetry());
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public static void playOneGame() throws IllegalArgumentException {
        while (!game.isClear() && !game.isOver()) {
            try{
                String step = input.readMoving();
                game.move(step);
                output.printMap(game.getBridge(), game.getCurrent());
            }
            catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    public static boolean isRetry() throws IllegalArgumentException {
        try {
            playOneGame();
            if (game.isClear() || input.readGameCommand().equals(ConstString.QUIT)) {
                return false;
            }
            return true;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
