package bridge.model;

public class GameDTO {
    private static int startCount = 0;
    private static boolean Success = false;

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
}// end class
