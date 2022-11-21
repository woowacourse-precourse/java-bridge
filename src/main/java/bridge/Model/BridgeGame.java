package bridge.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;  // 건널 수 있는 칸을 정의한 리스트
    private Map<String, List<String>> currentMap = Map.of("U", new ArrayList<>(), "D", new ArrayList<>());  // 현재 플레이어의 이동 결과를 담은 Map

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<String, List<String>> move(int index, String command) {
        // TODO: getResult, selectUpperBridge, selectLowerBridge 메소드 호출
        return null;
    }

    private String getResult(int index, String command){
        String answer = bridge.get(index);
        if (command.equals(answer)){
            return "O";
        }
        return "X";
    }

    private void selectUpperBridge(String result){
        currentMap.get("U").add(result);
        currentMap.get("D").add(" ");
    }

    private void selectLowerBridge(String result){
        currentMap.get("U").add(" ");
        currentMap.get("D").add(result);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
