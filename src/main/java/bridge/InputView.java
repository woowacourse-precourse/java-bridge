package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 패키지 변경 가능 인자 변경 가능 반환 타입 변경 가능 메서드 명 변경 가능 메서드 추가 가능 여기서만 Console.readLine 가능 BridgeGame 클래스에서 사용 불가
 */

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        String sizeRegex = "^([3-9]{1})$|^(1[0-9]{1})$|^20$";
        if (!size.matches(sizeRegex)) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해 주세요");
        }
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String direction = Console.readLine();
        if (!(direction.equals("U") || direction.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 위로가려면 U, 아래로 가려면 D를 입력해 주세요");

        }
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        if(!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시도를 하려면 R, 종료하려면 Q를 입력해 주세요");
        }
        return command;
    }
}
