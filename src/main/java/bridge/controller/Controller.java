package bridge.controller;

import bridge.Env;
import bridge.Lang;
import bridge.model.CounterDTO;
import bridge.model.Counters;
import bridge.model.SlabDTO;
import bridge.model.Slabs;
import bridge.type.GlassType;
import bridge.type.PositionType;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    protected final InputView inputView = new InputView();
    protected final OutputView outputView = new OutputView();
    protected final Counters counters;
    protected final Slabs slabs;

    public Controller() {
        this.slabs = Slabs.getInstance();
        this.counters = Counters.getInstance();
    }

    public Controller(Slabs database, Counters counters) {
        this.slabs = database;
        this.counters = counters;
    }

    protected int getLastTreadStep() {
        return this.slabs.getAll()
                .stream()
                .filter(SlabDTO::isTread)
                .mapToInt(SlabDTO::getStep)
                .max()
                .orElse(-1);
    }

    protected SlabDTO findSlabBy(int step, PositionType position) {
        return this.slabs.findByStep(step)
                .stream()
                .filter(dto -> dto.getPosition().equals(position))
                .findFirst()
                .orElseThrow();
    }

    protected void updateTread(SlabDTO slab) {
        slab.setTread(true);

        if (!this.slabs.update(slab)) {
            throw new RuntimeException(Lang.get(Lang.ERROR_OCCUR_WHILE_SAVE_DATA));
        }
    }

    protected List<List<String>> getSlapMaps(int step) {
        return List.of(
                this.getSlabStatusInRange(step, PositionType.UP),
                this.getSlabStatusInRange(step, PositionType.DOWN)
        );
    }

    private List<String> getSlabStatusInRange(int step, PositionType position) {
        List<String> slabStatus = new LinkedList<>();

        for (int index = 0; index <= step; index++) {
            List<SlabDTO> slabs = this.slabs.findByStep(index);
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

    protected int getRetries() {
        CounterDTO counter = this.counters.findByName(Env.NAME_OF_TRIES_NUMBER);
        counter = this.initRetries(counter);

        return counter.getValue();
    }

    protected boolean updateRetries() {
        CounterDTO counter = this.counters.findByName(Env.NAME_OF_TRIES_NUMBER);
        counter = this.initRetries(counter);
        counter.addValue(1);

        return this.counters.update(counter);
    }

    private CounterDTO initRetries(CounterDTO counter) {
        if (counter == null) {
            counter = new CounterDTO(Env.NAME_OF_TRIES_NUMBER, 0);
            this.counters.insert(counter);
        }

        return counter;
    }
}
