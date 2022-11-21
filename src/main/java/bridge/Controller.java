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
        if (GameClear(movingIndex, lastInput)) return; //정답을 모두 맞춘 경우
        String input = Movement(movingIndex); //입력을 받고 진행 사항을 출력
        if (GameOver(movingIndex, input)) return; //틀린 답을 입력했을 경우
        Game(movingIndex + 1, input); //입력이 정답이면서 아직 게임이 남아있는 경우
    }

    private boolean GameClear(int movingIndex, String lastInput) {
        if (Same(movingIndex, bridgeList.size())) {
            result(movingIndex - 1, lastInput);
            return true;
        }
        return false;
    }

    private boolean GameOver(int movingIndex, String input) {
        if (bridgeGame.move(bridgeList.get(movingIndex), input)) {
            Retryment(movingIndex, input);
            return true;
        }
        return false;
    }

    private boolean Same(int movingIndex, int size) {
        return Objects.equals(movingIndex, size);
    }

    private String Movement(int movingIndex) {
        String input = inputView.readMoving();  //입력을 받고
        outputView.printMap(movingIndex, bridgeList, input); //입력값에 대한 현황을 출력 후에
        return input; //입력을 반환
    }

    private void Retryment(int movingIndex, String lastInput) {
        String Command = inputView.readGameCommand(); //R또는 Q를 입력받고
        if (confirmRetry(Command)) return; //R(재시도)를 입력
        result(movingIndex, lastInput); //Q(게임 종료)를 입력
    }

    private boolean confirmRetry(String Command) {
        if (bridgeGame.retry(Command)) {
            count++;
            Game(Start_Point, "");
            return true;
        }
        return false;
    }

    private void result(int movingIndex, String lastInput) {
        outputView.printResult(movingIndex, bridgeList, lastInput);
        outputView.printResult(count);
    }
}
