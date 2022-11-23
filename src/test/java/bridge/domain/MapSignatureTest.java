package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapSignatureTest {

    @DisplayName("이동 방향과 현재 다리의 방향이 다르면 공백를 반환한다.")
    @Test
    void getBLANKSignatureFromRecord() {
        // given
        Record record = new Record(BridgeCell.UP, true);
        BridgeCell direction = BridgeCell.DOWN;

        // when
        String signature = MapSignature.getSignatureFromRecord(record, direction);

        // then
        assertThat(signature).isEqualTo(" ");
    }

    @DisplayName("이동 방향과 현재 다리의 방향이 같고 건널 수 있다면 O를 반환한다.")
    @Test
    void getSuccessSignatureFromRecord() {
        // given
        Record record = new Record(BridgeCell.UP, true);
        BridgeCell direction = BridgeCell.UP;

        // when
        String signature = MapSignature.getSignatureFromRecord(record, direction);

        // then
        assertThat(signature).isEqualTo("O");
    }

    @DisplayName("이동 방향과 현재 다리의 방향이 같고 건널 수 없다면 X를 반환한다.")
    @Test
    void getFAILSignatureFromRecord() {
        // given
        Record record = new Record(BridgeCell.UP, false);
        BridgeCell direction = BridgeCell.UP;

        // when
        String signature = MapSignature.getSignatureFromRecord(record, direction);

        // then
        assertThat(signature).isEqualTo("X");
    }

}
