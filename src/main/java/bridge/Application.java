package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame game = new BridgeGame();

        try {
            game.init();
            game.update();
            game.end();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
