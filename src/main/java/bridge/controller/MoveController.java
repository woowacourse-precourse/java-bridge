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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void initializeTread() {
        this.database.getAll()
                .forEach(dto -> dto.setTread(false));
    }

    public boolean moveToDestination(PositionType destinationPosition) {
        int step = this.getLastTreadStep() + 1;
        SlabDTO destinationSlab = this.findSlabBy(step, destinationPosition);

        return this.updateAndPrintSlab(destinationSlab, step);
    }

    public boolean getMoveResult() {
        int step = this.getLastTreadStep();

        return Stream.of(
                this.findSlabBy(step, PositionType.UP),
                this.findSlabBy(step, PositionType.DOWN)
        ).anyMatch(dto -> dto.isTread() && dto.getGlass() == GlassType.TEMPERED);
    }

    public int getLastTreadStep() {
        return this.database.getAll()
                .stream()
                .filter(SlabDTO::isTread)
                .mapToInt(SlabDTO::getStep)
                .max()
                .orElseThrow();
    }

    public SlabDTO findSlabBy(int step, PositionType position) {
        return this.database.findByStep(step)
                .stream()
                .filter(dto -> dto.getPosition().equals(position))
                .findFirst()
                .orElseThrow();
    }

    private boolean updateAndPrintSlab(SlabDTO destinationSlab, int step) {
        boolean canContinue = this.canContinue(destinationSlab);

        if (canContinue) {
            this.updateTread(destinationSlab);
            this.outputView.printMap(this.getSlapMaps(step));
        }

        return canContinue;
    }

    private boolean canContinue(SlabDTO slab) {
        int size = this.database.getAll().size() / 2;

        return slab.getStep() < size
                && slab.getGlass() == GlassType.TEMPERED;
    }

    public void updateTread(SlabDTO slab) {
        slab.setTread(true);

        if (!this.database.update(slab)) {
            throw new RuntimeException(Lang.get(Lang.ERROR_OCCUR_WHILE_SAVE_DATA));
        }
    }

    public List<List<String>> getSlapMaps(int step) {
        return List.of(
                this.getSlabStatusInRange(step, PositionType.UP),
                this.getSlabStatusInRange(step, PositionType.DOWN)
        );
    }

    private List<String> getSlabStatusInRange(int step, PositionType position) {
        List<String> slabStatus = new LinkedList<>();

        for (int index = 0; index <= step; index++) {
            List<SlabDTO> slabs = this.database.findByStep(index);
            slabStatus.addAll(this.getSlabStatus(slabs, position));
        }

        return slabStatus;
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
