package bridge;

import java.util.List;
import java.util.Objects;

public class Controller {
    final int Start_Point = 0;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    int count = 1;
    List<String> bridgeList;

    public void start() {
        AppConfig appConfig = new AppConfig();
        BridgeMaker bridgeMaker = appConfig.bridgeMaker();
        inputView.printStart();
        bridgeList = bridgeMaker.makeBridge(inputView.readBridgeSize());
        Game(Start_Point, "");
    }

    private void Game(int movingIndex, String lastInput) {
        if (Same(movingIndex, bridgeList.size())) { //다리를 무사히 모두 맞힌 경우
            printingResult(movingIndex - 1, lastInput);
            return;
        }
        String input = processMove(movingIndex); //입력을 받고 진행 사항을 출력
        if (bridgeGame.move(bridgeList.get(movingIndex), input)) { //입력이 정답과 다를 경우
            askRetry(movingIndex, input); //게임 재시작 혹은 종료를 묻는다.
            return;
        }
        Game(movingIndex + 1, input); //입력이 정답이면서 아직 게임이 남아있는 경우
    }

    private boolean Same(int movingIndex, int size) {
        return Objects.equals(movingIndex, size);
    }

    private String processMove(int movingIndex) {
        String input = inputView.readMoving();  //입력을 받고
        outputView.printMap(movingIndex, bridgeList, input); //입력값에 대한 현황을 출력 후에
        return input; //입력을 반환
    }

    private void askRetry(int movingIndex, String lastInput) {
        String Command = inputView.readGameCommand(); //R또는 Q를 입력받고
        if (bridgeGame.retry(Command)) { //R(게임 재개)
            count++;
            Game(Start_Point, "");
            return;
        }
        printingResult(movingIndex, lastInput); //Q(게임 종료)
    }

    private void printingResult(int movingIndex, String lastInput) {
        outputView.printResult(movingIndex, bridgeList, lastInput);
        outputView.printResult(count);
    }
}
