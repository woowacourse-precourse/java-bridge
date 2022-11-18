package bridge.model;

public class GameDTO {
    private static int startCount = 0;
    private static boolean Success = false;
    private static boolean reStart = false;

    public static int getStartCount() {
        return startCount;
    }//getRunCount

    public static void setRunCount(int startCount) {
        GameDTO.startCount = startCount;
    }//setRunCount

    public static boolean isSuccess() {
        return Success;
    }//isSuccess

    public static void setIsSuccess(boolean Success) {
        GameDTO.Success = Success;
    }//setIsSuccess

    public static boolean isReStart() {
        return reStart;
    }//isReStart

    public static void setReStart(boolean reStart) {
        GameDTO.reStart = reStart;
    }//setReStart
}// end class
