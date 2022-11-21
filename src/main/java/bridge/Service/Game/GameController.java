package bridge.Service.Game;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeGame;
import bridge.UI.InputView;
import bridge.UI.OutputView;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;
    private int trials = 1;

    public void start() {
        outputView.gameStartMessage(); //게임시작 메시지
        int size = inputView.askBridgeSize(); //다리 사이즈 입력
        List<String> answer_bridge = bridgeMaker.makeBridge(size);//다리 생성
        bridgeGame = new BridgeGame(answer_bridge); //게임 관리 클래스 생성
        while (true) {
            move();//끝까지 성공하거나 중간에 실패하기전까지 이동
            if (userWin()) return;//성공이면 결과출력하고 게임 종료
            if (!userRetry()) return;//Q 입력하면 결과출력하고 게임 종료, R 입력시 재시작
            trials++;
        }
    }

    private boolean userWin() {
        if (bridgeGame.isSuccess()) {
            outputView.printResult("성공", bridgeGame, trials);
            return true;
        }
        return false;
    }

    private boolean userRetry() {
        String command = inputView.askRestart();
        return checkRetry(command);
    }

    private boolean checkRetry(String command) {
        if (command.equals("R")) {  //R 입력시 재시작
            bridgeGame.retry();
            return true;
        }
        if (command.equals("Q"))    //Q 입력시 결과 출력 후 종료
            outputView.printResult("실패", bridgeGame, trials);
        return false;
    }

    private void move() {
        boolean isEnd = false;
        while (!isEnd) {
            String way = inputView.askMoving();   //input move 방향 입력
            move1Step(way);
            isEnd = bridgeGame.isEnd();
        }
    }

    private void move1Step(String way) {
        bridgeGame.move(way);
        outputView.printMap(bridgeGame);
    }

}
