package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Attempt;
import bridge.domain.Bridge;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeGameService {

    private final BridgeMaker maker;
    private Attempt attempt;
    private Bridge bridge;
    private Bridge user;

    public BridgeGameService() {
        this.maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    /**
     * 게임을 시작할 때 시도횟수 초기화와 다리를 생성하는 메서드
     */
    public void start() {
        printStart();
        attempt = Attempt.begin();
        makeBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @return 이동의 성공 여부를 반환
     */
    public boolean move() {
        attempt.increase();
        user = Bridge.start();
        while (bridge.isProceeding(user)) {
            inputMoveOption();
            printMap(bridge, user);
            if (!bridge.isSuccess(user)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @return 재시작 여부를 반환
     */
    public String retry() {
        return inputRestartOption();
    }

    /**
     * 게임을 종료하고 최종 결과를 출력하는 메서드
     */
    public void finish() {
        printResult(bridge, user, attempt);
    }

    /**
     * 다리의 길이를 입력받아 생성하는 메서드
     */
    private void makeBridge() {
        while (true) {
            try {
                printBridgeSizeInput();
                bridge = Bridge.of(maker.makeBridge(readBridgeSize()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 이동 옵션을 입력받아 이동하는 메서드
     */
    private void inputMoveOption() {
        while (true) {
            try {
                printMoveOptionInput();
                user = user.move(readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 재시작 옵션을 입력받아 재시작 여부를 반환하는 메서드
     * @return 재시작 여부
     */
    private String inputRestartOption() {
        while (true) {
            try {
                printRestartOptionInput();
                return readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
