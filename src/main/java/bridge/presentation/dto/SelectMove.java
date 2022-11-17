package bridge.presentation.dto;

public class SelectMove {
    private String move;

    public SelectMove(String input){
        validate(input);
        move=input;
    }
    private void validate(String target){

    }

    public String getMove() {
        return move;
    }
}
