### 과제

위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

오징어게임의 다리건너기와 거의 동일하다.

### 코드흐름

1. 다리의 길이를 숫자로 입력받는다.
2. 다리를 생성한다.
  - 건널 수 있는 칸은 0과 1중 무작위로 정한다.
  - 0이 나왔으면 아래 칸만 건널 수 있고, 1이 나왔으면 위 칸만 건널 수 있다.
3. 플레이어는 이동할 칸을 선택한다.
  - U는 위 칸을 선택하는 것이고, D는 아래칸을 선택하는 것이다.
4. 이동한 칸을 출력한다.
5. 다리를 끝까지 건너면 게임이 종료된다.
  - 최종 게임 결과를 출력한다.
    - 이때까지 건넜던 다리를 모두 출력한다.
  - 게임 성공 여부를 출력한다.
    - 성공을 출력한다.
  - 총 시도한 횟수를 출력한다.
    - 총 시도한 횟수는 첫 시도를 포함해서 게임을 종료할 때까지 시도한 횟수를 출력한다.
6. 다리를 건너다가 실패하면 재시작하거나 종료할 수 있다.
  - 재시도 여부를 묻는다.
    - R은 재시도를, Q는 종료를 나타낸다.
  - 재시작을 하게 되면 처음에 만든 다리로 재사용한다. (다시 무작위로 건널 수 있는 칸을 선택하지 않는다)
  - 종료하게 되면 게임이 종료된다.
    - 최종 게임 결과를 출력한다.
      - 이때까지 건넜던 다리를 모두 출력한다.
    - 게임 성공 여부를 출력한다.
      - 실패를 출력한다.
    - 총 시도한 횟수를 출력한다.
      - 총 시도한 횟수는 첫 시도를 포함해서 게임을 종료할 때까지 시도한 횟수를 출력한다.

### 프로그래밍 요구 사항

- indent depth를 2까지 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수 또는 메서드는 한 가지 일만 한다.
- 함수 또는 메서드이 길이가 10이 넘지 하지 않는다.
- 테스트 코드를 구현한다.
- else를 쓰지 않는다.
- 도메인 로직에 단위 테스트를 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 제공해준 InputView 클래스에서만 `Console.readLine()`을 허용한다.
- BridgeGame 클래스에서 InputView, OutputView를 사용하지 않는다.

### 입력할 때 검증해야할 사항들

잘못된 값을 입력할 경우의 기본 전제

- 명확한 유형으로 처리한다. ex) `IllegalArgumentException`, `IllegalStateException`
- 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

다리의 길이를 숫자로 입력한다.

- 숫자만 입력 가능하다.
- 3이상이어야 한다.
- 20이하여야 한다.

플레이어는 이동할 칸을 선택한다.

- 영어 대문자여야 한다.
- 한 문자여야 한다.
- U 또는 D만 입력할 수 있다.

재시도 여부에 대해서 입력한다.

- 영어 대문자여야 한다.
- 한 문자여야 한다.
- R 또는 Q만 입력할 수 있다.

### 다리를 생성할 때 검증해야할 사항들

건널 수 있는 칸을 무작위로 정한다.

- 숫자여야 한다.
- 0과 1만 출력되어야 한다.

### 클래스

InputView

- [ ]  다리의 길이를 입력한다.
- [ ]  이동할 칸을 입력한다.
- [ ]  재시도 여부에 대해서 입력한다.

OutputView

- [ ]  게임을 시작하는 문구를 출력한다.
- [ ]  이때까지 건넜던 다리를 모두 출력한다.
  - 이동할 수 있는 칸을 선택한 경우 O 표시
  - 이동할 수 없는 칸을 선택한 경우 X 표시
  - 선택하지 않은 칸은 공백으로 표시
  - 다리의 시작은 [ , 다리의 끝은 ] 으로 표시
  - 다리 칸 구분은 | 문자열로 구분
- [ ]  최종 게임의 결과를 출력한다.
  - 게임 결과 문구를 출력한다.
  - 이때까지 건넜던 다리를 모두 출력한다.
- [ ]  게임 성공 여부를 출력한다.
  - 게임 성공 여부를 알려주는 문구를 출력한다.
  - 성공했다면 성공을, 실패했다면 실패를 출력한다.
- [ ]  총 시도한 횟수를 출력한다.
  - 총 시도한 횟수를 알려주는 문구를 출력한다.
  - 첫 시도를 포함해서 게임을 종료할 때까지의 시도한 횟수를 출력한다.

InputValidator

- [ ]  다리의 길이를 숫자로 입력한다.
  - 숫자만 입력 가능하다.
  - 3이상이어야 한다.
  - 20이하여야 한다.
- [ ]  플레이어는 이동할 칸을 선택한다.
  - 영어 대문자여야 한다.
  - 한 문자여야 한다.
  - U 또는 D만 입력할 수 있다.
- [ ]  재시도 여부에 대해서 입력한다.
  - 영어 대문자여야 한다.
  - 한 문자여야 한다.
  - R 또는 Q만 입력할 수 있다.

BridgeSizeDto
- [ ]  다리 길이를 담아서 컨트롤러로 보낸다.

BridgeSpaceDto
- [ ]  플레이어가 선택한 칸을 담아서 컨트롤러로 보낸다.

BridgeController
- [ ]  BridgeSizeDto를 받아서 서비스에 넘겨준다.
- [ ]  BridgeSpaceDto를 받아서 서비스에 넘겨준다.
- [ ]  게임을 재시작할지 확인한다.

BridgeMaker
- [ ]  매개변수로 들어온 다리의 길이만큼 다리를 생성

Success
- [ ]  사용자가 다리를 다 건넜는지 확인

Bridge
- [ ]  이미 건넌 다리인지 확인

Bridges
- [ ]  안 건넌 다리가 없는지 확인
- [ ]  다리를 생성