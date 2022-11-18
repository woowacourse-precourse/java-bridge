package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String userInputSize= UserInputException.numberCheck(Console.readLine());
            return Integer.parseInt(userInputSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userInputCommand = UserInputException.commandCheck(Console.readLine(), "read");
            return userInputCommand;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동할 칸은 U 또는 D 의 알파벳 대문자여야 합니다.");
            return readMoving();
        }
    }
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String userInputCommand = UserInputException.commandCheck(Console.readLine(), "process");
            return userInputCommand;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 여부는 R 또는 Q 의 알파벳 대문자여야 합니다.");
            return readGameCommand();
        }
    }
}
