package bridge;

import java.util.List;
import java.util.Objects;

public class Controller {
    static final String startGame = "다리 건너기 게임을 시작합니다.\n";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    String input;
    int count = 1;

    public void start() {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        System.out.println(startGame);
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        System.out.println();
        processGame(bridgeList, 0);
    }

    private void processGame(List<String> bridgeList, int movingIndex) {
        if (Objects.equals(bridgeList.size(), movingIndex)) { //다리를 무사히 모두 맞힌 경우
            printingResult(bridgeList, movingIndex - 1);
            return;
        }
        moveInOutView(bridgeList, movingIndex); //입력을 받고 진행 사항을 출력
        if (bridgeGame.move(bridgeList.get(movingIndex), input)) { //입력이 틀렸을 경우
            if (askRetry(bridgeList, movingIndex)) return; //게임 재시작 혹은 재개를 묻는다.
        }
        processGame(bridgeList, movingIndex + 1); //입력이 정답이면서 아직 게임이 남아있는 경우
    }

    private void moveInOutView(List<String> bridgeList, int movingIndex) {
        input = inputView.readMoving();
        outputView.printMap(movingIndex, bridgeList, input);
    }

    private boolean askRetry(List<String> bridgeList, int movingIndex) {
        String Command = inputView.readGameCommand();
        if (bridgeGame.retry(Command)) {
            count++;
            processGame(bridgeList, 0);
            return true;
        }
        printingResult(bridgeList, movingIndex);
        return true;
    }

    private void printingResult(List<String> bridgeList, int movingIndex) {
        outputView.printResult(movingIndex, bridgeList, input);
        outputView.printResult(count);
    }
}
