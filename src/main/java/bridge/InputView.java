package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = 0;
        try {
            bridgeSize = Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 숫자여야합니다.");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String shape = "";
        try {
            shape = readLine();
            if(shape != "U" || shape != "D") throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동할 칸은 U 또는 D 이어야 합니다.");
        }
        return shape;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String state = "";
        try {
            state = readLine();
            if(state != "R" || state != "Q") throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 게임을 다시 시도할지 여부는 R 또는 Q 이어야 합니다.");
        }
        return state;
    }
}
