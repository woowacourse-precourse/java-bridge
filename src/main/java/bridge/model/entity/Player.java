package bridge.model.entity;

public class Player {

    private String answer;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private void validate(){ //TODO: Validator 구현할 때 조건 추가하기
        if(answer != "A"){
            throw new IllegalArgumentException("[ERROR] 테스트입니다.");
        }
    }

}
