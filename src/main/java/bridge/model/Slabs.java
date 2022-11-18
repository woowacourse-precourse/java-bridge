package bridge.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Slabs {
    private static Slabs slabs;
    private final List<String> database;

    private Slabs() {
        this.database = new LinkedList<>();
    }

    public static Slabs getInstance() {
        if (slabs == null) {
            slabs = new Slabs();
        }

        return slabs;
    }

    public boolean insertAll(List<String> data) {
        return this.database.addAll(data);
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(this.database);
    }
}
