package bridge.dto;

import com.sun.net.httpserver.Authenticator;

public class printResultDto {
    private String state;
    private BridgeMapDto mapDto;
    private RetryCountDto retryCountDto;

    private printResultDto(String state, BridgeMapDto mapDto, RetryCountDto retryDto) {
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

    public static printResultDto of(String state, BridgeMapDto mapDto, RetryCountDto retryCount){
        return new printResultDto(state, mapDto, retryCount);
    }

}
