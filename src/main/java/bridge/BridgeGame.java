package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputParser inputParser = new InputParser();

    int attempt = 0;
    public void start() {
        List<String> bridge = new ArrayList<>();
        boolean isSuccess;
        bridge = makeBridge(); // 다리 생성
        List<String> player = new ArrayList<>();
        do{
            player = new ArrayList<>();
            isSuccess = move(bridge, player); // 다리 맞추기
        }while(retry() || isSuccess); // 재시도를 선택했거나 성공했을경우 끝
        result(bridge, player);
    }

    public List<String> makeBridge(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int size;
        size = inputParser.getBridgeSize();
        List<String> bridge;

        bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, List<String> player){
        player.add(inputParser.getMoveCommand());
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {

        return false;
    }

    public void result(List<String> bridge, List<String> player){

    }
}
