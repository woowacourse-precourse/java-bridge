# 다리 건너기 기능 목록

## Controller

    - 다리 건너기 게임 셋업
    - 다리 건너기 게임 분기까지 반복 진행
    - 다리 건너기 게임 결과 출력

## Domain

    - BridgeGame
        - bridge 정보 보관
        - user 정보 보관
        - 재시도 횟수 보관
        - 게임 종료 상태 보관

## Service

    - BridgeService
        - Bridge 자동 생성
        - Bridge User 비교 결과 생성

## Exception

    - BridgeSizeException
        - 숫자로만 구성
        - 3부터 20까지의 수만 허락
    - MoveInputException
        - U, D만 가능
    - GameRestartInputException
        - R, Q만 가능

## Util

    - BridgeNumberGenerator
        - Bridge 정답 랜덤 생성

## View

    - 사용자 Input
        - 다리 길이 입력
        - 사용자 이동 입력
        - 게임 재시도 입력
    - 사용자 Output
        - 다리 이동 시각화
        - 게임 결과 시각화