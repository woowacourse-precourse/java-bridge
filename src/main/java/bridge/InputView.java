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
        while (!checkMoving(input)){
            input = Console.readLine();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input;
        input = Console.readLine();
        while (!checkGameCommand(input)){
            input = Console.readLine();
        }
        return input;
    }

    /**
     * 입력받은 다리의 길이 값이 잘못되었는지 판단한다.
     */
    private boolean checkBridgeSize(String input){
        // 입력받은 문자열이 정수로 표현되지 않는 경우
        if (!input.matches("-?\\d+")){
            System.out.println(new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. "));
            return false;
        }
        // 입력받은 문자열이 3 ~ 20 사이의 숫자가 아닌 경우
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20){
            System.out.println(new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. "));
            return false;
        }
        return true;
    }

    /**
     * 입력받은 칸의 값이 잘못되었는지 판단한다.
     */
    private boolean checkMoving(String input){
        if (!(input.equals("U") || input.equals("D"))){
            System.out.println(new IllegalArgumentException("[ERROR] 위쪽 선택을 원하면 U, 아래쪽 선택을 원하면 D를 입력해야 합니다. "));
            return false;
        }
        return true;
    }

    /**
     * 입력받은 게임 재시작 여부 값이 잘못되었는지 판단한다.
     */
    private boolean checkGameCommand(String input){
        if (!(input.equals("R") || input.equals("Q"))){
            System.out.println(new IllegalArgumentException("[ERROR] 재시작을 원하면 R, 종료를 원하면 Q를 입력해야 합니다. "));
            return false;
        }
        return true;
    }
}
