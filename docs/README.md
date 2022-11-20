# 로또 미션 구현 목록

## ● 주요 구현 기능
- 입력 메시지 출력하는 기능
- 입력값 받는 기능
- 출력 메시지 출력하는 기능
- 결과값 출력하는 기능
- 에러 메시지 출력하는 기능


- 다리 랜덤으로 생성하는 기능
- 사용자 이동시키는 기능
- 사용자 이동 기록하는 기능
- 재시작하는 기능


## ● 구현할 구조

### controller
- BridgeController
- [x] 다리 길이 입력 받기
- [x] 다리 생성하기
- [x] 이동할 칸 입력 받기
- [x] 재시작 여부 입력 받기
- [x] 사용자 이동시키기
- [x] 다리 출력하기
- [x] 재시작 여부에 맞는 분기 설정
- [x] 재시작 여부에 맞는 재귀 호출하기

### view
- InputView
- [x] 다리 길이 입력 받기
- [x] 이동할 칸 입력 받기
- [x] 게임 재시작 여부 입력 받기
- [x] 예외 발생 시 재입력 받기
- [x] 입력받은 다리 길이 예외 처리하기
- [x] 입력받은 문자 예외 처리하기
- OutputMessage __(enum)__
- [x] 에러 메시지 정리
- [x] 입력 안내 메시지 정리
- [x] 출력 멘트 메시지 정리
- OutputView
- [x] 입력 안내 메시지 출력하기
- [x] 결과값 출력하기
- [x] 성공 여부 출력하기
- [x] 시도 횟수 출력하기

### domain
- BridgeNumberGenerator __(interface)__
- [x] 숫자 생성하기
- BridgeRandomNumberGenerator
- [x] 랜덤 숫자 생성하기
- BridgeMaker
- [x] 다리 길이에 맞는 정수값 다리 생성하기
- [x] 정수값 다리를 문자열로 변환하기
- [x] 문자열 다리 반환하기
- Bridge
- [x] 문자열 다리 생성하기
- [x] 입력값에 맞는 횡단여부 반환하기
- BridgeGame
- [x] 게임 시도 횟수 늘리기
- [x] 게임 성공 여부 체크하기
- [x] 이동한 칸과 위치 저장하기
- [x] FootPrint 초기화하기
- [x] BridgeCrossingDTO 반환하기
- BridgeCrossingStatus
- [x] 횡단 상태 메시지 정리 

### service
- BridgeService
- [x] BridgeMaker에서 만든 다리 Bridge에 저장
- [x] 이동할 칸에 맞는 BridgeCrossingDTO 반환
- [x] FootPrint 초기화

### dto
- BridgeCrossingDTO
- [x] 이동한 칸 저장하기
- [x] 게임 성공 여부 저장하기
- [x] 총 시도한 횟수 저장하기

## ● 예외 상황
- 다리 길이가 정수가 아닐 때
- 다리 길이가 올바른 범위가 아닐 때
- 이동할 칸 문자가 올바른 값이 아닐 때
- 재시작 여부가 올바른 값이 아닐 때


## ● 테스트 코드
### application
- [x] 이동할 칸 예외 검출 후 게임 결과 검증
- [x] 재시작 여부 예외 검출 후 게임 결과 검증
- [x] 종료 예외 검출 후 게임 결과 검증

### domain
- BridgeMaker
- [x] 문자열 다리 검증
- Bridge
- [x] 입력값에 맞는 횡단여부 검증
- BridgeGame
- [x] 이동한 상태 검증
- [x] 이동한 위치 검증
- [x] 재시작 후 게임 위치 검증
- [x] 게임 시도 횟수, 성공 여부 검증