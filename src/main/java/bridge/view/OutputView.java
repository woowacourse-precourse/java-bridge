package bridge.view;

import bridge.model.BridgeResult;
import bridge.model.GameResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String START_SQUARE_BRACKET = "[ ";
    public static final String END_SQUARE_BRACKET = " ]";
    public static final String POLICE_LINE = " | ";
    public static final String END_GAME_MESSAGE = "최종 게임 결과";
    public static final String SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: ";
    public static final String TOTAL_PLAY_COUNT_MESSAGE = "총 시도한 횟수: ";


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
        System.out.println();
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
    public void printResult(List<BridgeResult> resultTopBridge, List<BridgeResult> resultBottomBridge, GameResult isSuccess, int totalPlayCnt) {
        System.out.println(END_GAME_MESSAGE);
        printMap(resultTopBridge, resultBottomBridge);
        System.out.println();
        System.out.println(SUCCESS_OR_FAILURE_MESSAGE + isSuccess.getValue());
        System.out.println(TOTAL_PLAY_COUNT_MESSAGE + totalPlayCnt);
    }
}
