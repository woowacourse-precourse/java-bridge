package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameHost {

    private final InputView inputView = new InputView();
    private final BridgeChecker bridgeChecker = new BridgeChecker();
    private final OutputView outputView = new OutputView(bridgeChecker);
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();

    private List<String> bridge;
    private List<String> userInput = new ArrayList<>();

    public void runGame() {
        startGame();
        runOneStep();
    }

    public void startGame() {
        printStartingComment();
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(bridge);
    }

    public void printStartingComment() {
        System.out.println("다리 건너기 게임을 시작합니다." + System.lineSeparator());
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void runOneStep() {
        printGuideComment();
        String moving = inputView.readMoving();
        bridgeGame.move(userInput, moving);
        outputView.printMap(bridge, userInput);
    }

    public void printGuideComment() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)" + System.lineSeparator(),
                MovingDirection.Upper.getDirection(), MovingDirection.Lower.getDirection());
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserInput() {
        return userInput;
    }
}
