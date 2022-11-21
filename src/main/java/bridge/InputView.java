package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
    	try {
    		int inputbridgesize = Integer.parseInt(Console.readLine());
    		
    		return inputbridgesize;
    	}
    	catch(IllegalArgumentException e) {
    		return -1;
    	}
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	String inputmoveuser = Console.readLine();
    	
    	if(inputmoveuser.length() != 1 || (inputmoveuser.charAt(0) == 'U' && inputmoveuser.charAt(0) == 'D')) {
    		throw new IllegalArgumentException();
    	}
        return inputmoveuser;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
