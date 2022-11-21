package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import static bridge.BridgeMaker.bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static boolean end = true;
    public static List<String> Result = new ArrayList<>();
    public static int count = 0;

    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();

        while(end){
            gamePlay(bridgeLength);
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void gamePlay(int bridgeLength){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);

        OutputView outputView = new OutputView();
        outputView.printAnswer(bridge);

        boolean success = move(bridge);
        count++;
        if (success){
            OutputView.printResult(Result);
            end = false;
        }
        else{
            retry();
        }
    }

    public static boolean move(List<String> bridge) {
        List<String> userBridge = new ArrayList<>();
        for(int i=0;i<bridge.size();i++){
            InputView inputView = new InputView();
            String MovingSquare = inputView.readMoving();
            userBridge.add(MovingSquare);

            Result = OutputView.print(bridge, userBridge);
            OutputView.printGame(Result);
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
    public static void retry() {
        InputView inputView = new InputView();
        String retryCommand = inputView.readGameCommand();
        if (Objects.equals(retryCommand, "Q")){
            OutputView.printResult(Result);
            end = false;
        }
    }
}
