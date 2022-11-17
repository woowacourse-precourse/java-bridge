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
    public int readBridgeSize() {
        printSentence(PRINT_ASK_START);
        printBlankLine();
        printSentence(PRINT_ASK_SIZE);
        return getInt(getInput());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public void printSentence(String s){
        System.out.println(s);
    }

    public void printBlankLine(){
        System.out.println("");
    }
}
