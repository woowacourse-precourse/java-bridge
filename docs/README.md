

## 주어진 클래스 요구사항

|클래스이름|기능|
|---|---|
|InputView|사용자로부터 입력 및 유효성 검증|
|OutputView|사용자에게 게임진행 상황과 결과를 출력|
|BridgeGame|사용자의 의도대로 칸을 이동하거나, 게임을 다시 시작|
|BridgeMaker|다리의 길이를 입력받아서 다리를 생성해주는 역할|
|BridgeRandomNumberGenerator||




## 기능 요구사항
1. 맵 생성
	- 생성할 다리길이 유효성 검증 : 숫자여부
	- 이전 맵 State 저장
1. 게임 진행
	1. 초기화 및 게임시작 문구를 출력
	2. 이동할 칸을 선택
		- 이동할 칸 입력값 유효성 검증 : U/D여부
		- 이동할 칸 입력값이 유효하지 않은 값일 시 ERROR 메세지 발생
	3. 이동 칸이 성공헀는지 여부를 검사
		- 실패할시 재시작 여부 결정하는 상태 결정
		- 성공할시 다음 스텝으로 이동
	4. 최종 게임 종료 state인지 검사
		- 최종 게임 종료일시 최종 게임결과가 출력
		- 최종 게임 종료가 아닐씨 다시 이동할칸을 선택
	5. 최종 게임 결과 출력


## 주요 함수 기능

|함수이름|개요|
|---|---|
|InputView.readBridgeSize|다리의 길이를 입력받음|
|InputView.validateBridgeSize|다리의 길이를 검증|
|InputView.readMoving|사용자에게 이동할 칸을 입력받음|
|InputView.validateMoving|이동 값 입력값을 검증|
|InputView.readGameCommand|사용자가 게임을 다시 시도할지 종료할지 여부를 입력받|
|InputView.validateGameCommand|사용자가 게임을 다시 시도할지 종료할지 여부에 대한 검증|

|함수이름|개요|
|---|---|
|OutputView.printMap|현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력|
|OutputView.printResult|게임의 최종 결과를 형식에 맞춰 출력|

|함수이름|개요|
|---|---|
|BridgeGame.move| 사용자가 칸을 이동 |
|BridgeGame.retry| 사용자가 게임을 다시 시도 |
|BridgeGame.isFinished| 게임이 끝났는지 출력 |
|BrdigeGame.finish|게임의 최종결과를 축|

|상태 이름|개요|
|---|---|
|Application.State.INITIAL_STATE|게임시작 문구 출력|
|Application.State.SELECTION_STATE| 이동할 칸 입력 및 유효성 검증|
|Application.State.SUCCESS_TEST_STATE|이동할 칸의 성공/실패 결정|
|Application.State.FINISTH_TEST_STATE|이동할 칸이 종료지점에 다달았는지 검증|
|Application.State.END|게임종료문구 출력|


|트리거 이름|처음 상태|전이 상태 |
|:---|:---:|:---:|
|Application.Trigger.IS_VALID|SELECTION_STATE|SELECTION_STATE|
|Application.Trigger.IS_INVALID| 모든 State| 해당 STATE|
|Application.Trigger.SELECTION_FAILUE|SUCCESS_TEST_STATE|SELECTION_STATE|
|Application.Trigger.SELECTION_SUCCESS|SUCCESS_TEST_STATE|FINISTH_TEST_STATE|
|Application.Trigger.FINAL_SUCCESS|SUCCESS_TEST_STATE|FINISH_TEST_STATE|
|Application.Trigger.CONTINUE|FINISTH_TEST_STATE|SELECTION_STATE|
|Application.Trigger.FINISH|FINISTH_TEST_STATE|END|

|함수이름|개요|
|---|---|
|BridgeMaker.makeBridge|다리의 길이를 입력받아서 다리를 생성|
|BridgeMaker.map|현재 상태의 맵 상태저장 |
|BridgeMaker.initializeMap|맵 상태를 초기화|
|BridgeMaker.createStep|한스텝을 전진시킴|



