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
    private final List<String> bridge = bridgeMaker.transmitBridge();
    private int attempts = 1;


    public void run() {
        while (true) {
            boolean isSuccess = move();
            if (isSuccess) {
                //성공
                //O 출력
                // 총 시도한 횟수
                return;
            }
            //실패
            boolean isRetry = retry();
            //재시도 x
            if (!isRetry) {
                //최종 게임 결과 출력
                //게임 성공 여부 출력
                //총 시도한 횟수 출력
                return;
            }
            //재시작
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
