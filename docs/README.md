# 기능 목록

---

## domain

### Bridge
- [X] 결과 bridge 저장
- [X] `isEquals()`: Position과 bridge의 index value가 일치하는지 검증

### BridgeIndex
- [X] bridge index 저장
- [X] `increment()`: bridge index 증가

### BridgeGame
- [X] `move()`: 사용자가 칸을 이동
- [X] `retry()`: 사용자가 게임을 다시 시도

### BridgeMaker
- [x] `makeBridge()`: 1은 U, 0은 D로 변경하여 반환

### BridgeSize
- [x] 다리의 길이 저장
- [x] 예외 처리
  - [x] 숫자가 아닐 경우
  - [x] 3 ~ 20 사이의 숫자가 아닐 경우

### Position
- [x] command와 value를 가지고 있음
  - [x] U = 1, D = 0
- [x] `getPositionByCommand()`: Command로 BridgePosition을 반환
- [x] `getCommandByValue()`: value로 command를 반환
- [x] 예외처리
  - [x] U와 D가 아닌 값은 생성할 수 없음

### GameStatus
- [X] 게임 성공, 실패, 진행 중 등 상태 표시
- [X] 게임 결과 출력
  - [X] `게임 성공 여부: + status` 

### MapPrinter
- [X] 게임 진행 과정 및 결과 출력

### RepeatCount
- [X] 재시도 횟수 저장
- [X] 재시도 횟수 증가
- [X] 재시도 횟수 출력
  - [X] `총 시도한 횟수: n`

### RetryCommand
- [X] 재시도 커멘드 입력
- [X] R 또한 Q가 아닐 시 예외처리
<br>
---
## view
### InputView
- [x] 다리 길이 입력
  - [x] `다리의 길이를 입력해주세요.` 문구 출력
- [x] 이동할 칸 입력
  - [x] `이동할 칸을 선택해주세요. (위: U, 아래: D)` 문구 출력
  - [x] 소문자를 입력 받으면 대문자로 변환
  - [x] U(위), D(아래)가 아닐 경우 예외 처리
- [x] 게임 재시작/종료 여부 입력
  - [x] `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)` 문구 출력
  - [x] R(재시작), Q(종료) 중 하나만 입력
  
### OutputView
- [X] `다리 건너기 게임을 시작합니다.` 문구 출력
- [X] 다리를 건널 때마다 다리 건너기 결과 출력
  - [X] 현재까지 건넌 다리의 결과 출력
  - [X] 이동할 수 없는 칸을 선택 -> `X` 표시
  - [X] 이동할 수 있는 칸을 선택 -> `O` 표시
  - [X] 선택하지 않은 칸 -> ` `(공백 한 칸) 표시
  - [X] 다리의 시작 -> `[` 표시
  - [X] 다리의 끝 -> `]` 표시
  - [X] 다리 칸의 구분 -> `|` 표시
- [X] `Q`를 선택 & 성공
  - [X] `최종 게임 결과`