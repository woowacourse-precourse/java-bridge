package bridge.exeption;


import java.util.List;

public class Validator {

    public void checkSizeByInt(String sizeName) {
        try {
            Integer.parseInt(sizeName);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionMessage.incorrectSize.getMessage());
        }
    }

    public void checkSizeInScope(String sizeName) {
        int size = Integer.parseInt(sizeName);
        if (20 < size || size < 3) {
            throw new IllegalArgumentException(
                    ExceptionMessage.sizeOverScope.getMessage());
        }
    }

    public void checkBridgeSize(int size, List<String> bridge) {
        if (size != bridge.size()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.bridgeNotEqualsSize.getMessage());
        }
    }

    public void checkBridgeWord(int size, List<String> bridge) {
        long count = bridge.stream()
                .filter(s -> s.equals("U") || s.equals("D")).count();

        if (count != size) {
            throw new IllegalArgumentException(
                    ExceptionMessage.createBridgeWordNotUD.getMessage());
        }
    }

    public void checkMoveWord(String move) {
        if(!move.equals("U") && !move.equals("D")){
            throw new IllegalArgumentException(
                    ExceptionMessage.moveByNotUD.getMessage());
        }
    }

    public void checkCommandWord(String command) {
        if(!command.equals("R") && !command.equals("Q")){
            throw new IllegalArgumentException(
                    ExceptionMessage.commandByNotRQ.getMessage());
        }
    }

}
