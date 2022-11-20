package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * view내부에는 Model에 대한 코드만 있을 수 있고, Controller에 대한 코드가 있어서는 안된다!!
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해 주세요.");
        String input=Console.readLine();
        isDigit(input);
        return Integer.parseInt(input);
    }

    private static void isDigit(String input) {
        for(char c: input.toCharArray()){
            if (!(48<=c && c<=57)) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    public String readMoving() throws IllegalArgumentException{
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input=Console.readLine();
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 이여야 합니다.");
        }
        return input;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input=Console.readLine();
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시도 여부 입력은 R 또는 Q 이여야 합니다.");
        }
        return input;
    }
}
