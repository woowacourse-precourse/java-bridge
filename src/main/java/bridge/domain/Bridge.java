package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public int getBridgeSize(){
        return bridge.size();
    }

    public boolean isMoveAble(int position, String route){
        return bridge.get(position).equals(route);
    }

    public List<Integer> getAnswerLineIndex(String line){
        ArrayList<Integer> answerLineIndex = new ArrayList<>();

        for(int i = 0; i<bridge.size(); i++){
            addAnswer(i, line, answerLineIndex);
        }
        return answerLineIndex;
    }

    private void addAnswer(int index, String route, List<Integer> answer){
        if(bridge.get(index).equals(route)){
            answer.add(index);
        }
    }
}
