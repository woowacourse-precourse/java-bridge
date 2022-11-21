package bridge.User;

import bridge.Bridge.Bridge;
import java.util.ArrayList;
import java.util.List;

import bridge.InputView;
import bridge.OutputView;



public class User {
    public List<String> inputHistory;
    public List<String> correctnessHistory;

    public User() {
        inputHistory = new ArrayList<String>();
        correctnessHistory = new ArrayList<String>();
    }

    // 게임진행 중 'U' or 'D' 여부 추가
    public void appendCurrentUserMovinginput(){
        String currentInput;

        OutputView.printReadMoving();
        currentInput = InputView.readMoving();

        inputHistory.add(currentInput);
        // currentInput 정답 확인 후 history에 추가
        String currentCorrectness = checkCorrectness(currentInput);
        correctnessHistory.add(currentCorrectness);

        // printMap
        OutputView.printMap(Bridge.bridgePattern, inputHistory);
    }

    public String checkCorrectness(String currentInput){
        int currentIndex = this.getTotalInputLength()-1;

        if(Bridge.bridgePattern.get(currentIndex).equals(currentInput)){
            if(currentInput.equals("U")){
                return "U";
            }
            if(currentInput.equals("D")){
                return "D";
            }
        }
        return "X";
    }

    public String readUserCommandInput(){
        return InputView.readGameCommand();
    }

    public int getTotalInputLength(){
        return inputHistory.size();
    }
}
