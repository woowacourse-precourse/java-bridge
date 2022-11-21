package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.\n";
    private static final String READ_MOVE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n";
    private static final String READ_GAME_COMMAND = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R,종료: Q)\n";
    private static final String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_READ_MOVE = "[ERROR] 이동은 U 혹은 D로 입력해주세요.";
    private static final String ERROR_READ_COMMAND = "[ERROR] 재시작은 R, 종료는 Q로 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.printf(INPUT_BRIDGE_SIZE);
        try{
            return convertToInt_Validate(Console.readLine());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.printf(READ_MOVE);
        try{
            return checkUserMove(Console.readLine());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.printf(READ_GAME_COMMAND);
        try{
            return checkUserCommand(Console.readLine());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static int convertToInt_Validate(String input){
        if (!input.matches("^[0-9]*$")){
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20){
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
        return Integer.parseInt(input);
    }
    private static String checkUserMove(String input){
        if (input.equals("U")){
            return input;
        }
        if (input.equals("D")){
            return input;
        }
        throw new IllegalArgumentException(ERROR_READ_MOVE);
    }

    private static String checkUserCommand(String input){
        if (input.equals("R")){
            return input;
        }
        if (input.equals("Q")){
            return input;
        }
        throw new IllegalArgumentException(ERROR_READ_COMMAND);
    }
}
