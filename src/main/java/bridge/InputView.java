package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        checkSize(size);
        return Integer.parseInt(size);
    }
    /**
    * 입력받은 문자가 정수인지 확인한다.
     * @param size 다리 길이
    * */
    private static void checkSize(String size){
        try{
            Integer.parseInt(size);
        } catch (NumberFormatException e){
            throw new NumberFormatException("[ERROR] 숫자를 입력해주세요.");
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = Console.readLine().strip();
        checkNull(move);
        checkWrongMove(move);
        return move;
    }

    /**
     * 입력받은 값이 null인지 확인한다.
     * @param userInput 사용자 입력값
     */
    private static void checkNull(String userInput){
        if(userInput.length() == 0){
            throw new RuntimeException("[ERROR] 아무것도 입력하지 않았습니다. ");
        }
    }
    /**
     * 명령어를 U 또는 D로 제대로 입력했는지 확인한다.
     * @param move 사용자로부터 입력 받은 이동값
     * */
    private static void checkWrongMove(String move){
        if(!move.equals("U") && !move.equals("D")){
            throw new RuntimeException("[ERROR] 잘못된 이동입니다.");
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine().strip();
        checkNull(command);
        checkWrongGameCommand(command);
        return command;
    }
    /**
     * 입력받은 커맨드가 R 또는 Q로 제대로 입력했는지 확인한다.
     * @param command 사용자로부터 입력받은 게임 시작 여부 입력값
     * */
    private static void checkWrongGameCommand(String command) {
        if(!command.equals("R") && !command.equals("Q")){
            throw new RuntimeException("[ERROR] 잘못된 커맨드를 입력하셨습니다.");
        }
    }
}
