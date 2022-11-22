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
        int bridgeSize;
        String inputString = Console.readLine();
        if(inputString.isBlank()) throw new IllegalArgumentException("[ERROR] 빈 문자는 사용이 불가합니다.");
        try{
            bridgeSize = Integer.parseInt(inputString);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("[ERROR] 다리길이는 숫자로 입력해 주세요");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputString = Console.readLine();
        if(inputString.isBlank()) throw new IllegalArgumentException("[ERROR] 빈 문자는 사용이 불가합니다.");
        return inputString;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputString = Console.readLine();
        if(inputString.isBlank()) throw new IllegalArgumentException("[ERROR] 빈 문자는 사용이 불가합니다.");
        return inputString;
    }
}
