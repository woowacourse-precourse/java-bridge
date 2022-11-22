package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    int bridge_size;
    List<String> user_input_list = new ArrayList<String>();
    int try_count = 0;

    /**
     * 다리의 길이를 입력받는다.
     */

    public InputView(){
        this.bridge_size = Integer.valueOf(Console.readLine());
    }
    public int readBridgeSize() {
        return this.bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public List<String> readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try_count += 1;
        this.user_input_list.add(Console.readLine());
        return this.user_input_list;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
