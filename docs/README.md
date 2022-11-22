# 권찬영(fnzl54)
___
## java-bridge 기능 목록
___

### 🖥️ UI Part
- InputView 클래스
    1. 다리의 길이를 입력
        - 숫자만 입력 가능
        - 3~20 사이의 숫자만 가능
    2. 이동할 칸을 선택을 입력
        - U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력 가능
    3. 게임 재시작/종류 여부
        - R(재시작)과 Q(종료) 중 하나의 문자를 입력 가능
___
- OutputView 클래스
    1. 게임 진행을 위한 출력
    2. 진행중인 bridge 출력
    3. 게임의 최종 결과를 출력
        - 입력으로 R(재시작)이 들어왔을 때 작동
    4. 오류 입력 발생 시 출력
        - 에러 문구는 "[ERROR]" 로 시작
___

### ⚙️ Logic Part
- BridgeGame 클래스
    1. input를 통한 게임 실행
    2. R(재시작) 입력시 다시 게임 실행
    3. Q(종료) 입력시 게임 종료
___
- BridgeMaker 클래스
    1. 사용자 입력 크기의 Bridge 생성
___
- BridgeRandomNumberGenerator 클래스
    1. Bridge 생성에 필요한
___
- Run 클래스
    1. 게임 실행과 관련한 명령 실행
___
- ExceptionCase 클래스
    1. 숫자, 문자 판독
    2. 범위 판독

