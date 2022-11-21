package bridge;

import bridge.extensible.InputView;
import bridge.extensible.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private final List<String> bridge;
    private int locationNumber = 0;
    private List<List<String>> map;
    private Boolean isSuccess = false;

    public BridgeGame(InputView inputView, OutputView outputView, List<String> bridge) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        Boolean isMove = isMove(input);
        this.locationNumber++;
        makeMap(isMove);
    }

    public boolean isMove(String input) {
        String location = this.bridge.get(this.locationNumber);
        return location.equals(input);
    }


    public List<List<String>> getMap() {
        return new ArrayList<>(this.map);
    }

    private void makeMap(Boolean isMove) {
        List<List<String>> map = new ArrayList<>();
        List<String> upperList = new ArrayList<>(makeMapList("U", isMove));
        List<String> lowerList = new ArrayList<>(makeMapList("D", isMove));
        map.add(upperList);
        map.add(lowerList);
        this.map = map;
        return;
    }

    private List<String> makeMapList(String line, Boolean isMove) {
        List<String> lineList = new ArrayList<>();
        for (int i = 0; i < this.locationNumber; i++) {
            lineList.add(makeOneMap(this.bridge.get(i), line));
        }
        if (!isMove) {
            lineList.set(this.locationNumber - 1, replaceOneMap(lineList.get(this.locationNumber - 1)));
        }
        return lineList;
    }
    private String replaceOneMap(String origin){
        if (origin == " "){
            return "X";
        }
        if (origin == "O"){
            return " ";
        }
        return origin;
    }

    private String makeOneMap(String origin, String line) {
        if (origin == line) {
            return "O";
        }
        return " ";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
