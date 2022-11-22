package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

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
