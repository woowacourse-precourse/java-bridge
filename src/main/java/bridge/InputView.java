package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String numberPattern = "^[0-9]+$";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");

        String input = Console.readLine();
        int bridgeSize = sizeValidate(input);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String input = Console.readLine();
        movingValidate(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String input = Console.readLine();
        boolean gameCommand = commandValidate(input);

        return gameCommand;
    }

    public int sizeValidate(String number){
        if(!(Pattern.matches(numberPattern, number))){
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 숫자 형식이 아닙니다.");
        }
        int result = Integer.parseInt(number);
        rangeValidate(result);

        return result;
    }

    public void rangeValidate(int number){
        if(number < 3 || number > 20){
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 범위를 벗어납니다. (3 ~ 20)");
        }
    }

    public void movingValidate(String move){
        if(!move.equals("U") && !move.equals("D")){
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다. (위: U, 아래: D)");
        }
    }

    public boolean commandValidate(String command) {
        if (command.equals("R")) {
            return true;
        }
        if (command.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다. (재시도: R, 종료: Q)");
    }
}
