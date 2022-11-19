package bridge.model;

public enum Restart {

    TRUE("R"),
    FALSE("Q"),
    NULL("");

    private final String input;

    Restart(String input){
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public static Restart getRestartByString(String input){
        if(input.equals(TRUE.getInput())){
            return TRUE;
        }
        return FALSE;
    }
}
