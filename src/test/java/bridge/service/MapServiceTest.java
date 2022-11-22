package bridge.service;

import bridge.domain.GameProgress;
import bridge.service.MapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MapServiceTest {

    GameProgress gameProgress;
    MapService mapService;

    @BeforeEach
    void init() {
        gameProgress = new GameProgress();
        mapService = new MapService();
    }

    @Test
    void getMap_지도_테스트1() {
        //given
        String expect = "[ O | O |   ]\n" +
                        "[   |   | X ]";
        gameProgress.add("U", true);
        gameProgress.add("U", true);
        gameProgress.add("D", false);

        //when
        String map = mapService.getMap(gameProgress);

        //then
        assertThat(map).isEqualTo(expect);
    }

    @Test
    void getMap_지도_테스트2() {
        //given
        String expect = "[ O |   |   ]\n" +
                        "[   | O | O ]";
        gameProgress.add("U", true);
        gameProgress.add("D", true);
        gameProgress.add("D", true);

        //when
        String map = mapService.getMap(gameProgress);

        //then
        assertThat(map).isEqualTo(expect);
    }
}