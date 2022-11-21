package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge make(int size) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(maker.makeBridge(size));
    }

    public boolean isProceeding(List<String> user) {
        return this.bridge.size() > user.size();
    }

    public Result compare(List<String> user) {
        for (int i = 0; i < user.size(); i++) {
            if (!bridge.get(i).equals(user.get(i))) {
                return Result.FAIL;
            }
        }
        return Result.SUCCESS;
    }

    public String getMap(List<String> user) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < user.size(); i++) {
            if (!bridge.get(i).equals(user.get(i))) {
                stringBuilder.append("X");
                continue;
            }
            stringBuilder.append("O");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                '}';
    }
}
