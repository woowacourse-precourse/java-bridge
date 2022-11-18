package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.Direction;
import bridge.model.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game) {
        List<String> moved = game.getBridge().subList(0, game.getUserLocation()+1);
        System.out.println("[ " + printBridge(Direction.U,moved, game.getGameState()) + " ]");
        System.out.println("[ " + printBridge(Direction.D,moved, game.getGameState()) + " ]");
    }

    private String printBridge(Direction type, List<String> bridge, GameState state){
        List<String> map = new ArrayList<>();
        for (String floor : bridge){
            makeMap(type, map, floor);
        }
        return String.join(" | ", appendFail(map, state));
    }

    private void makeMap(Direction type, List<String> map, String floor) {
        if (floor.equals(type.name())){
            map.add("O");
            return;
        }
        map.add(" ");
    }

    private List<String> appendFail(List<String> bridge, GameState state) {
        if (!state.equals(GameState.FINISH_FAIL)) {
            bridge.remove(bridge.size() - 1);
            return bridge;
        }
        if (bridge.get(bridge.size() - 1).equals("O")) {
            bridge.set(bridge.size() - 1, "X");
        }
        return bridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
