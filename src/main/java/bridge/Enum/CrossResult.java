package bridge.Enum;

public enum CrossResult {
    SUCCESS(true, "O"),
    FAIL(false, "X");

    private final boolean bool;
    private final String string;

    private CrossResult(boolean bool, String string){
        this.bool = bool;
        this.string = string;
    }

    public String getString(){
        return string;
    }
}
