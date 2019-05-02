// @flow
import Router from 'next/router';

import type {NextContext} from '../axios/NextContext';

export default (url: string, nextContext: NextContext) => {
  if (nextContext.res) {
    nextContext.res.redirect(url)
  } else {
    Router.push(url)
  }
}