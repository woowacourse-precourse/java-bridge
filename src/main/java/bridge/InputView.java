package bridge;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MOVE_STRING_LENGTH = 1;
    private static final String MOVE_BRIDGE_UP = "U";
    private static final String MOVE_BRIDGE_DOWN = "D";
    private static final String GAME_QUIT = "Q";
    private static final String GAME_RESTART = "R";
    private static final String ERROR_BRIDGE_SIZE = "다리의 길이는 3-20 사이 입니다.";
    private static final String ERROR_STRING_LENGTH = "칸의 입력은 한글자만 가능합니다.";
    private static final String ERROR_MOVE_RANGE = "칸의 입력은 U,D 둘 중 하나만 가능합니다.";
    private static final String ERROR_RESTART_RANGE = "재시도는 R, 종료는 Q 두개의 명령어만 가능합니다.";
    private static final String INPUT_BRIDGE_COMMENT = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_COMMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART_COMMENT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_COMMENT);
        String inputBridge = Console.readLine();

        validateBridgeSize(parseInt(inputBridge));
        return parseInt(inputBridge);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_MOVE_COMMENT);
        String inputMove = Console.readLine();

        validateLength(inputMove);
        validateMove(inputMove);
        return inputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_RESTART_COMMENT);
        String inputRestart = Console.readLine();

        validateLength(inputRestart);
        validateRestart(inputRestart);
        return inputRestart;
    }

    private static void validateBridgeSize(int inputBridge){
        if(inputBridge<MIN_BRIDGE_SIZE ||
                inputBridge >MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }

    private static void validateMove(String inputMove){
        if(inputMove != MOVE_BRIDGE_UP && inputMove != MOVE_BRIDGE_DOWN){
            throw new IllegalArgumentException(ERROR_MOVE_RANGE);
        }
    }

    private static void validateRestart(String inputRestart){
        if(inputRestart != GAME_RESTART && inputRestart != GAME_QUIT){
            throw new IllegalArgumentException(ERROR_RESTART_RANGE);
        }
    }

    private static void validateLength(String inputString){
        if(inputString.length() != MOVE_STRING_LENGTH){
            throw new IllegalArgumentException(ERROR_STRING_LENGTH);
        }
    }
}

