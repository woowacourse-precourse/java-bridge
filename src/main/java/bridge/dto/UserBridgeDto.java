package bridge.dto;

import bridge.domain.UserBridge;
import java.util.List;

public class UserBridgeDto {

    private List<String> upBridge;
    private List<String> downBridge;

    public UserBridgeDto(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public static UserBridgeDto from(UserBridge userBridge) {
        return new UserBridgeDto(userBridge.getUpBridge(), userBridge.getDownBridge());
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
