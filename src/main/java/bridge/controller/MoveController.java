package bridge.controller;

import bridge.model.SlabDTO;
import bridge.type.GlassType;
import bridge.type.PositionType;
import java.util.stream.Stream;

public class MoveController extends Controller {
    public MoveController() {
        super();
    }

    public PositionType askDestination() {
        return this.inputView.readMoving();
    }

    public void initializeTread() {
        this.slabs.getAll()
                .forEach(dto -> dto.setTread(false));
    }

    public boolean moveToDestination(PositionType destinationPosition) {
        int step = this.getLastTreadStep() + 1;
        SlabDTO destinationSlab = this.findSlabBy(step, destinationPosition);

        return this.updateAndPrintSlab(destinationSlab, step);
    }

    public boolean getMoveResult() {
        this.updateRetries();
        int step = this.getLastTreadStep();

        return Stream.of(
                this.findSlabBy(step, PositionType.UP),
                this.findSlabBy(step, PositionType.DOWN)
        ).anyMatch(dto -> dto.isTread() && dto.getGlass() == GlassType.TEMPERED);
    }

    private boolean updateAndPrintSlab(SlabDTO destinationSlab, int step) {
        this.updateTread(destinationSlab);

        boolean canContinue = this.canContinue(destinationSlab);
        this.outputView.printMap(this.getSlapMaps(step));

        return canContinue;
    }

    private boolean canContinue(SlabDTO slab) {
        int size = this.slabs.getAll().size() / 2;

        return slab.getStep() < (size - 1)
                && slab.getGlass() == GlassType.TEMPERED;
    }
}
