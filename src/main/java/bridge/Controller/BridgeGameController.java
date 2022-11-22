package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

/**
 * 다리 건너기 게임을 컨트롤하는 클래스
 * 각 도메인 객체들과 view들을 통해 game의 실행을 돕는 메소드들이 정의되어있음
 */
public class BridgeGameController {
    public void run() {
        OutputView.printGameStartMessage(); // 1. 시작 메시지 출력
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());   // 2. 랜덤 다리 생성
        BridgeGame bridgeGame = makeNewGame(bridgeMaker);   // 3. 새 게임 생성
        startGame(bridgeGame);  // 4. 게임 실행
        OutputView.printResult(bridgeGame); // 5. 게임 최종 결과 출력
    }

    /**
     * 새로운 bridge game을 생성하는 메소드
     *
     * @param bridgeMaker BridgeMaker 클래스로부터 랜덤하게 만들어진 bridge를 입력받음
     * @return BridgeGame 인스턴스
     */
    private BridgeGame makeNewGame(BridgeMaker bridgeMaker) {
        try {
            return new BridgeGame(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeNewGame(bridgeMaker);
        }
    }

    /**
     * 다리 건너기 게임을 시작하는 메소드
     *
     * 1. 사용자가 이동 입력
     * 2. 이동에 대한 결과에 따른 bridge의 현황을 출력
     * 3. 사용자의 답이 맞는지 틀린지에 따라 restart 메시지를 사용자에게 보여줌
     * 4. 더 이상 건널 bridge의 칸이 남아있지 않을 때까지 반복함
     *
     * @param bridgeGame
     */
    private void startGame(BridgeGame bridgeGame) {
        int bridgeIndex = 0;
        boolean flag = true;    // 사용자가 입력한 답에 따른 이동 결과에 따라 값이 변하는 변수
        while (flag && bridgeIndex < bridgeGame.getBridgeSize()) {    // 이동할 다리가 남아있지 않거나, 답이 틀리지 않을 동안에는 계속 반복되어야 함
            bridgeGame.move(bridgeIndex, validateMoving());
            OutputView.printMap(bridgeGame.getBridgeFormat());
            if (!bridgeGame.isKeepGoing()) { flag = reStartGame(bridgeGame); }  // 사용자의 답이 틀렸을 경우 restart를 원하는 지 메시지를 띄워 보여줌
            bridgeIndex++;
        }
    }

    /**
     * 사용자의 이동 입력에 대한 예외를 처리하는 메소드
     *
     * @return
     */
    private String validateMoving() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateMoving();
        }
    }

    /**
     * 사용자가 입력한 답이 정답과 다를 때 사용자에게 새로운 게임을 다시 시작할 것인지 묻고,
     * 새로운 게임을 다시 실행하는 메소드(재귀적으로 처리함)
     *
     * @param bridgeGame
     * @return false 게임이 종료되면 false를 반환
     */
    private boolean reStartGame(BridgeGame bridgeGame) {
        if (isRetry(bridgeGame)) { startGame(bridgeGame); }
        return false;
    }

    /**
     * 사용자의 restart game에 대한 입력값의 예외처리를 해주는 메소드
     *
     * @param bridgeGame
     * @return
     */
    private boolean isRetry(BridgeGame bridgeGame) {
        try {
            return bridgeGame.retry(InputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return isRetry(bridgeGame);
        }
    }
}