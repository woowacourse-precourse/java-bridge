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
        Validation validation = new Validation();
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validation.isInputType(input);

        int inputBridge = parseStringToInt(input);
        System.out.println(input);
        System.out.println();



        return inputBridge;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public int parseStringToInt(String number){
        return Integer.parseInt(number);
    }



}
