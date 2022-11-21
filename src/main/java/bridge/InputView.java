package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public boolean CHECK_READ_BREIDGE_SIZE_ERROR_ALPHA(String Str_Input){
        if (!Pattern.matches("^[0-9]+", Str_Input)) {
            System.out.println("[ERROR] 다리 사이즈 입력에 문자가 포함 되어 있습니다.\n");
            return false;
        }
        return true;
    }
    public boolean CHECK_READ_BREIDGE_SIZE_ERROR_RANGE(String Str_Input){
        int Val_Str_Input = Integer.parseInt(Str_Input);
        if(!((3 <= Val_Str_Input) && (Val_Str_Input <= 20))){
            System.out.println("[ERROR] 다리 사이즈 입력이 범위를 벗어 났습니다(3~20).\n");
            return false;
        }
        return true;
    }
    public boolean CHECK_READ_BREIDGE_SIZE_ERROR(String Str_Input){
        if(!CHECK_READ_BREIDGE_SIZE_ERROR_ALPHA(Str_Input)){
            return false;
        }
        if(!CHECK_READ_BREIDGE_SIZE_ERROR_RANGE(Str_Input)){
            return false;
        }
        return true;
    }
    public int readBridgeSize_SUB() throws IllegalArgumentException{
        int result = 0;
        System.out.println("다리의 길이를 입력해주세요.");
        String Str_Input = Console.readLine();
        if(!CHECK_READ_BREIDGE_SIZE_ERROR(Str_Input)){
            throw new IllegalArgumentException();
        }
        result = Integer.parseInt(Str_Input);
        return result;
    }
    public int readBridgeSize() throws IllegalArgumentException{
        int STR_RESULT = 0;
        try {
            STR_RESULT = readBridgeSize_SUB();
        } catch (IllegalArgumentException e) {
            STR_RESULT = readBridgeSize();
        }
        return STR_RESULT;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public boolean CHECK_READ_MOVING_ERROR(String Str_Input){
        if(!((Str_Input.equals("U")) || (Str_Input.equals("D")) || (Str_Input.equals("u")) || (Str_Input.equals("d")))){
            System.out.println("[ERROR] MOVE 입력은 u/U 이거나 d/D 만 가능 합니다.\n");
            return false;
        }
        return true;
    }
    public String readMoving_SUB() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String Str_Input = Console.readLine();
        if(!CHECK_READ_MOVING_ERROR(Str_Input)){
            throw new IllegalArgumentException();
        }
        return Str_Input;
    }

    public String readMoving() {
        String STR_RESULT = "";
        try {
            STR_RESULT = readMoving_SUB();
        } catch (IllegalArgumentException e) {
            STR_RESULT = readMoving();
        }
        return STR_RESULT;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean CHECK_READ_GAME_COMMAND_ERROR(String Str_Input){
        if(!((Str_Input.equals("R")) || (Str_Input.equals("Q")) || (Str_Input.equals("r")) || (Str_Input.equals("q")))){
            System.out.println("[ERROR] MOVE 입력은 r/R 이거나 q/Q 만 가능 합니다.\n");
            return false;
        }
        return true;
    }

    public String readGameCommand_SUB() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String Str_Input = Console.readLine();
        if(!CHECK_READ_GAME_COMMAND_ERROR(Str_Input)){
            throw new IllegalArgumentException();
        }
        return Str_Input;
    }

    public String readGameCommand() {
        String STR_RESULT = "";
        try {
            STR_RESULT = readGameCommand_SUB();
        } catch (IllegalArgumentException e) {
            STR_RESULT = readGameCommand();
        }
        return STR_RESULT;
    }
}
