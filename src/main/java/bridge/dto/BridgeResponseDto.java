package bridge.dto;

import bridge.domain.Player;
import java.util.List;

public class BridgeResponseDto {

    private List<String> upsideBridge;
    private List<String> downsideBridge;

    public BridgeResponseDto showBridge(Player player){
        this.upsideBridge = player.showUpsideBridgeToString();
        this.downsideBridge = player.showDownsideBridge();

        return this;
    }

    public List<String> getUpsideBridge(){
        return upsideBridge;
    }

    public List<String> getDownsideBridge(){
        return downsideBridge;
    }
}
