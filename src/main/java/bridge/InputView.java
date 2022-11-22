package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    //다리의 길이를 입렵 받는다. 오류 날시 다시 받는다
    public int readValidBridgeSize() {
        boolean flag = true;
        while (flag == true) {
            try {
                int bridgeLength = readBridgeSize();
                flag = true;
                return bridgeLength;
            } catch (IllegalArgumentException e) {continue;}
        }
        return -1;
    }

    //다리의 길이를 입력받는다.
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputSize = Console.readLine();
        ValidationService.checkBridgeLength(inputSize);
        int bridgeSize = Integer.parseInt(inputSize);

        return bridgeSize;

    }

    public String readValidMoving() {
        boolean flag = true;
        while (flag == true) {
            try {
                String  command = readMoving();
                flag = true;
                return command;
            } catch (IllegalArgumentException e) {continue;}
        }
        return "invalid command";

    }

     // 사용자가 이동할 칸을 입력받는다.
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String command = Console.readLine();
        ValidationService.checkMoveCommand(String.valueOf(command));
        return command;
    }


    public String readValidGameCommand() {
        boolean flag = true;
        while (flag == true) {
            try {
                String  command = readGameCommand();
                flag = true;
                return command;
            } catch (IllegalArgumentException e) {continue;}
        }
        return "invalid command";
    }

     //사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        ValidationService.checkGameCommand(command);
        return command;
    }
}
