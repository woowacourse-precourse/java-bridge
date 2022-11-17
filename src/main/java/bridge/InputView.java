package bridge;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private int bridgeLength = 0;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
    	while(this.bridgeLength != 0) {
    		System.out.println("\n다리의 길이를 입력해주세요.");
        	String bridgeLengthStr = Console.readLine();
        	try {
        		bridgeSizeExceptionCheck(bridgeLengthStr);
        	} catch (IllegalArgumentException e) {
        		continue;
        	}
    	}
        return this.bridgeLength;
    }
    
    public int bridgeSizeExceptionCheck(String bridgeLengthStr) {
    	String pattern = "^[0-9]+$";
    	int bridgeLength = 0;
    	if(Pattern.matches(pattern, bridgeLengthStr)) {
    		bridgeLength = Integer.parseInt(bridgeLengthStr);
    		if(bridgeLength < 3 || bridgeLength > 20) {
    			throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하의 정수입니다.");
    		}
    	}
    	this.bridgeLength = bridgeLength;
    	return this.bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	String upOrDown = "";
    	
    	System.out.println();
    	System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    	
    	upOrDown = Console.readLine();
  
        return upOrDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
