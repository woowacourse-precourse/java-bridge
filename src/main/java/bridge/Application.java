package bridge;

public class Application {
    public static void main(String[] args) {
        final BridgeGame game = new BridgeGame();
        try{
            game.setUp();
            game.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
