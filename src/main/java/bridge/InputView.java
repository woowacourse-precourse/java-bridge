package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        String inputSize = Console.readLine();
        try{
            Validation.isLengthNumber(inputSize);
            Validation.isLengthRange(Integer.parseInt(inputSize));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return inputSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(Constant.SELECT_MOVE_MESSAGE);
        String moveWord = Console.readLine();
        try{
            Validation.isNotUpOrDown(moveWord);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            readMoving();
        }
        return moveWord;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(Constant.SELECT_RETRY_MESSAGE);
        String retryWord = Console.readLine();
        try{
            Validation.isNotRetryOrQuit(retryWord);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return retryWord;
    }
}
