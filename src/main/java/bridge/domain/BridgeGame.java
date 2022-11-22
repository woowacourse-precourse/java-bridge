package bridge.domain;

import bridge.util.BridgeUtil;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.BridgeUtil.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<List<String>> bridges;

    public BridgeGame() {
        this.bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String square, String choice) {
        String result = moveOne(square, choice);
        resultAdd(choice,result);
        return bridges;
    }

    private String moveOne(String square, String choice) {
        if(square.equals(choice)) {
            return RIGHT.getValue();
        }
        return WRONG.getValue();
    }

    private void resultAdd(String choice,String result){
        List<String> bridgeUp = this.bridges.get(0);
        List<String> bridgeDown = this.bridges.get(1);
        if(choice.equals(UP.getValue())){
            bridgeUp.add(result);
            bridgeDown.add(BLANK.getValue());
        }
        if(choice.equals(DOWN.getValue())){
            bridgeDown.add(result);
            bridgeUp.add(BLANK.getValue());
        }
    }

    @Override
    public String toString(){
        StringBuilder bridgeOne = new StringBuilder();

        for(List<String> bridge : this.bridges){
            bridgeOne.append("[ ");
            bridgeOne.append(bridgeToString(bridge));
            bridgeOne.append(" ]");
            bridgeOne.append("\n");
        }
        return bridgeOne.toString();
    }

    private String bridgeToString(List<String> bridge){
        StringBuilder bridgeOne = new StringBuilder();

        for(int i=0;i<bridge.size();i++){
            bridgeOne.append(bridge.get(i));
            if(i < bridge.size() -1) {
                bridgeOne.append(" | ");
            }
        }
        return bridgeOne.toString();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String reply,int attempt) {
        if(reply.equals(RESTART.getValue())){
            attempt++;
            return attempt;
        }
        return attempt;
    }

    public void reset() {
        this.bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }
}
