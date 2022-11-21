package bridge;

public class Application {

    public static void main(String[] args) {
        UserConsole userConsole = new UserConsole();
        userConsole.initGame();
        userConsole.startGame();
        userConsole.endGame();
    }
}
