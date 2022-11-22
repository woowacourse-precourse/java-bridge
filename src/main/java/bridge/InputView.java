package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        String size = Console.readLine();
        bridgeSizeIntegerCheck(size);
        bridgeSizeCheck(Integer.parseInt(size));
        return Integer.parseInt(size);
    }

    private void bridgeSizeCheck(int size) throws IllegalArgumentException {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException("[ERROR] 다리의 사이즈는 3이상 20이하입니다.");
    }

    private void bridgeSizeIntegerCheck(String size) throws IllegalArgumentException {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 사이즈는 정수입니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println("이동할 칸을 입력해주세요. (위: U, 아래: D)");
        String move = Console.readLine();
        moveROrQCheck(move);
        return move;
    }

    private void moveROrQCheck(String move) throws IllegalArgumentException {
        if (!move.equals("U") && !move.equals("D"))
            throw new IllegalArgumentException("[ERROR] U(위) 또는 D(아래)를 입력해주세요.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        readGameCommandCheck(command);
        return command;
    }

    private void readGameCommandCheck(String command) throws IllegalArgumentException {
        if (!command.equals("R") && !command.equals("Q"))
            throw new IllegalArgumentException("[ERROR] R(재시작) 또는 Q(종료)를 입력해주세요.");
    }
}

