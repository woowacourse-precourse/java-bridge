package bridge;

public class Round {

    boolean passFail;
    boolean passFailFinal;
    String userGameCommandInput;

    public Round(boolean passFail, boolean passFailFinal, String userGameCommandInput) {
        this.passFail = passFail;
        this.passFailFinal = passFailFinal;
        this.userGameCommandInput = userGameCommandInput;
    }



    public boolean isPassFail() {
        return passFail;
    }

    public void setPassFail(boolean passFail) {
        this.passFail = passFail;
    }

    public boolean isPassFailFinal() {
        return passFailFinal;
    }

    public void setPassFailFinal(boolean passFailFinal) {
        this.passFailFinal = passFailFinal;
    }

    public String getUserGameCommandInput() {
        return userGameCommandInput;
    }

    public void setUserGameCommandInput(String userGameCommandInput) {
        this.userGameCommandInput = userGameCommandInput;
    }



}