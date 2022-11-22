package bridge.dto.bridge;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
//        System.out.println(bridge); // @TODO: 삭제
        return bridge;
    }
}
