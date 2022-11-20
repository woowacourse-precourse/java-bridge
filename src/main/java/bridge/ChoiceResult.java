package bridge;

public enum ChoiceResult {
    SUCCESS(true, "O"),
    FAIL(false, "X");

    private final boolean bool;
    private final String string;

    private ChoiceResult(boolean bool, String string){
        this.bool = bool;
        this.string = string;
    }
}
