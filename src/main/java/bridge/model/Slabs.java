package bridge.model;

import bridge.type.LangType;

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

    public int indexOf(String data) {
        int index = this.database.indexOf(data);

        if (index < 0) {
            throw new RuntimeException(LangType.get(LangType.NOT_FOUND_DATA));
        }

        //플레이어가 이동할 수 있는지 없는지 상태를 저장하는 클래스 만들기? Status? 그래서 여기에 넣기

        return index;
    }
}
