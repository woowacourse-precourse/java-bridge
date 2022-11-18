package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CollectionStudy {
    @Test
    void containsAll_학습() {
        List<String> source = List.of("b", "a", "a");
        source = source.subList(0, 2);
        List<String> target = List.of("a", "a");
        assertThat(source.containsAll(target)).isTrue();
    }

    @Test
    void equals_학습() {
        List<String> source = List.of("b", "a", "a");
        source = source.subList(0, 2);
        List<String> target = List.of("a", "a");
        assertThat(source.equals(target)).isFalse();
    }
}
