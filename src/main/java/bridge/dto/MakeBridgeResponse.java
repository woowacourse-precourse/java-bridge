package bridge.dto;

import bridge.constant.ViewStatus;

public class MakeBridgeResponse {
    private final ViewStatus viewStatus;

    public MakeBridgeResponse(ViewStatus viewStatus) {
        this.viewStatus = viewStatus;
    }

    public ViewStatus getViewStatus() {
        return viewStatus;
    }

    public static MakeBridgeResponse from(ViewStatus viewStatus) {
        return new MakeBridgeResponse(viewStatus);
    }
}
