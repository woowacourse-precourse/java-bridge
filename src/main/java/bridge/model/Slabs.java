package bridge.model;

import bridge.type.LangType;
import bridge.type.SlabType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Slabs {
    private static Slabs slabs;
    private final List<SlabType> database;

    private Slabs() {
        this.database = new LinkedList<>();
    }

    public static Slabs getInstance() {
        if (slabs == null) {
            slabs = new Slabs();
        }

        return slabs;
    }

    public boolean insertAll(List<SlabType> data) {
        return this.database.addAll(data);
    }

    public List<SlabType> getAll() {
        return Collections.unmodifiableList(this.database);
    }

    public int indexOf(SlabType data) {
        int index = this.database.indexOf(data);

        if (index < 0) {
            throw new RuntimeException(LangType.get(LangType.NOT_FOUND_DATA));
        }

        return index;
    }
}
