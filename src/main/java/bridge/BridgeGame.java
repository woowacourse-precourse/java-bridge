package bridge;

import java.util.ArrayList;
import java.util.List;


public class BridgeGame {

    private int count = 0;
    private List<String> answerList;
    public List<String> inputList;

    public void increaseCount(){
        this.count++;
    }

    public int getCount(){
        return this.count;
    }

    public BridgeGame(List<String> answerList){
        this.answerList = answerList;
        this.inputList = new ArrayList<>();
    }

    public List<String> getAnswerList(){
        return this.answerList;
    }

    public List<String> getInputList(){
        return this.inputList;
    }

    public String move(String input) {
        inputList.add(input);
        String answer = answerList.get(inputList.size()-1);
        if(answer.equals(input)) {
            increaseCount();
            return "O";
        }
        return "X";
    }

    public boolean retry(String input) {
        if(input.equals("R")) return true;
        return false;
    }
}
