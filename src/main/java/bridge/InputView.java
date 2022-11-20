package bridge;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    
    private static String SIZE_RANGE_ERROR = "[ERROR] size out of range";
    private static String INPUT_NOT_NUMBER_ERROR = "[ERROR] input is not number";
    private static String INPUT_IS_U_OR_D_ERROR = "[ERROR] input must be U or D";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        if(checkInputisNumber(input) == false){
            throw new IllegalArgumentException();
        }
        int size = Integer.parseInt(input);
        if(checkBridgeSize(size) == false){
            throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if(checkInputisUpDown(input) == false)
        {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private boolean checkBridgeSize(int size)
    {
        if(size < 3 || size > 20)
        {
            System.out.println(SIZE_RANGE_ERROR);
            return false;
            //throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean checkInputisNumber(String input)
    {
        String pattern = "^[0-9]+$";
        if (!Pattern.matches(pattern, input)) {
            System.out.println(INPUT_NOT_NUMBER_ERROR);
            // throw new IllegalArgumentException(INPUT_NOT_NJMBER);
            return false;
        }
        return true;
    }

    private boolean checkInputisUpDown(String input)
    {
        if(input.equals("U") || input.equals("D"))
        {
            System.out.println(INPUT_IS_U_OR_D_ERROR);
            return true;
        }
        return false;
    }
}
