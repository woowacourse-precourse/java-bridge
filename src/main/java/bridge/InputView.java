package bridge;

import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_UP_DOWN_ERROR = "[ERROR] 이동할 칸은 U 또는 D로만 입력가능 합니다.";
    private static final String INPUT_RESTART_QUIT_ERROR = "[ERROR] 재시작은 R, 종료는 Q 두 가지 입력만 가능합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        String input = Console.readLine();
        BridgeInputExceptionValidation bridgeInputExceptionValidation = new BridgeInputExceptionValidation();
        bridgeInputExceptionValidation.valid(input);
        return Integer.parseInt(input);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        String input = Console.readLine();
        if(isUpDown(input)){
            throw  new IllegalArgumentException(INPUT_UP_DOWN_ERROR);
        }
        return input;
    }

    // 이동할 칸 입력이 U 또는 D인지 예외처리
    private static boolean isUpDown(String input){
        if(input.equals("U") || input.equals("D")){
            return false;
        }
        return true;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String input = Console.readLine();

        if(isRestartQuit(input)){
            throw  new IllegalArgumentException(INPUT_RESTART_QUIT_ERROR);
        }
        if(input.equals("R")){
            return true;
        }
        return false;
    }

    // 게임 재시도 여부 입력이 R 또는 Q인지 예외처리
    private static boolean isRestartQuit(String input){
        if(input.equals("R") || input.equals("Q")){
            return false;
        }
        return true;
    }
}
