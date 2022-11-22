package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<String> bridge = bridgeMaker.transmitBridge();
    private int attempts = 1;


    public void run() {
        while (true) {
            boolean isSuccess = move();
            if (isSuccess) {
                //최종게임 결과
                outputView.printResult(isSuccess, attempts);
                return;
            }
            boolean isRetry = retry();
            if (!isRetry) {
                //최종 게임 결과
                outputView.printResult(isSuccess, attempts);
                return;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        for (String block : bridge) {
            if (judgeRoundResult(block)) {
                continue;
            }
            return false;
            //x 출력
        }
        return true;//성공
    }

    private boolean judgeRoundResult(String block) {
        return block.equals(inputView.readMoving());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String inputForRestart = inputView.readGameCommand();
        if (inputForRestart.equals("R") || inputForRestart.equals("r")) {
            attempts++;
            return true;
        }
        return false;
    }
}
