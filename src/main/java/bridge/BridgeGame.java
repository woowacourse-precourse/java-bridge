package bridge;

import bridge.constant.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> upperClass;
    private List<String> lowerClass;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upperClass = new ArrayList<>(bridge.size());
        this.lowerClass = new ArrayList<>(bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, int count) {
        if (moving.equals("U")) {
            if (moving.equals(bridge.get(count))) {
                upperClass.add(count, "O");
                lowerClass.add(count, " ");
                return true;
            } else {
                upperClass.add(count,"X");
                lowerClass.add(count, " ");
                return false;
            }
        }
        if (moving.equals("D")) {
            if (moving.equals(bridge.get(count))) {
                lowerClass.add("O");
                upperClass.add(" ");
                return true;
            } else {
                lowerClass.add("X");
                upperClass.add(" ");
                return false;
            }
        }

        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        System.out.println(Game.INPUT_RETRY);
        InputView inputView = new InputView();
        return inputView.readGameCommand();
    }

    public List<List<String>> getResult() {
        return List.of(upperClass, lowerClass);
    }
}
