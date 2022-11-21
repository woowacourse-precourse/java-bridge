package bridge;

import java.util.List;

public class CheckCrossBridge {

    public boolean check(String userInput, List<String> bridge, int round){
        System.out.println("userInput"+userInput);
        System.out.println("bridge"+bridge);
        System.out.println("round"+round);
        if(bridge.get(round-1).equals(userInput)){ //선택한 값이 같으면(건널 수 있는 칸 고른 것)
            System.out.println("same");
            return true;
        }
        System.out.println("diff");
        return false;
    }

}
