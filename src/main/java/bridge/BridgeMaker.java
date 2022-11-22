package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> Bridge = new ArrayList<>(size*3+1);
        return Bridge;
    }

    public List<String> bridgeAddMove(String move,List<String> Bridge ) {
        List<String> result = new ArrayList<>();
        if(move.charAt(1) == 'O'){
            result =  BridgeAdd(Bridge ,1);
        }
        else {
            result =  BridgeAdd(Bridge ,0);
        }
        return result;
    }

    public List<String> bridgeAddElseMove(List<String> Bridge ) {
        List<String> result = BridgeAddElse(Bridge);
        return result;
    }

    public List<String> BridgeAdd(List<String> Bridge, int chk) {
        if(chk == 1){
            Bridge.add(" ");
            Bridge.add("O");
            Bridge.add(" ");
            Bridge.add("|");
        }
        else{
            Bridge.add(" ");
            Bridge.add("X");
            Bridge.add(" ");
            Bridge.add("|");
        }
        return Bridge;
    }

    public List<String> BridgeAddElse(List<String> Bridge) {
        Bridge.add(" ");
        Bridge.add(" ");
        Bridge.add(" ");
        Bridge.add("|");
        return Bridge;
    }
}
