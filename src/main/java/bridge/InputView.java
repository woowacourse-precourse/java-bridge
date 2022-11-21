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
    		
    		if(inputbridgesize < 3 && inputbridgesize > 20) {
    			throw new IllegalArgumentException();
    		}
    		
    		return inputbridgesize;
    	}
    	catch(IllegalArgumentException e) {
    		System.out.println("[ERROR]");
    		return -1;
    	}
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	String inputmoveuser = Console.readLine();
    	
    	if(check(inputmoveuser, 'U', 'D')) {
    		throw new IllegalArgumentException();
    	}
        return inputmoveuser;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
    	String inputretryuser = Console.readLine();
    	
    	if(check(inputretryuser, 'R', 'Q')) {
    		throw new IllegalArgumentException();
    	}
        return inputretryuser;
    }
    
    public boolean check(String input, char check1, char check2) {
    	if(input.length() != 1 || (input.charAt(0) != check1 && input.charAt(0) != check2)) {
    		return true;
    	}
    	return false;
    }
}
