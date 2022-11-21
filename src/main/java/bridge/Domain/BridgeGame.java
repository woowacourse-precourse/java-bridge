package bridge.Domain;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public int gameTryCount = 1;
    public boolean gameSuccess = false;
    List<String> mySelectBridge = new ArrayList<>();

    //
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    //
    List<String> bridge;
    int bridgeLen;

    public BridgeGame(List<String> bridge, int bridgeLen){
        this.bridgeLen = bridgeLen;
        this.bridge = bridge;
    }

    public boolean play(){
        int position = move();

        if(mySelectBridge.get(position).equals(bridge.get(position))){
            //성공
            if(position == bridgeLen - 1){
                gameSuccess = true;
                System.out.println("최종 게임 결과");
                outputView.printMap(bridge, true, position);
                return false;
            }
            outputView.printMap(bridge, true, position);
            return true;
        }
        //실패
        outputView.printMap(bridge, false, position);
        return retry();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move() {
        String moving = inputView.readMoving();
        mySelectBridge.add(moving);
        return mySelectBridge.size()-1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String gameCommand = inputView.readGameCommand();

        if(gameCommand.equals("R")){
            gameTryCount += 1;
            mySelectBridge = new ArrayList<>();
            return true;
        }
        return false;
    }
}
