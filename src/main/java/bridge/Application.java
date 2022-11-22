package bridge;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayBridgeGame playBridgeGame = new PlayBridgeGame();
        int round = 0;
        boolean run = true;

        //시작화면
        playBridgeGame.printStartScreen();
        //사다리 입력 및 사다리 만들기
        playBridgeGame.makeBridge();
        //이동할 칸을 입력
        playBridgeGame.printCrossBridge();
        //이동 결과 계산
        while(run) {
            playBridgeGame.continueGame();
            run = playBridgeGame.askGame();
        }

    }
}
