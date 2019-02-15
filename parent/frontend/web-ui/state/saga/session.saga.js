// @flow
import Router from 'next/router';

import {call, select, takeLatest} from 'redux-saga/effects'

import axios from 'axios'

import type {RequestSessionAction, RequestUserInfoAction} from '../actions'
import {REQUEST_SESSION, REQUEST_USER_INFO} from '../actions'

import {getToken} from '../facade/session.facade'

const sessionEndpoint = '/session'

function* requestSession(action: RequestSessionAction) {
  yield  redirect(sessionEndpoint, action.response)
}

export function* requestSessionSaga() {
  yield takeLatest(REQUEST_SESSION, requestSession)
}

function* redirect(url: string, response: any | null) {
  if (response) {
    response.redirect(url)
  } else {
    Router.push(url)
  }
}

function* requestUserInfo(action: RequestUserInfoAction) {
  const token = yield select(getToken)

  const response = yield call(axios.get, 'http://localhost:8080/user', {
    headers: {
      'Authorization': `${token.token_type} ${token.access_token}`
    }
  })
}

export function* requestUserInfoSaga(): Iterable<any> {
  yield takeLatest(REQUEST_USER_INFO, requestUserInfo)
}
