package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public enum exceptions{
        BRIDGESIZE_EXCEPTION(new IllegalArgumentException("[ERROR] 3~20까지의 숫자 중 하나를 입력하세요.")),
        MOVE_EXCEPTION(new IllegalArgumentException("[ERROR] 대문자 U 또는 대문자 D를 입력해주세요."));

        private IllegalArgumentException exception;

        exceptions(IllegalArgumentException exception) {
            this.exception = exception;
        }

        public void viewException(){
            System.out.println(exception);
        }

        public IllegalArgumentException getException() {
            viewException();
            return exception;
        }
    }

    public void exceptionCheck_Bridge(String input) {
        if (input.length() >= 1 && input.length() <= 2) {
            exceptionStatusCheck_Bridge(input);
        }
    }

    public void exceptionStatusCheck_Bridge(String input){
        if (input.length() == 1 && input.charAt(0) - '0' < 3) {
            exceptionOccured_Bridge();
        }
        if (input.length() == 2 && input.charAt(0) - '0' > 2) {
            exceptionOccured_Bridge();
        }
        if (input.length() == 2 && input.charAt(0) - '0' == 2 && input.charAt(1) - '0' > 0) {
            exceptionOccured_Bridge();
        }
    }

    public void exceptionOccured_Bridge(){
        exceptions.BRIDGESIZE_EXCEPTION.getException();
        readBridgeSize();
    }

    public int StringtoInt(String input){
        return Integer.parseInt(input);
    }

    public void exceptionCheck_Moving(String input){
        if(!input.equals("U") && !input.equals("D")) exceptionOccured_Moving();
    }

    public void exceptionOccured_Moving(){
        exceptions.MOVE_EXCEPTION.getException();
        readMoving();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        exceptionCheck_Bridge(input);
        return StringtoInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        exceptionCheck_Moving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
