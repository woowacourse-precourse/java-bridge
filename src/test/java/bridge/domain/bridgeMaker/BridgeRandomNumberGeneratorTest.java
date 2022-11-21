package bridge.domain.bridgeMaker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static org.assertj.core.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {

	@DisplayName("RandomNumberGenerator의 난수 발생 정확도를 검증한다")
	@RepeatedTest(50)
	void verify_BridgeRandomNumberGenerator_CanGenerateRandomNumberCorrectly() {

		/**
		 * 랜덤 생성기의 난수 생성 범위는 0 이상 1 이하의 자연수로 설정되어 있으므로 0과 1을 생성한다.
		 * <p>
		 * 랜덤을 생성하는 수가 무한에 가까워질수록 두 수의 출연 빈도는 각각 50%에 수렴할 것이므로
		 * 생성이 1,000,000회 이상일 경우 잔차는 0.01 미만일 것으로 가정하여 난수의 발생을 검증한다.
		 */

		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

		List<Integer> counts = new ArrayList<>();
		counts.add(0);
		counts.add(0);

		int countTrial = 1000000;

		for (int counter = 0; counter < countTrial; counter++) {
			int randomNumber = bridgeRandomNumberGenerator.generate();
			counts.set(randomNumber, counts.get(randomNumber) + 1);
		}

		double occurrenceFrequencyOfNumber0 = counts.get(0) / (double) countTrial;
		double occurrenceFrequencyOfNumber1 = counts.get(1) / (double) countTrial;
		double frequencyErrorTerm = abs(occurrenceFrequencyOfNumber0 - occurrenceFrequencyOfNumber1);

		assertThat(frequencyErrorTerm).isLessThan(0.01);
	}
}
