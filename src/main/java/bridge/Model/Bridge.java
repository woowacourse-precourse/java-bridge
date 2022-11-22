package bridge.Model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;  // 건널 수 있는 칸을 정의한 리스트

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public int getSize(){
        return bridge.size();
    }

    public String movingResult(int index, String command){
        String answer = bridge.get(index);
        if (command.equals(answer)){
            return "O";
        }
        return "X";
    }
}
