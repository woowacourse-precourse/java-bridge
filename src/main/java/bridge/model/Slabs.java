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

    public boolean insertAll(List<SlabDTO> data) {
        return this.database.addAll(data);
    }

    public boolean insert(SlabDTO data) {
        return this.database.add(data);
    }

    public List<SlabDTO> getAll() {
        return Collections.unmodifiableList(this.database);
    }
}
