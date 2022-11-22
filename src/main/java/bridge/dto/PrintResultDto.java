package bridge.dto;

public class PrintResultDto {
    private String state;
    private BridgeMapDto mapDto;
    private RetryCountDto retryCountDto;

    private PrintResultDto(String state, BridgeMapDto mapDto, RetryCountDto retryDto) {
        this.state = state;
        this.mapDto = mapDto;
        this.retryCountDto = retryDto;
    }

    public String getState() {
        return state;
    }

    public BridgeMapDto getMapDto() {
        return mapDto;
    }

    public RetryCountDto getRetryCountDto() {
        return retryCountDto;
    }

    public static PrintResultDto of(String state, BridgeMapDto mapDto, RetryCountDto retryCount){
        return new PrintResultDto(state, mapDto, retryCount);
    }

}
