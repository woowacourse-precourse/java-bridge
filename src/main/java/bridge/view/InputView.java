package bridge.view;

import static bridge.domain.Bridge.MAX_SIZE;
import static bridge.domain.Bridge.MIN_SIZE;

import bridge.domain.Command;
import bridge.util.Utils;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = Utils.inputToNumber(Console.readLine());
        if (size < MIN_SIZE || size > MAX_SIZE) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movePlace = Console.readLine();
        if (!movePlace.equals(Command.UPPER.getCommand()) && !movePlace.equals(Command.LOWER.getCommand())) {
            System.out.println("[ERROR] U(위 칸)과 D(아래 칸) 중 하나를 선택하여야 합니다.");
            throw new IllegalArgumentException();
        }
        return movePlace;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String command = Console.readLine();

        if (command.equals(Command.RESTART.getCommand())) {
            return true;
        } else if (command.equals(Command.QUIT.getCommand())) {
            return false;
        }
        System.out.println("[ERROR] R(재시작)과 Q(종료) 중 하나를 선택하여야 합니다.");
        throw new IllegalArgumentException();
    }
}
