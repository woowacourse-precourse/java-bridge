package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeNumberGenerator bridgeMaker;
    private List<String> bridge;
    private List<String> userBridge;
    private int tryCnt;

    public BridgeGame(BridgeNumberGenerator bridgeMaker){
        this.bridgeMaker = bridgeMaker;
        tryCnt = 0;
        userBridge = new ArrayList<>();
    }

    public void setUserBridge(List<String> bridge){
        this.userBridge = bridge;
    }

    public List<String> getUserBridge(){
        return this.userBridge;
    }

    public void setBridge(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> getBridge(){
        return this.bridge;
    }

    public boolean isFinish(){
        if(this.getBridge().size() != this.getUserBridge().size()) return false;
        for(int i =0;i<this.getBridge().size();i++){
            if(!this.getBridge().get(i).equals(this.getUserBridge().get(i))) return false;
        }
        return true;
    }

    public int getTryCnt(){
        return this.tryCnt;
    }

    public void setTryCnt(int cnt){
        this.tryCnt += cnt;
    }

    public char[][] calcMap(List<String> map, int row, int col){
        char [][] bridgeMap = new char[2][map.size()];
        for(int i=0;i<map.size();i++){
            if(i>0 && map.get(i).equals("X")){
                bridgeMap[row][col] = 'X';
                break;
            }
            if(map.get(i).equals("D") && row == 0) row++;
            if(map.get(i).equals("U") && row == 1) row--;
            bridgeMap[row][col] = 'O';
            col++;
        }return bridgeMap;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int index, String curStep) {
        return curStep.equals(this.getBridge().get(index));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String type) {
        if(type.equals("R")){
            setTryCnt(1);
            this.setUserBridge(new ArrayList<>());
            return true;
        }
        return false;
    }
}
