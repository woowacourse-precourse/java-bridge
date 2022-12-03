package bridge;

public enum GameResult {
    Y("O", "성공"),
    N("X", "실패");

    private final String movingSign;
    private final String movingResult;

    GameResult(String movingSign, String movingResult) {
        this.movingSign = movingSign;
        this.movingResult = movingResult;
    }

    public static String getMovingSign(boolean status){
        if (status){
            return Y.movingSign;
        }
        return N.movingSign;
    }

    public static String getResult(boolean status){
        if (status){
            return Y.movingResult;
        }
        return N.movingResult;
    }
}
