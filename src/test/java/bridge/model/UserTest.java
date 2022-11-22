package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserTest {

    @Test
    @DisplayName("사용자 이동")
    void addPath() {
        User user = new User(new ArrayList<>());
        user.addPath(new Path(any(), any()));

        assertEquals(1, user.getPath().size());
    }

    @Test
    @DisplayName("사용자 경로 초기화")
    void clear() {
        List<Path> path = new ArrayList<>();
        path.add(new Path(any(), any()));
        User user = new User(path);

        assertEquals(1, user.getPath().size());
        user.clear();
        assertTrue(user.getPath().isEmpty());
    }
}