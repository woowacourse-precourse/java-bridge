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
    	System.out.println("다리의 길이를 입력해주세요.");
    	
    	String input = Console.readLine();
    	if(!input.matches("-?\\d+")) {
    		System.out.println("[ERROR] 정수가 아닙니다.");
    		return -1;
    		//throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
    	}
    	
    	int result = Integer.parseInt(input);
    	if(result<3||20<result)
    		throw new IllegalArgumentException("[ERROR] 3~20 사이의 숫자가 아닙니다.");
    	
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    	
    	String input = Console.readLine();
    	if(!input.equals("U")&&!input.equals("D"))
    		throw new IllegalArgumentException("[ERROR] U나 D를 입력해야 합니다.");
    	
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
    	System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    	
    	String input = Console.readLine();
    	if(!input.equals("R")&&!input.equals("Q"))
    		throw new IllegalArgumentException("[ERROR] R이나 Q를 입력해야 합니다.");
    	
        return input;
    }
}
