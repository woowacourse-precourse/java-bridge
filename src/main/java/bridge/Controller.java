package bridge;

import java.util.List;
import java.util.Objects;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    String input;
    int count = 1;
    List<String> bridgeList;

    public void start() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView.printStart();
        bridgeList = bridgeMaker.makeBridge(inputView.readBridgeSize());
        Game( 0);
    }

    private void Game(int movingIndex) {
        if (Objects.equals(bridgeList.size(), movingIndex)) { //다리를 무사히 모두 맞힌 경우
            printingResult(movingIndex - 1);
            return;
        }
        processMove(movingIndex); //입력을 받고 진행 사항을 출력
        if (bridgeGame.move(bridgeList.get(movingIndex), input)) { //입력이 정답과 다를 경우
            askRetry(movingIndex); //게임 재시작 혹은 종료를 묻는다.
            return;
        }
        Game(movingIndex + 1); //입력이 정답이면서 아직 게임이 남아있는 경우
    }

    private void processMove(int movingIndex) {
        input = inputView.readMoving();
        outputView.printMap(movingIndex, bridgeList, input);
    }

    private void askRetry(int movingIndex) {
        String Command = inputView.readGameCommand();
        if (bridgeGame.retry(Command)) {
            count++;
            Game(0);
            return;
        }
        printingResult(movingIndex);
    }

    private void printingResult(int movingIndex) {
        outputView.printResult(movingIndex, bridgeList, input);
        outputView.printResult(count);
    }
}
