package bridge.service;

import bridge.model.entity.*;
import bridge.model.value.BridgeIngredient;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.InputView.*;

import static bridge.view.InputView.readBridgeSize;

/**

 */
public class BridgeGame {

    private Player player;
    private BridgeMap bridgeMap;
    private Bridge bridge;

    /*
    *
     */


    /**
     - [ ] `"U"`, `"D"` 문자 정답과 비교
     - [ ] 일치, 불일치 맵 추가 "O", "X" , " "
     *
     */
    public void createBridge() {
        this.bridge = Bridge.of(InputView.readBridgeSize());
    }
    public void createBridgeMap() {
        this.bridgeMap = BridgeMap.of();
    }
    public void move() {
        //문자가 U, D를 입력 받고 일치하는지 확인
        Move move = Move.of(InputView.readMoving());
        checkMove(bridgeMap.getIndex(), move.getMove());
    }

    public Boolean checkMove(int index, String move) { //정답과 일치하는지 확인
        bridgeMap.setIndex(index+1); //TODO: Refactoring 해줄 것 return type 없앨 수 있는 방향 생각하기
        if(bridge.getAnswer().get(index).equals(move)){
            addMatchMap(move);
            return null;
        }
        addNotMatchMap(move);
        return null;
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
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
