package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            final GamePlayer player = new GamePlayer();
            player.play();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
