# 미션 - 다리 건너기 (김선호, 백엔드)
* * *

## 🕹️ 기능 구현
### 입력
* 다리의 길이
* 이동할 칸
* 게임 다시 시도

### 출력
* 게임 시작
* 다리의 길이
* 이동할 칸
* 다리 상황
* 게임 다시 시도
* 게임 성공 여부
* 시도 횟수

### 처리
* 다리 상황
* 시도 횟수
* 성공 여부
* 고정 문자열

* * *

## 🗄️ 클래스 분류

### 기본 제공
- Application
- BridgeGame: 다리 건너기 게임을 관리
- BridgeMaker: 다리를 사이즈에 맞게 생성
- BridgeRandomNumberGenerator: 랜덤 숫자 생성 (0, 1)


### 데이터
- BridgeData: 다리에 관한 고정된 값을 저장
- ExceptionData: 상황에 맞는 예외 출력문을 저장
- PrintData: 일반적인 출력상황에 필요한 정보를 저장

### 뷰
- InputView: 입력을 맡는 클래스
- OutputView: 출력을 맡는 클래스

### 매니저
- InputManager: InputView와 BridgeGame 사이에서 데이터를 가공
- OutputManager: OutputView와 BridgeGame 사이에서 데이터를 가공