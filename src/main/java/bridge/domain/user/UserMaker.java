package bridge.domain.user;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.user.CurrentBridgeElement.*;

public class UserMaker {
    public User makeUser(int bridgeSize) {
        List<List<String>> madeBridge = makeUsersCurrentBridge();
        return new User(madeBridge, bridgeSize);
    }

    // 다리 리스트에 "["와 "]" 추가
    public static List<List<String>> makeUsersCurrentBridge() {
        List<String> bridgeStructure = new ArrayList<>(List.of(HEAD.getElement(), TAIL.getElement()));
        List<List<String>> madeBridge = new ArrayList<>();

        madeBridge.add(new ArrayList<>(bridgeStructure));
        madeBridge.add(new ArrayList<>(bridgeStructure));
        return madeBridge;
    }
}
