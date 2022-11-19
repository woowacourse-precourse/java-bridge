package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int inputBridgeSize() {
        while (true) {
            try {
                String sizeTmp = Console.readLine();
                if(checkInputSizeString(sizeTmp)) return Integer.parseInt(sizeTmp);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public boolean checkInputSizeString(String inputSize) {
        if(isNumeric(inputSize) && checkInRange(Integer.parseInt(inputSize))) {
            return true;
        }
        return false;
    }

    public boolean checkMoveNextState(String s) {
        if(checkStringSize(s) && checkMoveString(s)){
            return true;
        }
        return false;
    }

    public boolean checkInputCommand(String inputCommand) {
        if(checkStringSize(inputCommand) && checkFinishGameString(inputCommand)) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String moveNextState = Console.readLine();
                if (checkMoveNextState(moveNextState)) return moveNextState;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String userCommand = Console.readLine();
                if(checkInputCommand(userCommand)) return userCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public boolean checkInRange(int input) {
        if(3 <= input && input <= 20) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 3과 20 사이의 숫자를 입력해주세요");
    }

    public boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public boolean checkStringSize(String s) {
        if(s.length() == 1) {
            return true;
        }
        throw new IllegalArgumentException("1 글자만 입력해주세요");
    }

    public boolean checkMoveString(String s) {
        if(s.charAt(0) == 'U' || s.charAt(0) == 'D') {
            return true;
        }
        throw new IllegalArgumentException("U, D 중에서 입력해주세요");
    }

    public boolean checkFinishGameString(String s) {
        if(s.charAt(0) == 'R' || s.charAt(0) == 'Q') {
            return true;
        }
        throw new IllegalArgumentException("R, Q 중에서 입력해주세요");
    }


}
