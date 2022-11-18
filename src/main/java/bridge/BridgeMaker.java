package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public enum Move{
        D(0),
        U(1);

        public final int value;

        Move(int value) {
            this.value = value;
        }
    }

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for(int i = 0; i < size; i++){
            int random = bridgeNumberGenerator.generate();
            Move move = getMove(random);
            bridge.add(move.name());
        }

        return bridge;
    }

    private Move getMove(int value){
        for(Move move : Move.values()){
            if(move.value == value)
                return move;
        }

        return null;
    }
}
