package bridge.view;

import bridge.model.entity.BridgeSize;
import bridge.model.entity.Move;
import bridge.model.entity.Retry;
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
    public List<String> readBridgeSize() {
        try {
            return maker.makeBridge(of(input()).getBridgeSize());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            return Move.of(input()).getMove();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            return Retry.of(input()).getAnswer();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    public String input() {
        return Console.readLine();
    }
}
