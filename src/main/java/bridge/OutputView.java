package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	StringBuilder result;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<List<String>> upDownBridgeList) {
    	for(List<String> bridge : upDownBridgeList) {
    		result = new StringBuilder();
    		result.append("[");
    		for(int i = 0; i < bridge.size(); i++) {
    			result.append(" " + bridge.get(i) + " ");
    			result.append("|");
    		}
    		result.replace(result.length() - 1, result.length(), "]\n");
    	}
    	return result.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, List<List<String>> upDownBridgeList) {
    	System.out.println("최종 게임 결과");
    	printMap(upDownBridgeList);
    }
}
