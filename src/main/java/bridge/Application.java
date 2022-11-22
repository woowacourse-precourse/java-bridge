package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            GameRunner gameRunner = new GameRunner();
            gameRunner.run();
        } catch (IllegalArgumentException E) {
            System.out.println(E.getMessage());
        }
    }
}
