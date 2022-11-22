package bridge.dto;

public class BridgeGameLocationDto {
    private static final String IS_NOT_NULL = "Null 일 수 없습니다.";
    private final String location;

    private BridgeGameLocationDto(final String location) {
        validateLog(location);
        this.location = location;
    }
    public static BridgeGameLocationDto of (final String location){
        return new BridgeGameLocationDto(location);
    }

    public String getLocation() {
        return location;
    }

    private void validateLog(final String location) {
        if (location == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }
}
