import React from 'react';

import App from 'next/app';
import Router from 'next/router';

import axios from 'axios'

import {Auth0Provider} from 'use-auth0-hooks';

const onRedirectCallback = appState => {
  if (appState && appState.returnTo) {
    Router.push({
      pathname: appState.returnTo.pathname,
      query: appState.returnTo.query
    })
  }
};

const onAccessTokenError = (err, options) => {
  console.error('Failed to retrieve access token: ', err);
};

const onLoginError = (err) => {
  Router.push({
    pathname: '/oops.html',
    query: {
      message: err.error_description || err.message
    }
  })
};

const onRedirecting = () => {
  return (
      <div>
        <h1>Signing you in</h1>
        <p>
          In order to access this page you will need to sign in.
          Please wait while we redirect you to the login page...
        </p>
      </div>
  );
};

export class RootClass extends App {
  static async getInitialProps({ctx}) {
    if (ctx.req) {
      return {wellKnown: require('../public/.well-known.json')}
    }

    const res = await axios.get('/.well-known-json');
    console.log('fetch: ', res);
    return {wellKnown: res}
  }

  render() {
    const {Component, pageProps, wellKnown} = this.props;

    console.log('wellKnown: ', wellKnown);

    return (
        <Auth0Provider
            domain={wellKnown.auth0.domain}
            clientId={wellKnown.auth0.clientId}
            redirectUri={wellKnown.auth0.callbackUrl}
            onLoginError={onLoginError}
            onAccessTokenError={onAccessTokenError}
            onRedirecting={onRedirecting}
            onRedirectCallback={onRedirectCallback}>
          <Component {...pageProps} />
        </Auth0Provider>
    );
  }
}

export default RootClass
