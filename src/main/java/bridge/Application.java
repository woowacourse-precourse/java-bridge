package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            GameStarter gameStarter = new GameStarter();
            gameStarter.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

