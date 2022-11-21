package bridge;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final BridgeGame game = new BridgeGame();

        try{
            game.setUp();
            game.start();

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
