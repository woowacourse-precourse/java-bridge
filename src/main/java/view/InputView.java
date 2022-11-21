package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String userInput = Console.readLine().trim();
        if (userInput.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력해 주세요.");
        }
        return Integer.parseInt(userInput);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInput = Console.readLine();
        userInput = userInput.toUpperCase().trim();
        if (!userInput.equals("U") && !userInput.equals("D")){
            throw new IllegalArgumentException("[ERROR] : U 또는 D 만 입력해 주세요. ");
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userInput = Console.readLine();
        userInput = userInput.toUpperCase().trim();
        System.out.println(userInput);
        if (!userInput.equals("R") && !userInput.equals("Q")){
            throw new IllegalArgumentException("[ERROR] : R 또는 Q 만 입력해 주세요. ");
        }
        return userInput;
    }
}
