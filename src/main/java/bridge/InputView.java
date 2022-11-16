package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static final String OPEN_STATEMENT = "다리 건너기 게임을 시작합니다.";
    static final String ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    static final String ERROR_NUMBER = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static final String ERROR_STRING = "[ERROR] 숫자를 입력하여 주세요.";
    static final int UPPER_BOUND = 20;
    static final int LOWER_BOUND = 3;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(OPEN_STATEMENT);
        System.out.println(ENTER_BRIDGE_LENGTH);
        return catchException();
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

    public static int catchException(){
        int input = 0;
        try{
            input = Integer.parseInt(Console.readLine());
            rangeCheck(input);
        } catch(NumberFormatException numException){
            System.out.println(ERROR_STRING);
        } catch(IllegalArgumentException argException){
            System.out.println(ERROR_NUMBER);
        }
        return input;
    }

    public static void rangeCheck(int number){
        if(!(number >= LOWER_BOUND && number <= UPPER_BOUND)) throw new IllegalArgumentException();
    }

}
