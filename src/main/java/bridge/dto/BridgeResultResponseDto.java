package bridge.dto;

public class BridgeResultResponseDto {

    private final int tryCount;

    private final String result;

    public BridgeResultResponseDto(int tryCount, String result){
        this.tryCount = tryCount;
        this.result = result;
    }

    public int getTryCount(){
        return this.tryCount;
    }

    public String getResult(){
        return this.result;
    }
}
