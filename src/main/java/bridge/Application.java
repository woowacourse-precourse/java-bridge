package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            GameSimulator gameSimulator = new GameSimulator();
            gameSimulator.simulateGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
