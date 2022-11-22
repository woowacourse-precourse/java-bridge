package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String START_SQUARE_BRACKET = "[ ";
    public static final String END_SQUARE_BRACKET = " ]";
    public static final String POLICE_LINE = " | ";


    public void startGameMessage(){
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeResult> resultTopBridge, List<BridgeResult> resultBottomBridge) {
        System.out.println(START_SQUARE_BRACKET + getBridgeResult(resultTopBridge) +  END_SQUARE_BRACKET);
        System.out.println(START_SQUARE_BRACKET + getBridgeResult(resultBottomBridge) +  END_SQUARE_BRACKET);
    }

    public String getBridgeResult(List<BridgeResult> resultBridge){
        String result = "";
        for(BridgeResult cell : resultBridge){
            result += cell.getValue() + POLICE_LINE;
        }
        result = removeLastLine(result);
        return result;
    }

    private String removeLastLine(String result) {
        return result.substring(0, result.length() - 3);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
