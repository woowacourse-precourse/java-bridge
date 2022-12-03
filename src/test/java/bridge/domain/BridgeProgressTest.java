package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeProgressTest {
    BridgeProgress progress = new BridgeProgress();
    @Test
    @BeforeEach
    public void progressTest(){
        Integer size = 20;
        for (int i = 0; i < size; i++) {
            progress.put("O", " ");
        }
    }

    @Test
    public void sizeTest(){
        assertThat(progress.size()).isEqualTo(20);
    }

    @Test
    public void clearTest(){
        progress.clear();
        assertThat(progress.size()).isEqualTo(0);
    }

}