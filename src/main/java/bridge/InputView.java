package bridge;

import bridge.constant.Error;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String s = Console.readLine();
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NUMBER.getMsg());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String s = Console.readLine();
        if (!"U".equals(s) && !"D".equals(s)) throw new IllegalArgumentException(Error.MOVE.getMsg());
        return s;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String s = Console.readLine();
        if (!"R".equals(s) && !"Q".equals(s)) throw new IllegalArgumentException("[ERROR] 재시작과 종료만 가능합니다.");
        return s;
    }
}
