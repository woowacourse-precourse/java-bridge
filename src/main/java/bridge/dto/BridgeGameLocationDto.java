package bridge.dto;

public class BridgeGameLocationDto {
    private static final String IS_NOT_NULL = "Null 일 수 없습니다.";
    private final String location;

    private BridgeGameLocationDto(String location) {
        validateLog(location);
        this.location = location;
    }
    public static BridgeGameLocationDto of (String location){
        return new BridgeGameLocationDto(location);
    }

    public String getLocation() {
        return location;
    }

    private void validateLog(String location) {
        if (location == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }
}
