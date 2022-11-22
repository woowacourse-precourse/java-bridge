package bridge;

import java.util.List;
public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        int ReturnValue = game.MakeBoard();
        if (ReturnValue!=-1) game.GameStart();
    }
}
