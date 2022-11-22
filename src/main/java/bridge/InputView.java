package bridge;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(){
        String pattern = "^[3-9]$|^1\\d$|^20$";
        String message = "다리의 길이를 입력해주세요.";
        String errorMessage = "[ERROR] 3 이상 20 이하의 숫자를 입력해주세요.";
        String input = readLine(message, pattern, errorMessage);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String pattern = "^U$|^D$";
        String message = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        String errorMessage = "[ERROR] U 혹은 D 를 입력해주세요.";
        return readLine(message, pattern, errorMessage);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String pattern = "^R$|^Q$";
        String message = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        String errorMessage = "[ERROR] R 혹은 Q 를 입력해주세요.";
        return readLine(message, pattern, errorMessage);
    }

    public String readLine(String message, String pattern, String errorMessage){
        String input;
        while(true){
            try{
                System.out.println(message);
                input = Console.readLine();
                ExceptionHandling(input, pattern, errorMessage);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private void ExceptionHandling(String input, String pattern, String errorMessage) throws IllegalArgumentException{
        if(!input.matches(pattern)){
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
