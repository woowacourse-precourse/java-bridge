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
        String input;
        int input_num;
        input = Console.readLine();
        while (!checkBridgeSize(input)){
            input = Console.readLine();
        }
        input_num = Integer.parseInt(input);
        return input_num;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;
        input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input;
        input = Console.readLine();
        return input;
    }

    /**
     * 입력받은 다리의 길이 값이 잘못되었는지 판단한다.
     */
    private boolean checkBridgeSize(String input){
        if (!input.matches("-?\\d+")){
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. " + e.toString());
            return false;
        }
        return true;
    }
}
