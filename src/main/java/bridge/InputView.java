package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String userInputSize = Console.readLine();
            UserInputException.numberCheck(userInputSize);
            return Integer.parseInt(userInputSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userInputCommand = Console.readLine();
            UserInputException.commandCheck(userInputCommand, "read");
            return userInputCommand;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return readMoving();
        }
    }
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String userInputCommand = Console.readLine();
            UserInputException.commandCheck(userInputCommand, "process");
            return userInputCommand;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return readGameCommand();
        }
    }
}
