package bridge.model;

public class GameRestarter {

    public boolean isRestart(String command) {
        boolean restart = false;
        if (command.equals("R")) {
            restart = true;
        }//if
        return restart;
    }//isRestart
}// end class
