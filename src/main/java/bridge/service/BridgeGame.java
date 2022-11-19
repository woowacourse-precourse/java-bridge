package bridge.service;

import bridge.model.entity.*;
import bridge.model.value.BridgeIngredient;

import java.util.List;

/**

 */
public class BridgeGame {

    private Player player;
    private BridgeMap bridgeMap;
    private  Bridge bridge;


    public Player getPlayer() {
        return player;
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public Bridge getBridge() {
        return bridge;
    }

    /**
     - [ ] `"U"`, `"D"` 문자 정답과 비교
     - [ ] 일치, 불일치 맵 추가 "O", "X" , " "
     *
     */
    public void createBridge(List<String> answer) {
        this.bridge = Bridge.of(answer);
    }
    public void createBridgeMap() {
        this.bridgeMap = BridgeMap.of();
    }
    public void move(String readMove) {
        //문자가 U, D를 입력 받고 일치하는지 확인
        Move move = Move.of(readMove);
        checkMove(bridgeMap.getIndex(), move.getMove());
    }

    public Boolean checkMove(int index, String move) { //정답과 일치하는지 확인
        updateIndex(index); //TODO: Refactoring 해줄 것 return type 없앨 수 있는 방향 생각하기
        if(bridge.getAnswer().get(index).equals(move)){
            addMatchMap(move);
            return null;
        }
        addNotMatchMap(move);
        return null;
    }

    private void updateIndex(int index) {
        bridgeMap.setIndex(index +1);
    }

    public void addMatchMap(String move){
        if(move.equals("U")){ //TODO: Refactoring else 없애고 간결하게 적성할것
            bridgeMap.add(BridgeIngredient.MATCH.getIngredient(), BridgeIngredient.BLANK.getIngredient());
        }else{
            bridgeMap.add(BridgeIngredient.BLANK.getIngredient(), BridgeIngredient.MATCH.getIngredient());
        }
    }

    public void addNotMatchMap(String move){
        if(move.equals("U")){
            bridgeMap.add(BridgeIngredient.NOT_MATCH.getIngredient(), BridgeIngredient.BLANK.getIngredient());
        }else{
            bridgeMap.add(BridgeIngredient.BLANK.getIngredient(),  BridgeIngredient.NOT_MATCH.getIngredient());
        }
    }

    public Boolean isEnd(int index){
        return index == bridge.getAnswer().size();
    }

    public void success(){

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
