package bridge.model.dto;

public class MoveResultDto {

    private final boolean isRightLastBridgePick;
    private final boolean isMovableStatus;

    public MoveResultDto(boolean isRightLastBridgePick, boolean isMovableStatus) {
        this.isRightLastBridgePick = isRightLastBridgePick;
        this.isMovableStatus = isMovableStatus;
    }

    public boolean isRightLastBridgePick() {
        return isRightLastBridgePick;
    }

    public boolean isMovableStatus() {
        return isMovableStatus;
    }
}
