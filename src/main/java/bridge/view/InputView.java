package bridge.view;

import static bridge.utils.Util.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    private static final String PRINT_ASK_START = "다리 건너기 게임을 시작합니다.";
    private static final String PRINT_ASK_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_ASK_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private static final String PRINT_ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static String readBridgeSize() {
        printSentence(PRINT_ASK_START);
        printBlankLine();
        printSentence(PRINT_ASK_SIZE);
        return getInput();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printBlankLine();
        printSentence(PRINT_ASK_MOVE);
        return getInput();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printBlankLine();
        printSentence(PRINT_ASK_RETRY);
        return getInput();
    }

    public static void printSentence(String s){
        System.out.println(s);
    }

    public static void printBlankLine(){
        System.out.println("");
    }
}
