# 기능 요구 사항
- [x] Application : main loop, UI와 로직을 통합
    - [x] 게임 진행
    - [x] 에러 처리

- [x] BridgeGame : 다리 건너기 게임을 관리하는 클래스
    - [x] 생성자 추가
        - 다리 생성
        - 현재 칸수 0으로 설정
        - 게임 상태를 진행중으로 설정
        - 시도 횟수 1로 설정
    - [x] 이동
        - 위아래 칸을 받아 이동
        - 해당 칸으로 이동 가능한지 검사
    - [x] 게임 정보 반환
        - [x] 다리 반환
        - [x] 현재 칸수 반환
        - [x] 게임 상태(BrideGameStatus) 반환
    - [x] 재시작
        - 현재 칸수 0으로 설정
        - 게임 상태 진행중으로 설정
        - 시도 횟수 +1

- [x] BridgeGameStatus : 게임 상태 정보 Enum
    - [x] 게임 상태 정의(진행중,성공,실패)

- [x] BridgeMoveCommand : 게임 이동 명령 정보 Enum
    - [x] 이동 명령 정의(위=U,아래=D)
    - [x] 명령어로 탐색
    - [x] 순서로 탐색

- [x] BridgeRetryCommand : 재시도 명령 정보 Enum
    - [x] 명령 정의(재시도=R,나가기=Q)
    - [x] 명령어로 탐색

- [x] BridgeMaker : 다리 정보를 만드는 클래스
    - [x] 다리 생성 후 반환

- [x] InputView : 사용자로부터 입력을 받는 클래스
    - [x] 생성자 추가
        - InputValidator 설정
    - [x] 다리 길이 입력, 검증
        - 검증 실패 시 IllegalArgumentException
    - [x] 이동할 칸 입력, 검증
        - 검증 실패 시 IllegalArgumentException
    - [x] 게임 재시도 여부 입력, 검증
        - 검증 실패 시 IllegalArgumentException

- [x] InputValidator : 사용자 입력을 검증하는 클래스
    - [x] 생성자 추가
    - [x] 다리 길이 검증
        - 검증 실패 시 IllegalArgumentException
    - [x] 다리 길이 문자열 정수로 변환 검증
        - 검증 실패 시 IllegalArgumentException
    - [x] 이동할 칸 검증
        - 검증 실패 시 IllegalArgumentException
    - [x] 게임 재시도 여부 검증
        - 검증 실패 시 IllegalArgumentException

- [x] InputValidationError : Input 검증 에러를 정의한 Enum
    - [x] 오류 정의
        - ERROR_BRIDGE_SIZE 다리 길이 에러
        - ERROR_COMMAND_MOVE 잘못된 움직임 입력
        - ERROR_COMMAND_RETRY 잘못된 진행 명령 입력

- [x] OutputView : 사용자에게 게임 진행 상황과 결과를 출력하는 클래스
    - [x] 생성자 추가
    - [x] 시작 문구 출력
    - [x] 현재까지 이동한 다리 출력
    - [x] 게임의 최종 결과 출력


# 테스트
- [x] BridgeGame 테스트
    - [x] move 테스트
        - 성공,실패,진행중에 대한 테스트
    - [x] 시도 횟수에 대한 테스트

- [x] BridgeMaker 테스트
    - [x] makeBridge
        - 크기가 맞는지
        - 모든 원소가 "U"나 "D"인지

- [x] InputValidator 테스트
    - [x] 다리 길이 검증 테스트
        - 다리길이가 3~20을 벗어나면 IllegalArgumentException
        - 그 외에는 pass
    - [x] 다리 길이 문자열 정수로 변환 검증 테스트
        - 다리 길이 문자열이 정수로 변환 가능하지 않다면 IllegalArgumentException
    - [x] 이동할 칸 검증 테스트
        - 이동할 칸이 U나 D가 아니라면 IllegalArgumentException
        - 그 외에는 pass
    - [x] 게임 재시도 여부 검증 테스트
        - 재시도 명령이 R이나 Q가 아니라면 IllegalArgumentException
        - 그 외에는 pass

- [x] BridgeMoveCommand 테스트
    - [x] getByOrder 테스트
    - [x] getByCommand 테스트

