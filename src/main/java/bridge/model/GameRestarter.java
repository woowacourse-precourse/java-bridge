package bridge.model;

public class GameRestarter {
    private boolean restart = false;

    public boolean isRestart(String command) {
        if (command.equals("R")) {
            restart = true;
        }//if
        return restart;
    }//isRestart
}// end class
