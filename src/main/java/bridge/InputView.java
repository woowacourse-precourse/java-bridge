package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static int size = 1;
    static List<String> move = new ArrayList<>();

    public void readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            size = write_bridge_size();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }

    public int write_bridge_size() {
        int answer = 0;
        try {
            answer = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력을 하였습니다.");
        }
        return answer;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            move.add(checkMoving());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            readMoving();
        }
    }

    public String checkMoving() {
        String answer = "";
        try {
            answer = Console.readLine();
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력을 하였습니다.");
        }
        return answer;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public int getSize() {
        return size;
    }

    public List<String> getMove() {
        return move;
    }
}
