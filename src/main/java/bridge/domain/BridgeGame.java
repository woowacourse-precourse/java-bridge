package bridge.domain;

import bridge.view.OrderView;
import org.mockito.internal.matchers.Or;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OrderView orderView = new OrderView();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // moveStep 은 사용자가 이동할 칸을 입력받은것
    // bridgeRandomData 는 안에 들어간 랜덤무작위 값
    // 1 == 위 == U         ,       0 == 아래 == D
    public void move(String moveStep, String bridgeIndexData) {
        if(moveStep.equals("U") && bridgeIndexData.equals("0")) { orderView.wrongUp();}
        if(moveStep.equals("U") && bridgeIndexData.equals("1")) { orderView.correctUp();}
        if(moveStep.equals("D") && bridgeIndexData.equals("0")) { orderView.correctDown();}
        if(moveStep.equals("D") && bridgeIndexData.equals("1")) { orderView.wrongDown();}
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
