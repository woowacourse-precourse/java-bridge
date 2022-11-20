package bridge.View;

import bridge.Model.VO.BridgeSize;
import bridge.Model.VO.UserChoice;
import bridge.Model.VO.UserCommand;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String number = readLine();
        int size;
        try {
            size = Integer.parseInt(number);
        } catch(NumberFormatException numberFormatException){
            throw new NumberFormatException("올바른 값을 입력해주세요");
        }

        return new BridgeSize(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public UserChoice readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String choice = readLine();

        return new UserChoice(choice);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public UserCommand readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = readLine();

        return new UserCommand(command);
    }
}
