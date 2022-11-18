package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int curPos;
    private int gamePlayCount;
    private boolean gameFailed;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
        curPos = -1;
        gamePlayCount = 1;
        gameFailed = false;
    }

    public int getGamePlayCount(){
        return gamePlayCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @return 실패시 false, 성공시 true 를 반환한다.
     */
    public boolean move(String UorD) {
        ++curPos;
        if(!UorD.equals(bridge.get(curPos))){
            gameFailed = true;
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드. 실패시만 호출된다.
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(){
        curPos = -1;
        ++gamePlayCount;
        gameFailed = false;
    }

    public boolean isOverSuccessfully(){
        return curPos == bridge.size() - 1 && !gameFailed;
    }

    private List<String> createUpperBridgeWhenNotGameFailed(){
        List<String> upperBridge = new ArrayList<>();
        for(int i = 0; i <= curPos; ++i){
            if("U".equals(bridge.get(i))) upperBridge.add("O");
            if("D".equals(bridge.get(i))) upperBridge.add(" ");
        }
        return upperBridge;
    }
    private List<String> createUpperBridgeWhenGameFailed(){
        List<String> upperBridge = createUpperBridgeWhenNotGameFailed();
        if(gameFailed && "D".equals(bridge.get(curPos))){
            upperBridge.set(curPos, "X");
            return upperBridge;
        }
        upperBridge.set(curPos, " ");
        return upperBridge;
    }
    private List<String> createUpperBridge(){
        List<String> ret;
        if(gameFailed){
            ret = createUpperBridgeWhenGameFailed();
            return ret;
        }
        ret = createUpperBridgeWhenNotGameFailed();
        return ret;
    }

    private List<String> createLowerBridgeWhenNotGameFailed(){
        List<String> lowerBridge = new ArrayList<>();
        for(int i = 0; i <= curPos; ++i){
            if("D".equals(bridge.get(i))) lowerBridge.add("O");
            if("U".equals(bridge.get(i))) lowerBridge.add(" ");
        }
        return lowerBridge;
    }
    private List<String> createLowerBridgeWhenGameFailed(){
        List<String> lowerBridge = createLowerBridgeWhenNotGameFailed();
        if(gameFailed && "U".equals(bridge.get(curPos))){
            lowerBridge.set(curPos, "X");
            return lowerBridge;
        }
        lowerBridge.set(curPos, " ");
        return lowerBridge;
    }
    private List<String> createLowerBridge(){
        List<String> ret;
        if(gameFailed){
            ret = createLowerBridgeWhenGameFailed();
            return ret;
        }
        ret = createLowerBridgeWhenNotGameFailed();
        return ret;
    }

    public List<String> createBridgePrintFormat(){
        List<String> ret = new ArrayList<>();
        String prefix = "[ ";
        String suffix = " ]";
        String upperBridgePrintFormat = String.join(" | ", createUpperBridge());
        String lowerBridgePrintFormat = String.join(" | ", createLowerBridge());
        ret.add(prefix + upperBridgePrintFormat + suffix);
        ret.add(prefix + lowerBridgePrintFormat + suffix);
        return ret;
    }
}
