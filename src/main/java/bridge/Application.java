package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            bridgeGame.init();
        }catch (Exception e){
            System.out.println("다시 시작합니다.");
            bridgeGame.init();
        }

    }
}
