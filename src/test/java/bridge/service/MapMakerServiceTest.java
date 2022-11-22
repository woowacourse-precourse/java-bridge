package bridge.service;

import bridge.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[다리생성테스트]")
class MapMakerServiceTest {

    @Test
    @DisplayName("다리 생성 메시지 테스트 - 1")
    void makeMapTestOne() {
        MapMakerService mapMakerService = new MapMakerService(Arrays.asList("D", "D", "D"));
        User user = new User(Arrays.asList("D", "D", "D"));
        user.addMove("D");
        user.addMove("D");
        List<String> result = new ArrayList<>(Arrays.asList("[   |   ]", "[ O | O ]"));
        assertThat(mapMakerService.makeMap(user.getUserBridge()))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("다리 생성 메시지 테스트 - 2")
    void makeMapTestTwo() {
        MapMakerService mapMakerService = new MapMakerService(Arrays.asList("D", "U", "D"));
        User user = new User(Arrays.asList("D", "U", "D"));
        user.addMove("D");
        user.addMove("U");
        user.addMove("U");
        List<String> result = new ArrayList<>(Arrays.asList("[   | O | X ]", "[ O |   |   ]"));
        assertThat(mapMakerService.makeMap(user.getUserBridge()))
                .isEqualTo(result);
    }
}