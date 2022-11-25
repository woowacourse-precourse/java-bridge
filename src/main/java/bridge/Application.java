package bridge;

import controller.UserConsole;

public class Application {

    public static void main(String[] args) {
        UserConsole userConsole = new UserConsole();
        try {
            userConsole.initGame();
            userConsole.startGame();
            userConsole.endGame();
        }catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
}
