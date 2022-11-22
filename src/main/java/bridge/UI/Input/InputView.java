package bridge.UI.Input;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String userInput = Console.readLine();
        try {
            validate(userInput, ValidateType.SIZE);
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        try {
            String userInput = Console.readLine();
            validate(userInput, ValidateType.MOVE);
            return userInput;
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return readMoving();
        }

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        try {
            String userInput = Console.readLine();
            validate(userInput, ValidateType.COMMAND);
            return userInput;
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
    }

    private void validate(String s, ValidateType type){
        if(type == ValidateType.SIZE) checkSize(s);

        if(type == ValidateType.MOVE) checkMove(s);

        if(type == ValidateType.COMMAND) checkCommand(s);
    }

    private void checkSize(String s) {
        try {
            int tempInt = Integer.parseInt(s);

            if(!(tempInt >= 3 && tempInt <= 20)) throw new IllegalArgumentException("[ERROR] 3부터 20 사이의 숫자가 아닙니다.");

        } catch (Exception e) {
            if(e.getClass() == NumberFormatException.class) throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            if(e.getClass() == IllegalArgumentException.class) throw e;
        }
    }

    private void checkMove(String s) {
        if(s.length() > 1) throw new IllegalArgumentException("[ERROR] 입력 값이 단일 문자가 아닙니다.");
        if(!(s.charAt(0) == 'U' || s.charAt(0) == 'D')) throw new IllegalArgumentException("[ERROR] 방향을 잘못 입력하셨습니다.");
    }

    private void checkCommand(String s) {
        if(s.length() > 1) throw new IllegalArgumentException("[ERROR] 입력 값이 단일 문자가 아닙니다.");
        if(!(s.charAt(0) == 'R' || s.charAt(0) == 'Q')) throw new IllegalArgumentException("[ERROR] 재시작 여부를 잘못 입력하셨습니다.");
    }
}
