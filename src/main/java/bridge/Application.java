package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bg = new BridgeGame();
        User user = new User();

        greetings();
    }

    public static void greetings() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }



}
