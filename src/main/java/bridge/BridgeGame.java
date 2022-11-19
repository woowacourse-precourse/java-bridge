package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameCount;
    List<String> result = new ArrayList<>();
    private InputView inputView = new InputView();

    public BridgeGame() {
        gameCount = 0;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<String> getResult() {
        return result;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(List<String> bridge) {
        gameCount++;
        for (int i = 0; i < bridge.size(); i++) {
            String to = inputView.readMoving();
            result.add(compare(bridge.get(i),to)); // OX 결과 저장
            if(result.get(i).equals("XD") || result.get(i).equals("XU")) {
                return -1;
            }
        }
        return gameCount;
    }

    public String compare(String from, String to) {
        if(from.equals(to) && to.equals("U")) return "OU";
        if(!from.equals(to) && to.equals("U")) return "XU";
        if(from.equals(to) && to.equals("D")) return "OD";
        if(!from.equals(to) && to.equals("D")) return "XD";
        return "ERROR";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry() {
        String retryInput = inputView.readGameCommand();
        if(retryInput.equals("Q")) return -1;
        return 1;
    }
}
