package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static final String ERROR = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String buff = Console.readLine();
        int result = 0;
        // Exception 처리
        // case 1. 해당 숫자가 integer로 parsing 불가
        try {
            Integer.parseInt(buff);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + " : 숫자를 입력해야 합니다.");
        }
        return Integer.parseInt(buff);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String buff = Console.readLine();
        // Exception 처리
        // case 1. 사용자의 이동 칸 입력이 'U' or 'D' 이 아닌경우
        // case 2. 앞뒤로 trim 이 필요한 경우
        if (!(buff.equals(UserResponse.UP.getStateInfo()) || buff.equals(UserResponse.DOWN.getStateInfo())))
            throw new IllegalArgumentException(ERROR + " 잘못된 입력입니다.");
        return buff;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String buff = Console.readLine();
        // Exception 처리
        // case 1. 사용자가 지정된 문자 외의 문자를 입력하는 경우
        if (!(buff.equals(UserResponse.RESTART.getStateInfo()) || buff.equals(UserResponse.QUIT.getStateInfo())))
            throw new IllegalArgumentException(ERROR + " 잘못된 입력입니다.");
        return buff;
    }
}
