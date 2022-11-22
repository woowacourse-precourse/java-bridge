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

        if(size.length() >= 3) throw new IllegalArgumentException("[ERROR]");
        if(size.isEmpty()) throw new IllegalArgumentException("[ERROR]");

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
        if(direction.length() != 1) throw new IllegalArgumentException();
        char dir = direction.charAt(0);
        if(dir != 'U' && dir != 'D') throw new IllegalArgumentException();

        return direction;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String action = readLine();
        if(action.length() != 1) throw new IllegalArgumentException();
        if(action.charAt(0) != 'R' && action.charAt(0) != 'Q') throw new IllegalArgumentException();

        return action;
    }
}
