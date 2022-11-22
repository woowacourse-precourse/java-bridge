package bridge.model;

public class GameResultDto {
    private final String map;
    private final boolean isSuccess;
    private final int numberOfTry;

    public GameResultDto(String map, boolean isSuccess, int numberOfTry) {
        this.map = map;
        this.isSuccess = isSuccess;
        this.numberOfTry = numberOfTry;
    }

    public String getMap() {
        return map;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}