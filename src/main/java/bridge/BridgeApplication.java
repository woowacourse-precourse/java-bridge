package bridge;

import java.util.List;

public class BridgeApplication {
    private InputView inputView;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private BridgeMaker bridgeMaker;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    private List<String> bridge;

    void run() {
        System.out.println("다리 건너기 게임을 시작합니다."); // 다리 건너기 게임 시작
        int size = inputBridgeSize(); // 다리의 길이를 입력
        makeBridge(size); // 다리를 만듦

        outputView = new OutputView();
        bridgeGame = new BridgeGame(bridge, 1);

        doBridgeGame(size); // 다리건너기 시작
        printBridgeGameResult();
    }

    private void printBridgeGameResult() {
        System.out.println("최종 게임 결과");
        printMap();
        outputView.printResult(bridgeGame);
    }

    private void doBridgeGame(int size) {
        for (int idx = 0; idx < size; idx++) {
            String moving = inputMoving();
            bridgeGame.move(moving, idx);
            if (isCorrectMove()) continue;
            printMap();
            if (isSelectRetry()) break;
            idx = -1; // 반복문의 idx 를 -1로 돌려주어 다시 0부터 시작할 수 있게끔 함
            plusGameCnt();
        }
    }

    private void plusGameCnt() {
        bridgeGame.plusCnt();
    }

    private boolean isSelectRetry() {
        if (!(bridgeGame.retry(inputView))) {
            return true;
        }
        return false;
    }

    private void printMap() {
        outputView.printMap(bridgeGame);
    }

    private boolean isCorrectMove() {
        if (bridgeGame.isMove()) {
            printMap();
            return true;
        }
        return false;
    }

    private String inputMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = inputView.readMoving();
        return moving;
    }

    private void makeBridge(int size) {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    private int inputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        inputView = new InputView();
        int size = inputView.readBridgeSize();
        return size;
    }
}
