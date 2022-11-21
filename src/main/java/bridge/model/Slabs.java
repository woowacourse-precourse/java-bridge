package bridge.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Slabs {
    private static Slabs slabs;
    private final List<SlabDTO> database;

    private Slabs() {
        this.database = new LinkedList<>();
    }

    public static Slabs getInstance() {
        if (slabs == null) {
            slabs = new Slabs();
        }

        return slabs;
    }

    public static Slabs newInstance() {
        return new Slabs();
    }

    public boolean insertAll(List<SlabDTO> data) {
        return data.stream().allMatch(this::insert);
    }

    public boolean insert(SlabDTO data) {
        if (this.findAs(data) != null) {
            return false;
        }

        return this.database.add(data);
    }

    public boolean update(SlabDTO data) {
        if (this.findAs(data) == null) {
            return false;
        }

        int index = this.indexOf(data);

        return (this.database.set(index, data) != null);
    }

    private int indexOf(SlabDTO data) {
        return this.database.indexOf(this.findAs(data));
    }

    private SlabDTO findAs(SlabDTO data) {
        return this.database
                .stream()
                .filter(dto -> this.compare(dto, data))
                .findFirst()
                .orElse(null);
    }

    private boolean compare(SlabDTO previous, SlabDTO current) {
        return previous.getStep() == current.getStep() &&
                previous.getPosition().equals(current.getPosition());
    }

    public List<SlabDTO> getAll() {
        return Collections.unmodifiableList(this.database);
    }

    public SlabDTO get(int index) {
        return this.database.get(index);
    }
}
