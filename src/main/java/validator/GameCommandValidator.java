package validator;

public class GameCommandValidator {

    String gameCommand;

    public GameCommandValidator(String gameCommand) {
        this.gameCommand = gameCommand;
        validate();
    }

    private void validate(){
        validateInputNonBlank();
        validateInputValue();
    }

    private void validateInputNonBlank() {
        if(gameCommand.equals("")){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private void validateInputValue() {
        if(!gameCommand.equals("Q")&&!gameCommand.equals("R")){
            throw new IllegalArgumentException("[ERROR] 대문자 Q 또는 대문자 R을 입력해야 합니다.");
        }
    }

}