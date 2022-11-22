package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import bridge.ui.resource.GameResource;
import bridge.ui.resource.RetryQuitCommand;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int trials = 1;

    public void start() {
        outputView.gameStartMessage(); //게임시작 메시지
        int size = inputView.askBridgeSize(); //다리 사이즈 입력
        List<String> answer_bridge = bridgeMaker.makeBridge(size);//다리 생성
        BridgeGame bridgeGame = new BridgeGame(answer_bridge); //게임 관리 클래스 생성
        while (true) {
            move(bridgeGame);//끝까지 성공하거나 중간에 실패하기전까지 이동
            if (userWin(bridgeGame)) return;//성공이면 결과출력하고 게임 종료
            if (!userRetry(bridgeGame)) return;//Q 입력하면 결과출력하고 게임 종료, R 입력시 재시작
            trials++;
        }
    }

    public boolean userWin(BridgeGame bridgeGame) {//유저가 전무 맞췄을 경우 실행
        if (bridgeGame.isSuccess()) {
            outputView.printResult(GameResource.SUCCESS.content(), bridgeGame, trials);
            return true;
        }
        return false;
    }

    private boolean userRetry(BridgeGame bridgeGame) {//재시도 입력이 필요할 경우 실행
        String command = inputView.askRestart();
        return checkRetry(bridgeGame, command);
    }

    public boolean checkRetry(BridgeGame bridgeGame, String command) {
        if (command.equals(RetryQuitCommand.RETRY.command())) {  //R 입력시 재시작
            bridgeGame.retry();
            return true;
        }
        if (command.equals(RetryQuitCommand.QUIT.command()))    //Q 입력시 결과 출력 후 종료
            outputView.printResult(GameResource.FAILURE.content(),  bridgeGame, trials);
        return false;
    }

    private void move(BridgeGame bridgeGame) {
        boolean isEnd = false;
        while (!isEnd) {
            String way = inputView.askMoving();   //input move 방향 입력
            move1Step(bridgeGame, way);
            isEnd = bridgeGame.isEnd();
        }
    }

    private void move1Step(BridgeGame bridgeGame, String way) {
        bridgeGame.move(way);
        outputView.printMap(bridgeGame);
    }

}
