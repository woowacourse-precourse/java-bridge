package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static List<String> userBridge = new ArrayList<>();
    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");

        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();
        BridgeMaker.makeBridge(bridgeLength);

        OutputView outputView = new OutputView();
        outputView.printMap(BridgeMaker.bridge);

        boolean end = move2(BridgeMaker.bridge);
        //System.out.println(end);
        System.out.println(userBridge);
        //outputView.print(userBridge);

    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge) {
        //int count = 0;
        for(int i=0;i<bridge.size();i++){
            InputView inputView = new InputView();
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);
            System.out.println(bridge.get(i));
            if (!Objects.equals(MovingSquare, bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean move2(List<String> bridge) {
        //int count = 0;
        for(int i=0;i<bridge.size();i++){
            boolean correct = true;
            InputView inputView = new InputView();
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);
            if (Objects.equals(MovingSquare, "U") && Objects.equals(bridge.get(i), "U")){
                OutputView.print(userBridge);
            }
            else if(Objects.equals(MovingSquare, "U")){
                OutputView.printX(userBridge);
            }
            else if(Objects.equals(MovingSquare, "D") && Objects.equals(bridge.get(i), "D")){
                OutputView.print(userBridge);
            }
            else{
                OutputView.printX(userBridge);
            }
            if (!Objects.equals(MovingSquare, bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String user(int count, String user){
        if (count==1) {
            String userMap = "[ O ]";
        }
        return user;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
