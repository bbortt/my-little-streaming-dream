// @flow
import Token from '../../domain/session/Token';
import UserInfo from '../../domain/session/UserInfo';

export const SET_TOKEN: string = 'Session: Set Token'
export const REQUEST_USER_INFO: string = 'Session: Request User-Info'
export const SET_USER_INFO: string = 'Session: Set User-Info'

export type SetTokenAction = { type: string, token: Token }
export type RequestUserInfoAction = { type: string }
export type SetUserInfoAction = { type: string, userInfo: UserInfo }

export type SessionAction =
    SetTokenAction |
    RequestUserInfoAction |
    SetUserInfoAction

export function setToken(token: Token): SetTokenAction {
  return {type: SET_TOKEN, token: token}
}

export function requestUserInfo(): RequestUserInfoAction {
  return {type: REQUEST_USER_INFO}
}

export function setUserInfo(userInfo: UserInfo): SetUserInfoAction {
  return {type: SET_USER_INFO, userInfo: userInfo}
}
