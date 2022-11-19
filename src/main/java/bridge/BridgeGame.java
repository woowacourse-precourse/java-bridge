package bridge;


import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int playcount = 1 ;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridgeView, String input, String cross) {
        if(input.equals(cross)){
            bridgeView.add(input);
            bridgeView.add("O");
        }
        if(!input.equals(cross)){
            bridgeView.add(input);
            bridgeView.add("X");
        }
        return bridgeView;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private List<String> retry(int count, List<String> bridgeView, List<String> cross) {
        List<String> retryBridge = new ArrayList<>();
        String input = retryError();
        if(input.equals("Q")){
            return bridgeView;
        }
        if(input.equals("R")){
            playcount++;
            return crossSelect(count, retryBridge, cross);
        } //게임 진행 메소드 넣기
        return null;
    }

    public List<String> crossSelect(int count, List<String> bridgeView, List<String> cross){
        for(int i =0; i<count; i++){
            String input = crossSelectError();
            new OutputView().printMap(move(bridgeView,input,cross.get(i)));
            if(!input.equals(cross.get(i))){
                return retry(count, bridgeView, cross);
            }
        }
        return bridgeView;
    }

    private String crossSelectError(){
        String input;
        try{
            input = new InputView().readMoving();
        }catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.BRIDGE_CROSS_INPUT.getMessage());
            return crossSelectError();
        }
        return input;
    }

    private String retryError(){
        String input;
        try{
            input = new InputView().readGameCommand();
        }catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.BRIDGE_RESTART_INPUT.getMessage());
            return retryError();
        }
        return input;
    }
}
