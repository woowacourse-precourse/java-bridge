package bridge.Model.VO;

public class UserCommand {
    private static final String QUIT = "Q";
    private static final String RETRY = "R";

    private String command;

    public UserCommand(String command){
        validData(command);
        this.command = command;
    }

    public void validData(String command) throws IllegalArgumentException{
        if(command.equals(QUIT) || command.equals(RETRY)){
            return;
        }

        throw new IllegalArgumentException("올바른 값을 입력해주세요");
    }

    public boolean isQuit(){
        return command.equals(QUIT);
    }

    public boolean isRetry(){
        return command.equals(RETRY);
    }
}
