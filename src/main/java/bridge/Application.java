package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();

        System.out.println("다리 건너기 게임을 시작합니다.");

        int bridgelength = inputView.readBridgeSize();


    }
}
