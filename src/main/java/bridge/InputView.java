package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Validate validate = new Validate();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true){
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        if (validate.isValidBridgeSize(input)){
            return (Integer.parseInt(input));
        }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();
            if (validate.isValidReadMove(input)) {
                return (input);
            }
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true){
            System.out.println("");
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            if (validate.isValidRetryCommand(input)){
                return (input);
        }
    }
}}
