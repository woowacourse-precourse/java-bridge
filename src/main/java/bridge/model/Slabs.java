package bridge.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (this.findByDTO(data) != null) {
            return false;
        }

        return this.database.add(data);
    }

    public boolean update(SlabDTO data) {
        if (this.findByDTO(data) == null) {
            return false;
        }

        int index = this.indexOf(data);

        return (this.database.set(index, data) != null);
    }

    private int indexOf(SlabDTO data) {
        return this.database.indexOf(this.findByDTO(data));
    }

    public SlabDTO findByDTO(SlabDTO data) {
        return this.database
                .stream()
                .filter(dto -> dto.equals(data))
                .findFirst()
                .orElse(null);
    }

    public List<SlabDTO> findByStep(int step) {
        return this.database
                .stream()
                .filter(dto -> dto.getStep() == step)
                .collect(Collectors.toList());
    }

    public List<SlabDTO> getAll() {
        return Collections.unmodifiableList(this.database);
    }

    public SlabDTO get(int index) {
        return this.database.get(index);
    }

    public int size() {
        return this.database.size();
    }
}
