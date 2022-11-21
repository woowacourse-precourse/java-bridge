package bridge.controller;

import java.util.List;

import bridge.model.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.Validator;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int bridgeSize;
    private List<String> bridge;
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeNumberGenerator() {
        @Override
        public int generate() {
            return Randoms.pickNumberInRange(0, 1);
        }
    });

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(int round, String moveKey) {
        String crossablePosition = bridge.get(round);
        if (moveKey == "U" && Integer.parseInt(crossablePosition) == 0)
            return round + 1;
        if (moveKey == "D" && Integer.parseInt(crossablePosition) == 1)
            return round + 1;
        return -1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void playGame() {
        bridgeSize = readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        moveBridge();
    }

    public void moveBridge() {
        int round = 0;
        while (round != -1) {
            round = move(round, readBridgeMove());
            // 지도 출력해주기.
        }
    }

    public int readBridgeSize() {
        int inputBridgeSize = inputView.readBridgeSize();
        Validator.checkValueOfReadBridgeSize(inputBridgeSize);
        return inputBridgeSize;
    }

    public String readBridgeMove() {
        String inputBridgeMove = inputView.readMoving();
        Validator.checkValueOfReadBridgeMove(inputBridgeMove);
        return inputBridgeMove;
    }
}
