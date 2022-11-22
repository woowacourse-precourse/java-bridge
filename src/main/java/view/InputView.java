package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final String UP = "U";
    private static final String DOWN = "D";


    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String userInput = Console.readLine().trim();
        if (userInput.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력해 주세요.");
        }
        return Integer.parseInt(userInput);
    }

    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInput = Console.readLine();
        userInput = userInput.toUpperCase().trim();
        if (!userInput.equals(UP) && !userInput.equals(DOWN)){
            throw new IllegalArgumentException("[ERROR] : U 또는 D 만 입력해 주세요. ");
        }
        return userInput;
    }
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userInput = Console.readLine();
        userInput = userInput.toUpperCase().trim();
        System.out.println(userInput);
        if (!userInput.equals(RESTART) && !userInput.equals(QUIT)){
            throw new IllegalArgumentException("[ERROR] : R 또는 Q 만 입력해 주세요. ");
        }
        return userInput;
    }
}
