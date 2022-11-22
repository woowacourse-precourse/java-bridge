#시나리오에 따른 기능 목록 정리

### OutputView에서 게임 시작 문구 출력

### OutputView에서 이동할 칸 선택 문구 출력

### InputView에서 readBridgeSize 실행 및 유효한 입력인지 검증
 - 3 이상 20 이하의 숫자를 입력할 수 있으며 이를 제외한 경우 예외처리
 - [예외발생 시]
 - IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.
### BridgeMaker에서 입력 받은 size만큼 다리 생성
- size만큼 bridgeNumberGenerator를 실행하여 0 또는 1 값을 생성한다.
- 이에 해당하는 다리 모양을 List<String>으로 저장하여 리턴
- 생성된 다리 모양을 BridgeGame의 생성자에 인자로 넣는다.
- BridgeGame에 다리 모양을 저장하는 필드를 가진다.

### 게임 상황에 따라 진행할지 종료할지 판단
- 만약 유저 input이 없다면 게임 진행으로 판단
- 만약 유저 input이 정답과 크기가 같다면 정답을 맞췄다고 판단
- 만약 유저 input에 Q가 존재할 경우 게임을 종료한다고 판단

### InputView에서 readMoving 실행 및 유효한 입력인지 검증
- U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외처리
- [예외 발생 시]
- IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.
### OutputView에서 printMap 실행
- 입력 받은 문자에 해당하는 현재 map을 출력한다.
### BridgeGame에서 moving을 입력 받은 후 이동
- 입력 받은 문자를 user input에 추가한다.
- 만약 해당 input이 정답과 같다면 계속 진행
- 만약 해당 input이 정답과 다르다면 retry로 넘어간다.

### retry 실행 시 OutputView에서 retry 여부 문구 출력

### InputView에서 retry 여부 입력 받은 후 검증
- R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외처리
- R일 경우 user input을 초기화하고 retryCount을 1 증가한다
- Q일 경우 user input에 Q를 추가한다.
- 이후 다시 게임 상황 판단 단계로 진입
- [예외 발생 시]
- IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.

### 게임이 성공적으로 종료되었다면 OutputView에서 printResult 실행
- 최종 게임 결과와 최종 Map 상태를 출력한다.
- BridgeGame에서 게임 결과(성공 실패 여부와 retryCount)를 가져와 출력한다. 