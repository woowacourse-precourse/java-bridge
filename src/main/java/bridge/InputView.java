package bridge;

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
    	System.out.println();
    	System.out.println("다리의 길이를 입력해주세요.");
    	
    	this.bridgeLength = Integer.parseInt(Console.readLine());
    	
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	String upOrDown = "";
    	
    	System.out.println();
    	System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    	
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
