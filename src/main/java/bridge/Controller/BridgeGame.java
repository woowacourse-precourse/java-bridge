package bridge.Controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.Bridge;
import bridge.Model.BridgeJudge;
import bridge.Model.BridgeMaker;
import bridge.Model.InputView;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        int size = InputView.getInstance.readBridgeSize(Console.readLine());

        // 다리 생성
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        int index = 0;
        int count = 1;

        while (count <= size) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userDirection = InputView.getInstance.readMoving(Console.readLine());
            BridgeJudge.getInstance.judgeInput(userDirection, madeBridge.get(index), Bridge.bridge);
            OutputView.getInstance.printMap(Bridge.bridge, count);
            index++;
            count++;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
