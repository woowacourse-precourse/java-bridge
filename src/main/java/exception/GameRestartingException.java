package exception;

import message.ErrorMessage;
import view.OutputView;

public class GameRestartingException {
    private final String restarting;
    OutputView outputView = new OutputView();

    public GameRestartingException(String starting) {
        validate(starting);
        this.restarting = starting;
    }

    void validate(String starting) {
        if(!(starting.equals("R") || starting.equals("Q"))) {
            outputView.printError(ErrorMessage.Game_Restarting.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public String getRestarting() {
        return restarting;
    }
}
