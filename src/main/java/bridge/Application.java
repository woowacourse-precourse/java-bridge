package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            MainGame mainGame = new MainGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
