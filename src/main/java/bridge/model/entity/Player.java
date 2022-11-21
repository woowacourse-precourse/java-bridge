package bridge.model.entity;

import java.util.List;

public class Player {

    private String answer;

    private Player() {
        this.answer = "R";
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer(){
        return this.answer;
    }

    private void validate(String answer){ //TODO: Validator 구현할 때 조건 추가하기
        List<String> validString = List.of("U", "D");
        if(!validString.contains(answer)){
            throw new IllegalArgumentException("[ERROR] 테스트입니다.");
        }
    }

    public static Player of(){
        return new Player();
    }

}
