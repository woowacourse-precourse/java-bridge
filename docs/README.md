# 기능 목록

## Application
- [X] 게임 플레이어 구동
## Bridge
- [X] 한 칸씩 요소 제공
  - [X] 제공 후 pivot 값 증가
- [X] 피봇값 0으로 초기화
## BridgeElement
- [X] 생성시 한 글자의 문자로 변환
- [X] 문자값 반환
## BridgeMaker
- [X] 주어진 크기 만큼 다리 제작
## GamePlayer
- [X] 게임 레코더 생성
- [X] 게임 종료시까지 게임 진행
  - [X] 사용자 이동할 때마다 BridgeMap 현황 출력
- [X] 게임 종료 후 결과 출력
## BridgeMap
- [X] 초기 세팅
- [X] 이동 성공시 표시
- [X] 이동 실패시 표시
- [X] 지도 출력
## BridgeMatcher
- [X] 다리와 움직임 요청 비교
- [X] 다리 이동 현황 초기화
## GameRecorder
- [X] 기록 시작
- [X] 게임 결과 반환
- [X] 이동동작 기록
  - [X] 기록시 pivot 증가
    - [X]pivot 증가시 횡단 완료여부 파악
## GameResult
- [X] 결과 기록을 위한 세팅
  - [X] 시행횟수 추가
  - [X] bridgeMap 초기화
- [X] 게임 완료 여부 반환
- [X] 게임 완료 여부 체크
- [X] bridgeMap에 성공적인 이동 추가
- [X] bridgeMap에 실패한 이동 추가
- [X] bridgeMap 반환
- [X] 시행 횟수 반환
## BridgeRandomNumberGenerator
- [X] 다리 요소 생성
## InputView
- [X] 다리 길이 입력
  - [X] 입력 요청 메시지 출력
  - [X] Console에서 입력 읽어오기
- [X] 플레이어가 이동할 다리 입력
  - [X] 입력 요청 메시지 출력
  - [X] Console에서 입력 읽어오기
- [X] 횡단 실패시 재시작 여부 입력
  - [X] 입력 요청 메시지 출력
  - [X] Console에서 입력 읽어오기
- [X] 검증 실패시 다시 받기 
## InputValidator
- [X] 다리 길이 입력에 대한 검증
  - [X] [예외] 입력값이 숫자인지 여부
- [X] 이동 요청에 대한 검증
  - [X] [예외] 한 자리의 문자인지
  - [x] [예외] 이동에 대한 명령인지
- [X] 재시작 요청에 대한 검증
  - [X] [예외] 한 자리의 문자인지
  - [X] [예외] 이동에 대한 명령인지
## OutputView
- [X] 다리 출력
- [X] 결과 출력

# 얼거형 목록
- [X] 다리 형태
- [X] 다리 위치
- [X] 사용자 입력 방식
- [X] 콘솔 메시지
- [X] 에러 메시지
- [X] 문자열 정규표현식
- [X] 게임 설정값

# 테스트 목록

## Bridge
- [X] bridge 생성 후에 next 실행시 요소가 제대로 반환되는가
- [X] 리셋 후에 요소 수 만큼 next 실행시 요소가 제대로 반환되는가

## BridgeElement
- [X] 다리요소 생성 및 반환

## BridgeMap
- [X] 초기 설정 후 String 변환값 비교
- [X] 위 아래로 번갈아가며 3번 씩 이동 성공시
- [X] 위 아래로 번갈아가며 2번 씩 이동 후 마지막 위로 이동 실패시
- [X] 위 아래로 번갈아가며 2번 씩 이동 후 마지막 아래로 이동 실패시

## GameResult
- [X] gameClear 호출 전 isGameClear 값이 false인지 확인
- [X] gameClear 호출 후 isGameClear 값이 true로 변경되는지 확인
- [X] attempt() 여러번 호출 후 tryCount 값 확인

## InputValidator
- [X] 다리 개수 입력시 숫자가 아닐 때 예외처리
- [X] 다리 개수 입력시 범위 초과시 예외처리
- [X] 이동 명령 입력시 1글자가 아닐 때 예외처리
- [X] 이동 명령 입력시 요청 문자와 다를 때 예외처리
- [X] 재시도 명령 입력시 1글자가 아닐 때 예외처리
- [X] 재시도 명령 입력시 요청 문자와 다를 때 예외처리

# 리펙터링 목록
 
- [X] 다리 리스트(List<String>) 일급 컬렉션으로 제작
- [X] 다리 요소(String) 래핑
- [X] Application에서 불필요한 예외 검증 제거
- [X] InputType -> Command로 이름 변경
- [X] GamePlayer.play() 메서드 추출
- [X] gamePlayer에서 bridgeMap new 연산자 사용하는 대신 리셋 기능 구현
- [X] GamePlayer 필드들 클래스로 빼기
- [X] GameResult 메서드명 변경
- [X] GameRecorder 메서드명 변경
- [X] BridgeGame -> BridgeMatcher로 변경