package bridge.view;

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
        try {
            int num = Integer.parseInt(Console.readLine());
            if(!(3<=num && num<=20)) throw new IllegalArgumentException();
            return num;
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try{
            String str = Console.readLine();
            if(!(str.equals("U") || str.equals("D"))) throw new IllegalArgumentException();
            return str;
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 입력은 U,D 만 가능합니다.");
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try{
            String str = Console.readLine();
            if(!(str.equals("R") || str.equals("Q"))) throw new IllegalArgumentException();
            return str;
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 입력은 R,Q 만 가능합니다.");
            return readGameCommand();
        }
    }
}
