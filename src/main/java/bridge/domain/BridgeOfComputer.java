package bridge.domain;

import bridge.utils.Validator;
import java.util.List;

public class BridgeOfComputer {

    private List<String> map;

    public BridgeOfComputer(List<String> map) {
        this.map = map;
    }

    public boolean match(int stage, String moveSide) {
        Validator.checkIsSide(moveSide);
        String answer = map.get(stage);
        return answer.equals(moveSide);
    }

    public int getLength() {
        return map.size();
    }
}
