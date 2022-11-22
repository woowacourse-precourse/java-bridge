package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String Input = Console.readLine();
            System.out.println("");
            Integer BridgeSize = Integer.valueOf(Input);
            if (BridgeSize > 20 || BridgeSize < 3) {
                throw new IllegalArgumentException();
            }
            return BridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리길이는 3이상 20이하의 숫자만 입력 가능합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String User_Move = String.valueOf(Console.readLine());
            if (!User_Move.equals("U") && !User_Move.equals("D")) {
                throw new IllegalArgumentException();
            }
            return User_Move;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동할 칸은 U 또는 D만 입력 가능합니다.");
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String GameCommand = Console.readLine();
            if (!GameCommand.equals("R") && !GameCommand.equals("Q")) {
                throw new IllegalArgumentException();
            }
            return GameCommand;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 게임 재시작/종료 여부는 R 또는 Q만 입력 가능합니다.");
            return readGameCommand();
        }
    }

}
