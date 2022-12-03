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
        int bridge_size;
        String input_str = Console.readLine();
        if(input_str.isBlank()) throw new IllegalArgumentException("[ERROR] 빈 문자를 입력할 수 없습니다.");
        try{
            bridge_size = Integer.parseInt(input_str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 다리길이는 숫자여야합니다.");
        }
        return bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input_str = Console.readLine();
        if(input_str.isBlank()) throw new IllegalArgumentException("[ERROR] 빈 문자를 입력할 수 없습니다.");
        return input_str;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input_str = Console.readLine();
        if(input_str.isBlank()) throw new IllegalArgumentException("[ERROR] 빈 문자를 입력할 수 없습니다.");
        return input_str;
    }
}
