## 구현할 기능 목록

### 절차별 목록
- 게임 시작 문구 출력 `OutputView`
- 다리 길이 입력 `InputView`
- 다리 만들기 `BridgeMaker`의 `makeBridge()` 메서드
- while문 (isKeepGaming)
  - 시도 횟수 +1
  - for 문 (다리 리스트)
    - 이동할 칸 입력 `InputView`
    - 입력한 칸 숫자로 변환 `Sqaure` Enum
    - `BridgeGame`의 `move()` 메서드
      - 변환된 값과 리스트의 n번째 값과 비교
      - 일치할 시, 해당 칸에 `O` / 해당되지 않는 칸에 빈칸 표시
      - 일치하지 않을 시, `X` 표시 
    - 다리 건너기 결과 표시 `OutputView`
    - `X` 표시가 있을 시 `break`
  - 실패로 끝난 경우
    - 게임 재시작/종료 여부를 입력 `InputView`
    - 재시도 시 같은 사다리로 게임 재시작 `BridgeGame`의 `retry()`
    - 종료 시 isKeepGaming = false, 다리 건너기 최종 결과 표시 `OutputView`
  - 성공으로 끝난 경우
    - isKeepGaming = false
    - 다리 건너기 최종 결과 표시 `OutputView`
- 게임 종료시
  - 게임 성공여부 출력 `OutputView`
  - 총 시도 횟수 출력 `OutputView`

### [BridgeGame]
- [ ] `BridgeGame`의 메서드 이름은 변경할 수 없다.
- [ ] `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- [ ] 클래스 내에서 `InputView`와 `OutputView`를 사용하지 않는다.
- [ ] `move` 메서드
- [ ] `retry` 메서드

### [BridgeMaker]
- [ ] `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- [ ] `makeBridge` 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

### [BridgeRandomNumberGenerator] & [BridgeNumberGenerator]
- [ ] 클래스의 코드는 변경할 수 없다.
- [ ] Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.

### view / [InputView]
- [ ] 자동으로 생성할 다리 길이를 입력 받는다.
  - [ ] `다리의 길이를 입력해주세요.` 문구 출력
  - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 이용해 입력
    - [ ] 3 이상 20 이하의 숫자만 입력
    - [ ] 올바른 값이 아니면 예외 처리
- [ ] 라운드마다 플레이어가 이동할 칸을 입력 받는다.
  - [ ] `이동할 칸을 선택해주세요. (위: U, 아래: D)` 문구 출력
  - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 이용해 입력
    - [ ] U와 D 중 하나의 문자만 입력
    - [ ] 올바른 값이 아니면 예외 처리
- [ ] 게임 재시작/종료 여부를 입력 받는다.
  - [ ] `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)` 문구 출력
  - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 이용해 입력
    - [ ] R과 Q 중 하나의 문자만 입력
    - [ ] 올바른 값이 아니면 예외 처리
    
### view / [OutputView]
- [ ] `OutputView`의 메서드는 이름을 변경할 수 없다.
- [ ] 게임 시작 문구 출력
  - [ ] `다리 건너기 게임을 시작합니다.` 문구 출력
- [ ] 사용자가 이동할 때마다 다리 건너기 결과 출력
  - [ ] 현재까지 건넌 다리를 모두 출력
  - [ ] 이동할 수 있는 칸을 선택한 경우 `O` 표시
  - [ ] 이동할 수 없는 칸을 선택한 경우 `X` 표시
  - [ ] 선택하지 않은 칸은 공백 한 칸 ` ` 표시
  - [ ] 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
- [ ] 성공 혹은 `Q` 선택한 경우, 게임 종료 문구 출력
  - [ ] `최종 게임 결과` 문구 출력
  - [ ] 현재까지 건넌 다리를 모두 출력
  - [ ] 게임 성공 여부 출력
    - [ ] 성공 시, `게임 성공 여부: 성공` 문구 출력
    - [ ] 실패 시, `게임 성공 여부: 실패` 문구 출력
  - [ ] 시도 횟수 출력
    - [ ] `총 시도한 횟수: 2` 문구 출력
    - [ ] 현재까지 시도한 횟수 출력
- [ ] 예외 상황 시 에러 문구를 출력
  - [ ] 에러 문구는 `[ERROR]`로 시작
