package bridge.view;

import bridge.model.entity.BridgeSize;
import bridge.model.entity.Move;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static bridge.model.entity.BridgeSize.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * - 제공된 `InputView` 클래스를 활용해 구현해야 한다.
 * - `InputView`의 패키지는 변경할 수 있다.
 * - `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * - 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    private BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

    /**
     * 다리의 길이를 입력받는다.
     */
    public List<String> readBridgeSize() { // TODO: 입력값 유효성 검사를 어디서 할까???
            return maker.makeBridge(of(input()).getBridgeSize());
    } // TODO: 입력값 예외처리

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
            return Move.of(input()).getMove();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return input();
    }

    public String input() {
        return Console.readLine();
    }
}
