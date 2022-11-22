package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Validate validate = new Validate();
    private MapMaker mapMaker;
    private int BridgeSize;
    private List<String> Bridge;
    private List<List<String>> Map;
    private int location;
    private int tryNumber;
    private Boolean Success;
    private Boolean End;

    public BridgeGame(int BridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        validate.BridgeSizeValidate(BridgeSize);
        this.BridgeSize = BridgeSize;
        this.Bridge = bridgeMaker.makeBridge(BridgeSize);
        MapInitialize();
        initialize();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String Move) {
        this.validate.MoveValidate(Move);
        this.Success = compare(Move);
        this.Map = this.mapMaker.MakeMap(Move, this.Success);
    }

    private Boolean compare(String Move) {
        return this.Bridge.get(this.location++).equals(Move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String retry) {
        validate.RetryValidate(retry);
        initialize();
        if(retry.equals("Q")){
            this.Success = false;
            this.End = true;
            this.tryNumber--;
        }
    }

    private void initialize() {
        mapMaker = new MapMaker();
        this.location = 0;
        this.tryNumber++;
        this.Success = true;
        this.End = false;
    }

    private void MapInitialize() {
        this.Map = new ArrayList<>();
        Map.add(new ArrayList<>());
        Map.add(new ArrayList<>());
    }

    public int getBridgeSize() {
        return this.BridgeSize;
    }

    public List<List<String>> getMap() {
        return this.Map;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public Boolean getSuccess() {
        return this.Success;
    }

    public Boolean getEnd() {
        if(this.location == this.BridgeSize) this.End = true;
        return this.End;
    }
}
