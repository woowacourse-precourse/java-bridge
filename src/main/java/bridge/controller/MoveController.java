package bridge.controller;

import bridge.BridgeMaker;
import bridge.Env;
import bridge.Lang;
import bridge.model.SlabDTO;
import bridge.model.Slabs;
import bridge.type.GlassType;
import bridge.type.PositionType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MoveController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Slabs database;

    public MoveController() {
        this.database = Slabs.getInstance();
    }

    public MoveController(Slabs database) {
        this.database = database;
    }

    public PositionType askDestination() {
        return this.inputView.readMoving();
    }

    public void moveToDestination(PositionType destinationPosition) {
        int step = this.getLastTreadStep() + 1;

        this.updateTread(this.getDestinationSlab(step, destinationPosition));
        this.printSlabMap(step);
    }

    public SlabDTO getDestinationSlab(int step, PositionType position) {
        return this.database.findByStep(step)
                .stream()
                .filter(dto -> dto.getPosition().equals(position))
                .findFirst()
                .orElseThrow();
    }

    public int getLastTreadStep() {
        return this.database.getAll()
                .stream()
                .filter(SlabDTO::isTread)
                .mapToInt(SlabDTO::getStep)
                .max()
                .orElseThrow();
    }

    public void updateTread(SlabDTO slab) {
        slab.setTread(true);

        if (!this.database.update(slab)) {
            throw new RuntimeException(Lang.get(Lang.ERROR_OCCUR_WHILE_SAVE_DATA));
        }
    }

    private void printSlabMap(int step) {
        List<SlabDTO> slabs = this.database.findByStep(step);
        List<List<String>> slabMaps = List.of(
                this.getSlabStatus(slabs, PositionType.UP),
                this.getSlabStatus(slabs, PositionType.DOWN)
        );

        this.outputView.printMap(slabMaps);
    }

    private List<String> getSlabStatus(List<SlabDTO> slabs, PositionType position) {
        return slabs
                .stream()
                .filter(dto -> dto.getPosition().equals(position))
                .map(dto -> this.convertSlabStatus(dto.getGlass(), dto.isTread()))
                .collect(Collectors.toList());
    }

    private String convertSlabStatus(GlassType glass, boolean isTread) {
        if (!isTread) {
            return Env.CODE_OF_BLANK;
        }

        return glass.getTypeName();
    }
}
