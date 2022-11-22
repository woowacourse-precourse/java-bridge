package bridge.command;

import java.util.ArrayList;
import java.util.List;

public class UpCommand implements Command{
    private List<String> answer;
    private List<String> history;
    private List<String> ups;

    public UpCommand(List<String> answer, List<String> history) {
        this.answer = answer;
        this.history = history;
        ups = new ArrayList<>();
    }

    @Override
    public List<String> executeAll(List<String> answer, List<String> history) {
        for (int i = 0; i < history.size(); i++) {
            executeConditionUCorrect(i);
            executeConditionUInCorrect(i);
            executeConditionDCorrect(i);
            executeConditionDInCorrect(i);
        }
        return ups;
    }
    @Override
    public void executeConditionUCorrect(int index){
        if(answer.get(index).equals("U") && history.get(index).equals("U")){
            ups.add("O");
        }
    }

    @Override
    public void executeConditionUInCorrect(int index) {
        if(answer.get(index).equals("U") && history.get(index).equals("D")){
            ups.add(" ");
        }
    }

    @Override
    public void executeConditionDCorrect(int index) {
        if(answer.get(index).equals("D") && history.get(index).equals("D")){
            ups.add(" ");
        }
    }

    @Override
    public void executeConditionDInCorrect(int index) {
        if(answer.get(index).equals("D") && history.get(index).equals("U")){
            ups.add("X");
        }
    }
}
