package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private final static String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
	private final static String START_MAP = "[ ";
	private final static String END_MAP = " ]";
	private final static String BLANK_MAP = " ";
	private final static String BETWEEN_MAP = " | ";
	private final static String CORRECT_MOVING = "O";
	private final static String UNCORRECT_MOVING = "X";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int count,boolean isRightMoving,List<String> bridge) {
    	String upBridge = getUpBridge(count,isRightMoving,bridge);
    	String downBridge = getDownBridge(count,isRightMoving,bridge);
    	
    	System.out.println(upBridge);
    	System.out.println(downBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    	
    }
    
    public void gameStartMessage() {
    	System.out.println(START_GAME_MESSAGE);
    }
    
    private String getUpBridge(int count,boolean isRightMoving,List<String> bridge) {
    	String upBridge = START_MAP;
    	for(int i=0;i<=count;i++) {
    		if(i < count) {
    			upBridge += isBlankOrNot(bridge.get(i),"U");
    		}
    		if(i == count) {
    			upBridge += isRightMovingOrBlank(bridge.get(i),"U", isRightMoving);
    		}
    	}
    	return upBridge;
    }
    
    private String getDownBridge(int count,boolean isRightMoving,List<String> bridge) {
    	String downBridge = START_MAP;
    	for(int i=0;i<=count;i++) {
    		if(i < count) {
    			downBridge += isBlankOrNot(bridge.get(i),"D");
    		}
    		if(i == count) {
    			downBridge += isRightMovingOrBlank(bridge.get(i),"D", isRightMoving);
    		}
    	}
    	return downBridge;
    }
    
    private String isBlankOrNot(String bridge,String upOrDown) {
    	if(bridge.equals(upOrDown)) {
    		return CORRECT_MOVING+BETWEEN_MAP;
    	}
    	return BLANK_MAP+BETWEEN_MAP;
    }
    
    private String isRightMovingOrBlank(String bridge,String upOrDown,boolean isRightMoving) {
    	if(!bridge.equals(upOrDown)) {
    		return BLANK_MAP+END_MAP;
    	}
    	if(!isRightMoving) {
    		return UNCORRECT_MOVING+END_MAP;
    	}
    	return CORRECT_MOVING+END_MAP;
    }
}
