package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    List<String> User_Bridge = new ArrayList<>();

    public boolean Compare_User_Move_and_Bridge(String User_Move, List<String> Bridge, Integer Sucess_Number) {
        Integer Sucess_Index = Sucess_Number;
        return (User_Move.equals(Bridge.get(Sucess_Index)));
    }

    public List<String> Make_User_Bridge(String User_Move) {
        User_Bridge.add(User_Move);
        return User_Bridge;
    }

    public boolean Bridge_length_isEqual(List<String> Bridge, List<String> User_Bridge) {
        return (User_Bridge.size() == Bridge.size());
    }

}
