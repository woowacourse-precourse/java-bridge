package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.SlabDTO;
import bridge.type.GlassType;
import bridge.type.PositionType;

import java.util.List;

public class ReadyController extends Controller {
    private final BridgeMaker bridgeMaker = BridgeMaker.getInstance();

    public ReadyController() {
        super();
    }

    public void printGameIntroduce() {

    }

    public int askBridgeSize() {
        return this.inputView.readBridgeSize();
    }

    public void buildBridge(int size) {
        List<String> bridge = this.bridgeMaker.makeBridge(size);

        for (int index = 0; index < size; index++) {
            List<SlabDTO> slabs = this.convertToSlabs(index, bridge.get(index));
            this.slabs.insertAll(slabs);
        }
    }

    private List<SlabDTO> convertToSlabs(int step, String safePosition) {
        PositionType position = PositionType.build(safePosition);

        return List.of(
                new SlabDTO(step, position, GlassType.TEMPERED),
                new SlabDTO(step, PositionType.build(position.getId() ^ 1), GlassType.NORMAL)
        );
    }
}
