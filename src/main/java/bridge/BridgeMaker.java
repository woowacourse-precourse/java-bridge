package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private enum DIRECTION {
        DOWN("D"), UP("U");

        private String abbrev;

        DIRECTION(String abbrev) {
            this.abbrev = abbrev;
        }
    }

    private List<DIRECTION> currentMapState = new ArrayList<>();


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        while (size >= currentMapState.size()){
            this.addOneSpace();
        }
        return makeString(currentMapState, size);
    }

    private List<String> makeString(List<DIRECTION> state, int size) {
        DIRECTION[] currentState = currentMapState.toArray(new DIRECTION[0]);
        List<String> result =
                IntStream.range(0, state.size())
                        .filter(i -> i < size)
                        .mapToObj(i -> currentState[i].abbrev)
                        .collect(Collectors.toList());
        return result;
    }

    private void addOneSpace() {
        int x = bridgeNumberGenerator.generate();

        if (x == DIRECTION.UP.ordinal())
            currentMapState.add(DIRECTION.UP);
        else
            currentMapState.add(DIRECTION.DOWN);

    }

}
