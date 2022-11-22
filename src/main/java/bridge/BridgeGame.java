package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int position;
    private int count = 1;
    private boolean canMove;
    private final List<String> bridge;
    MapMaker mapMaker = new MapMaker();

    BridgeGame(List<String> bridge, int position, boolean canMove) {
        this.bridge = bridge;
        this.position = position;
        this.canMove = canMove;
    }

    public boolean checkToContinue() {
        return position != bridge.size() && canMove;
    }

    public boolean checkSuccess() {
        return !canMove;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (bridge.get(position).equals(moving)) {
            mapMaker.setMap(moving, "O", position);
        }
        if (!bridge.get(position).equals(moving)) {
            mapMaker.setMap(moving, "X", position);
            canMove = false;
        }
        position++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        count++;
        position = 0;
        canMove = true;
        mapMaker = new MapMaker();
        Application.playGame(this);
    }

    public StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        result.append("\n최종 게임 결과\n[ ").append(mapMaker.getMap()[0]).append("]\n[ ").append(mapMaker.getMap()[1]).append("]\n");
        if (canMove) {
            result.append("\n게임 성공 여부: 성공").append("\n총 시도한 횟수: ").append(count);
            return result;
        }
        result.append("\n게임 성공 여부: 실패").append("\n총 시도한 횟수: ").append(count);
        return result;
    }
}
