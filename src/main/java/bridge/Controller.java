package bridge;

public class Controller {

    BridgeGame game;
    BridgeMaker maker;
    InputView input;
    OutputView output;
    int userStatus;

    private final int RUNNING = 0;
    private final int WRONG = 1;
    private final int CORRECT = 2;

    Controller() {
        userStatus = RUNNING;
        game = new BridgeGame();
        input = new InputView();
        output = new OutputView();
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    void init() {
        initialSet(); // 초기 정답 세팅
        while(userStatus == RUNNING) {

        }
    }

    void initialSet() {
        String sizeInput = input.readBridgeSize();
        game.setBridgeLen(getSize(sizeInput)); // game의 bridge len 설정
        game.setAnswerBridge(); // game의 bridge 설정
    }

    int getSize(String input) {
        int ans = 0;
        for(int i = 0; i < input.length(); ++i) {
            ans *= 10;
            ans += input.charAt(i) - '0';
        }
        return ans;
    }

}
