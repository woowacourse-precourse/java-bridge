package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player();
        try{
            System.out.println("다리 건너기 게임을 시작합니다.\n");
            BridgeGame bridgeGame = new BridgeGame(player);
            bridgeGame.start();
        }catch (IllegalArgumentException illegalArgumentException){

        }
    }
}
