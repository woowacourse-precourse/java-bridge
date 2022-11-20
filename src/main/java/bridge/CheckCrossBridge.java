package bridge;

import java.util.List;

public class CheckCrossBridge {

    public boolean check(String userInput, List<String> bridge, int round){
        if(bridge.get(round-1).equals(userInput)){ //선택한 값이 같으면(건널 수 있는 칸 고른 것)
            return true;
        }
        return false;
    }

}
