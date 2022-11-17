package bridge.dto;

public class UserDto {
    private final int bridgeSize;
    private String moving;
    private String gameCommand;

    public UserDto(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }
}
