package bridge.domain;

import bridge.view.OrderView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OrderView orderView = new OrderView();
    List<String> upSide = new ArrayList<>();
    List<String> downSide = new ArrayList<>();
    private int retryCount = 0;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveStep, String bridgeIndexData, int index) {
        if(moveStep.equals("U") && bridgeIndexData.equals("0")) { gameResult(orderView.wrong(),orderView.space(), index);}
        if(moveStep.equals("U") && bridgeIndexData.equals("1")) { gameResult(orderView.correct(),orderView.space(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("0")) { gameResult(orderView.space(),orderView.correct(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("1")) { gameResult(orderView.space(),orderView.wrong(), index);}
    }

    private void gameResult(String up, String down, int index) {
        upSide.add(up);
        downSide.add(down);

        if( index == 0) {
            firstResult(upSide.get(index), downSide.get(index));
            return ;
        }
        restResult(upSide, downSide);
    }
    private void firstResult(String upSide, String downSide) {
        System.out.print(upSide);
        orderView.lineSkip();
        System.out.print(downSide);
        orderView.lineSkip();
    }
    //Todo 문자열 바꾸기
    private void restResult(List<String> upSide, List<String> downSide) {
        System.out.print(changeToBracket(upSide));
        orderView.lineSkip();
        System.out.print(changeToBracket(downSide));
        orderView.lineSkip();
    }

    private String changeToBracket(List<String> extractBracket){
        String bridgeData = "";
        for(int i = 0; i < extractBracket.size() ; i++){
            bridgeData += extractBracket.get(i);
        }
        return bridgeData.replaceAll("]\\[","|");
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
    }
}
