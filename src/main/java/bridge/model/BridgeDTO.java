package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeDTO {
    private static int size = 0;
    private static List<String> userResult = new ArrayList<>();
    private static List<String> computerResult = new ArrayList<>();

    public static void setSize(int size) {
        BridgeDTO.size = size;
    }//setSize

    public static int getSize() {
        return size;
    }//getSize

    public static void setUserResult(List<String> userResult) {
        BridgeDTO.userResult = userResult;
    }//setUserResult

    public static List<String> getUserResult() {
        return userResult;
    }//getUserResult

    public static void setComputerResult(List<String> computerResult) {
        BridgeDTO.computerResult = computerResult;
    }//setComputerResult

    public static List<String> getComputerResult() {
        return computerResult;
    }//getComputerResult
}//end class
