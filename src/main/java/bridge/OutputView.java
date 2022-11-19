package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private final static String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
	private final static String START_MAP = "[ ";
	private final static String END_MAP = " ]\n";
	private final static String BLANK_MAP = " ";
	private final static String BETWEEN_MAP = " | ";
	private final static String CORRECT_MOVING = "O";
	private final static String UNCORRECT_MOVING = "X";
	private final static String END_MESSAGE = "최종 게임 결과";
	private final static String RESULT_MESSAGE = "게임 성공 여부: ";
	private final static String RETRY_COUNT_MESSAGE = "총 시도한 횟수: ";
	private static String bridgeMap;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int count,boolean isRightMoving,List<String> bridge) {
    	bridgeMap = getUpBridge(count,isRightMoving,bridge);
    	bridgeMap += getDownBridge(count,isRightMoving,bridge);
    	
    	System.out.println(bridgeMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int retryCount,boolean result) {
    	System.out.println(END_MESSAGE);
    	System.out.println(bridgeMap);
    	System.out.println(isGameSuccsess(result));
    	System.out.println(RETRY_COUNT_MESSAGE+retryCount);
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
    	if(bridge.equals(upOrDown) && isRightMoving) {
    		return CORRECT_MOVING+END_MAP;
    	}
    	if(!bridge.equals(upOrDown) && !isRightMoving) {
    		return UNCORRECT_MOVING+END_MAP;
    	}
    	return BLANK_MAP+END_MAP;
    }
    
    private String isGameSuccsess(boolean result) {
    	if(result) {
    		return RESULT_MESSAGE+"성공";
    	}
    	return RESULT_MESSAGE+"실패";
    }
    
}
