package bridge;

public class DtoClass {
    private int bridgeSize;
    private String movingCommand;
    private String restartCommand;

    public void sizeValue(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }
    public void movingValue(String movingCommand) {
        this.movingCommand =movingCommand;
    }
    public void restartValue(String restartCommand) {
        this.restartCommand = restartCommand;
    }
    public int getBridgeSize(){
        return this.bridgeSize;
    }
    public String getMovingCommand(){
        return this.movingCommand;
    }
    public String getRestartCommand(){
        return this.restartCommand;
    }
}
