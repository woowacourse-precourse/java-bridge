package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.BridgeMaker.bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static List<String> userBridge = new ArrayList<>();
    public static boolean end = false;

    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();
        BridgeMaker.makeBridge(bridgeLength);
        System.out.println(bridge); //sout

        OutputView outputView = new OutputView();
        outputView.printMap(bridge);

        boolean end = false;
        boolean success = move(bridge);
        retry();
        System.out.println(userBridge);

        if (success){
            System.out.println("게임 성공 여부 : 성공");
        }
        else{
            System.out.println("게임 성공 여부 : 실패");
        }
        int count = 0;
        System.out.println("총 시도한 횟수" + count);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean move(List<String> bridge) {
        for(int i=0;i<bridge.size();i++){
            InputView inputView = new InputView();
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);
            OutputView.print(userBridge);
            if (!Objects.equals(MovingSquare, bridge.get(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        InputView inputView = new InputView();
        String retryCommand = inputView.readGameCommand();
        if (Objects.equals(retryCommand, "Q")){
            end = true;
        }
    }
}
