package bridge.Model;

import bridge.Crossing;

public class UserChoice {
    private String choice;

    public UserChoice(String choice){
        validData(choice);
        this.choice = choice;
    }

    private void validData(String choice){
        if(choice.equals(Crossing.DOWN.getString()) || choice.equals(Crossing.UP.getString())){
            return;
        }
        throw new IllegalArgumentException("올바른 값을 입력해주세요");
    }

    public String getChoice(){
        return choice;
    }
}
