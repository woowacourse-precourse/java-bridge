package bridge;

import java.util.ArrayList;
import java.util.List;
public class Application {

    private static List<String> bridgeNumberList = new ArrayList<>();
    static InputView userInput = new InputView();
    static OutputView display = new OutputView();
    static BridgeGame Game = new BridgeGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public static void gameSetting() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리 길이를 입력해주세요.");
        BridgeRandomNumberGenerator gameRandomNumber = new BridgeRandomNumberGenerator();
        BridgeMaker makeBridge = new BridgeMaker(gameRandomNumber);

        int bridgeSize = userInput.readBridgeSize();

        bridgeNumberList = makeBridge.makeBridge(bridgeSize);
    }
}
