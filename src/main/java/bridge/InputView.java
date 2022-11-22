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

    /**
     * 다리의 길이를 입력받는다.
     */

    public void getBridgeLen() {
        boolean b = true;
        while (b) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                this.bridge_size = Integer.valueOf(Console.readLine());
                b = false;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력 값이 잘못되었습니다.");
            }
        }
    }
    public void setBridge_size(int bs){
        this.bridge_size = bs;
    }

    public int readBridgeSize() {
        return this.bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public List<String> readMoving() {
        boolean b = true;
        while (b) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                this.user_input_list.add(Console.readLine());
                b = false;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력 값이 잘못되었습니다.");
            }
        }
        return this.user_input_list;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        boolean b = true;
        while (b) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String ret = Console.readLine();
                b = true;
                return ret;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력 값이 잘못되었습니다.");
            }} return null;}
}