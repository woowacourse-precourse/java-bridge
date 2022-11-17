package bridge;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        while(bridgeGame.clear()) //게임클리어여부
        {
            bridgeGame.move(); //이동
            if(!bridgeGame.retry()) //재시작여부
                break;
        }
        bridgeGame.result(); //결과출력
    }
}
