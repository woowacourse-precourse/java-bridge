package bridge;

import bridge.BridgeGame.Direction;
import bridge.BridgeGame.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private BridgeGame game;

    public OutputView(BridgeGame game) {
        this.game = game;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        int columnIndex = game.getColumnIndex();
        int rowIndex = game.getRowIndex();
        List<String> mapToPrint = new ArrayList<>();
        List<Direction> map = game.getMap();
        List<Direction> track = game.getTrack();
        mapToPrint.add("");
        mapToPrint.add("");
        mapToPrint.set(0, "[ ");
        mapToPrint.set(1, "[ ");
        for (int i = 0; i < track.size(); i++) {
            if (track.get(i) == Direction.UP && map.get(i) == Direction.UP) {
                mapToPrint.set(0, mapToPrint.get(0) + "0");
                mapToPrint.set(1, mapToPrint.get(1) + " ");
            } else if (track.get(i) == Direction.UP && map.get(i) == Direction.DOWN) {
                mapToPrint.set(0, mapToPrint.get(0) + "X");
                mapToPrint.set(1, mapToPrint.get(1) + "O");
            } else if (track.get(i) == Direction.DOWN && map.get(i) == Direction.DOWN) {
                mapToPrint.set(0, mapToPrint.get(0) + " ");
                mapToPrint.set(1, mapToPrint.get(1) + "O");
            } else if (track.get(i) == Direction.DOWN && map.get(i) == Direction.UP) {
                mapToPrint.set(0, mapToPrint.get(0) + "O");
                mapToPrint.set(1, mapToPrint.get(1) + "X");
            }
            if (i < track.size() - 1) {
                mapToPrint.set(0, " | ");
                mapToPrint.set(1, " | ");
            }
        }
        mapToPrint.set(0, " ]");
        mapToPrint.set(1, " ]");
        for (String row : mapToPrint) {
            System.out.println(row);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("게임 성공 여부: 성공");
        System.out.printf("총 시도한 횟수: %d\n", game.getTryCount());
    }
}
