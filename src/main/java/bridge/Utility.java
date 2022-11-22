package bridge;

import java.util.Arrays;
import java.util.List;

public class Utility {
    public static String REGAME = "R";
    public static String QUIT = "Q";

    public static List<String> MOVE_NAME = Arrays.asList("DOWN", "UP");

    public static String ERROR_MESSAGE = "[ERROR]";
    public static String NOT_NUMERIC_ERROR_MESSAGE = "숫자 형식이 아닙니다.";
    public static String BRIDGE_LENGTH_OUT_OF_RANGE_ERROR_MESSAGE = "다리의 길이가 3이상 20이하의 범위를 넘어섰습니다.";
    public static String MOVE_VALID_ERROR_MESSAGE = "잘못된 입력입니다. 위로 이동하려면 'U', 아래로 이동하려면 'D'을 입력해야합니다.";
    public static String REGAME_OR_NOT_VALID_ERROR_MESSAGE = "잘못된 입력입니다. 다시 게임을 하려면 'R', 게임을 그만두려면 'Q'를 입력해야합니다.";

    public static int MIN_BRIDGE_LENGTH = 3;
    public static int MAX_BRIDGE_LENGTH = 20;

    public static int convertStringToInt(String input){
        int result = Integer.parseInt(input);
        return result;
    }

}
