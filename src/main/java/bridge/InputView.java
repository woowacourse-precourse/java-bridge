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
            int size = Integer.parseInt(Console.readLine());
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3 이상 20 이하의 숫자를 입력하세요. ");
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        move = move.toUpperCase();
        isUpDown(move);

        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void isUpDown(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U,D 둘 중 하나 입력");
        }
    }

}
