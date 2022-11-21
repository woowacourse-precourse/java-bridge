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
        List<String> answer = init(inputView, bm);
    }

    public static void greetings() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    // 다리 생성, 길이 초기 입력
    private static List<String> init(InputView inputView, BridgeMaker bm) {
        try {
            int sz = inputView.readBridgeSize();
            List<String> moveAnswer = bm.makeBridge(sz);
            return moveAnswer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return init(inputView, bm);
        }
    }


}
