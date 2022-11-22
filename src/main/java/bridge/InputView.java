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
        String size = readLine();
        int n = 0;

        try{
            n = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }

        if(n < 3 || n >= 20) throw new IllegalArgumentException("[ERROR]");

        return n;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = readLine();
        if(direction.length() != 1) throw new IllegalArgumentException("[ERROR]");
        if(direction.equals("U")) return direction;
        if(direction.equals("D")) return  direction;
        throw new IllegalArgumentException("[ERROR]");

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = readLine();
        if(command.length() != 1) throw new IllegalArgumentException("[ERROR]");
        if(command.equals("R")) return command;
        if(command.equals("Q")) return command;
        throw new IllegalArgumentException("[ERROR]");
    }
}
