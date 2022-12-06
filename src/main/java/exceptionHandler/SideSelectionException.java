package exceptionHandler;

public class SideSelectionException extends BridgeGenerationException {
    public static void validate(String gameCommand) {
        validateEachSide(gameCommand);
    }
}