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



    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

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


}
