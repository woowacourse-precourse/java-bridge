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
        int inputLength;
        try{
            inputLength = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        if(inputLength < 3 || inputLength > 20 ) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 수를 입력해주세요.");
        }
        return inputLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if(input != "U" || input != "D"){
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요.");
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        if(input != "R" || input != "Q"){
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요");
        }
        return input;
    }
}
