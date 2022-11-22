package view;
import error.Exception;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String input = Console.readLine();
        System.out.println("");
        while(Exception.input_error(input) || Exception.valid_number(input))
            input = Console.readLine();
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String move_location = Console.readLine();
        while(Exception.valid_bridge(move_location))
            move_location = Console.readLine();
        return move_location;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String re_game = Console.readLine();
        while(Exception.valid_restart(re_game))
            re_game = Console.readLine();
        return re_game;
    }
}
