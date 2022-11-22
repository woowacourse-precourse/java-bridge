package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.data.GameResultData;
import bridge.model.data.MapData;
import bridge.util.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UPSIDE = "U";
    private static final String DOWNSIDE = "D";
    private static final String MOVE_SUCCESS_RECORD = "O";
    private static final String MOVE_FAILURE_RECORD = "X";
    private static final String BLANK_RECORD = " ";

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final Converter converter = new Converter();

    private List<String> bridge;
    private int nowIndex;
    private Map<String, List<String>> records;
    private int trials;

    public BridgeGame() {
        this.bridge = new ArrayList<>();
        this.nowIndex = 0;
        this.records = Map.of(
                UPSIDE, new ArrayList<>(),
                DOWNSIDE, new ArrayList<>()
        );
        this.trials = 1;
    }

    public void start(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(String moving) {
        updateRecords(moving, true);
        nowIndex++;
    }

    public boolean isMovable(String moving) {
        if (bridge.get(nowIndex).equals(moving)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        nowIndex = 0;
        records = Map.of(
                UPSIDE, new ArrayList<>(),
                DOWNSIDE, new ArrayList<>()
        );
        trials++;
    }

    public GameResultData finish(boolean successTf) {
        MapMaker mapMaker = new MapMaker(records.get(UPSIDE), records.get(DOWNSIDE));
        MapData mapData = mapMaker.makeMap();
        String result = converter.convertBooleanToString(successTf);

        return new GameResultData(mapData, trials, result);
    }

    public void updateRecords(String moving, boolean moveSuccess) {
        String record = judgeRecord(moveSuccess);
        records.get(moving).add(record);

        String another = judgeAnotherDirection(moving);
        records.get(another).add(BLANK_RECORD);
    }

    public MapData createMap() {
        MapMaker mapMaker = new MapMaker(records.get(UPSIDE), records.get(DOWNSIDE));
        return mapMaker.makeMap();
    }

    private String judgeAnotherDirection(String moving) {
        if (moving.equals(UPSIDE)) {
            return DOWNSIDE;
        }
        return UPSIDE;
    }

    private String judgeRecord(boolean moveSuccess) {
        if (moveSuccess) {
            return MOVE_SUCCESS_RECORD;
        }
        return MOVE_FAILURE_RECORD;
    }

    public boolean isArrived() {
        return bridge.size() == nowIndex;
    }
}