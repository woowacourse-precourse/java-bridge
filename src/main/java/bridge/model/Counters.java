package bridge.model;

import java.util.LinkedList;
import java.util.List;

public class Counters {
    private static Counters counters;
    private final List<CounterDTO> database;

    private Counters() {
        this.database = new LinkedList<>();
    }

    public static Counters getInstance() {
        if (counters == null) {
            counters = new Counters();
        }

        return counters;
    }

    public static Counters newInstance() {
        return new Counters();
    }

    public boolean insert(CounterDTO data) {
        if (this.findByDTO(data) != null) {
            return false;
        }

        return this.database.add(data);
    }

    public boolean update(CounterDTO data) {
        if (this.findByDTO(data) == null) {
            return false;
        }

        int index = this.indexOf(data);

        return (this.database.set(index, data) != null);
    }

    private int indexOf(CounterDTO data) {
        return this.database.indexOf(this.findByDTO(data));
    }

    public CounterDTO findByDTO(CounterDTO data) {
        return this.database
                .stream()
                .filter(dto -> dto.equals(data))
                .findFirst()
                .orElse(null);
    }

    public CounterDTO findByName(String name) {
        return this.database
                .stream()
                .filter(dto -> dto.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public CounterDTO get(int index) {
        return this.database.get(index);
    }
}
