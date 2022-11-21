package bridge.Domain;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int gameTryCount = 1;
    boolean gameSuccess = false;
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

    public void play(){
        while(true){
            int position = mySelectBridge.size();
            String moving = inputView.readMoving();
            mySelectBridge.add(moving);

            if(mySelectBridge.get(position).equals(bridge.get(position))){
                //성공
                if(position == bridgeLen - 1){
                    gameSuccess = true;
                    System.out.println("최종 게임 결과");
                    outputView.printMap(bridge, true, position);
                    break;
                }
                outputView.printMap(bridge, true, position);
            }
            else{
                //실패
                outputView.printMap(bridge, false, position);
                String gameCommand = inputView.readGameCommand();

                if(gameCommand.equals("R")){
                    gameTryCount += 1;
                    mySelectBridge = new ArrayList<>();
                }
                else{
                    break;
                }
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        InputView inputView = new InputView();
        String gameCommand = inputView.readGameCommand();

        if(gameCommand.equals("R")){
            gameTryCount += 1;
            mySelectBridge = new ArrayList<>();
        }
        else{
            //break;
        }
    }
}
