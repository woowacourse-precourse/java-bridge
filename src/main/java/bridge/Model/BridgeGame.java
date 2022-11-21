package bridge.Model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;  // 건널 수 있는 칸을 정의한 리스트

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param index 다리의 몇번째 칸을 건널 것인지
     * @param command 사용자가 입력한 이동 명령
     * @param bridgeResult 현재까지 이동한 다리의 상태
     */
    public BridgeResult move(int index, String command, BridgeResult bridgeResult) {
        String result = getResult(index, command);
        if (command.equals("U")){
            bridgeResult.selectUpperBridge(result);
        }
        if (command.equals("D")){
            bridgeResult.selectLowerBridge(result);
        }
        return bridgeResult;
    }

    /**
     * 이동 가능한 칸을 건너려고 했는지 결과 반환
     * @param index 다리의 몇번째 칸을 건널 것인지
     * @param command 사용자가 입력한 이동 명령
     */
    private String getResult(int index, String command){
        String answer = bridge.get(index);
        if (command.equals(answer)){
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(BridgeResult bridgeResult) {
        bridgeResult.clear();
    }
}
