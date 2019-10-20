// @flow
import { applyMiddleware, createStore, Store } from 'redux'
import createSagaMiddleware, { Task } from 'redux-saga'

import { crashReportingMiddleware, loggingMiddleware } from './state/middleware'

import type { ReduxState } from './state/reducer'
import rootReducer, { reduxState } from './state/reducer'

import rootSaga from './state/saga'
import { sagaStarted } from './state/action'

export type StoreWithSaga = Store<ReduxState> & {
  sagaTask: Task,
}

const bindMiddleware = middleware => {
  if (process.env.NODE_ENV !== 'production') {
    const { composeWithDevTools } = require('redux-devtools-extension')
    return composeWithDevTools(
      applyMiddleware(
        crashReportingMiddleware,
        loggingMiddleware,
        ...middleware
      )
    )
  }

  return applyMiddleware(...middleware)
}

export default (initialState: ReduxState = reduxState): StoreWithSaga => {
  const sagaMiddleware = createSagaMiddleware()

  const store = createStore(
    rootReducer,
    initialState,
    bindMiddleware([sagaMiddleware])
  )

  if (!(store.getState(): ReduxState).saga.ran) {
    store.dispatch(sagaStarted())
    store.sagaTask = sagaMiddleware.run(rootSaga)
  }

  return store
}
