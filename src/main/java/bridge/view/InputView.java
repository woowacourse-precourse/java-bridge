package bridge.view;

import bridge.model.Error;
import bridge.view.Print;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String getUserInput(){
        String userInput = Console.readLine().trim();
        return userInput;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        String userInput = getUserInput();
        isNumber(userInput);
        int bridgeSize = Integer.parseInt(userInput);
        numberRangeCheck(bridgeSize);
        return bridgeSize;
    }

    private void numberRangeCheck(int bridgeSize) throws IllegalArgumentException {
        if(bridgeSize < 3 || bridgeSize >20){
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }

    private void isNumber(String words) throws IllegalArgumentException {
        for (int i = 0; i < words.length(); i++) {
            int ascii = (int)words.charAt(i);
            if (ascii < 48 || ascii > 57) {
                throw new IllegalArgumentException(Error.NOT_A_NUMBER.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        String pickPart = getUserInput();
        isUorD(pickPart);
        return pickPart;
    }

    private void isUorD(String pickPart) throws IllegalArgumentException {
        if(!pickPart.equals("U") && !pickPart.equals("D")){
            throw new IllegalArgumentException(Error.NOT_U_OR_D.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String pickPart = getUserInput();
        isRorQ(pickPart);
        return pickPart;
    }

    private void isRorQ(String pickPart) throws IllegalArgumentException {
        if(!pickPart.equals("R") && !pickPart.equals("Q")){
            throw new IllegalArgumentException(Error.NOT_R_OR_Q.getMessage());
        }
    }


}
