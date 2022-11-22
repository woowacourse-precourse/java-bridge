package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static List<String> moves = new ArrayList<>(List.of("U","D"));
    private static List<String> commands = new ArrayList<>(List.of("Q","R"));

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int result=0;
        while (true) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                return  convertBridgeSize(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int convertBridgeSize(String userInput) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(userInput.strip());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자를 입력해주세요.");
        }
        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String  readMoving() {
        while (true) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                return convertMoving(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String  convertMoving(String userInput) {
        userInput = userInput.replace("\n", "").strip();
        if (!moves.contains(userInput))
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 (위: U, 아래: D)의 값이어야 합니다.");
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                return convertGameCommand(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String  convertGameCommand(String userInput) {
        userInput = userInput.replace("\n", "").strip();
        if (!commands.contains(userInput))
            throw new IllegalArgumentException("[ERROR] 재시도 여부는 (재시도: R, 종료: Q)의 값이어야 합니다.");
        return userInput;
    }

}

