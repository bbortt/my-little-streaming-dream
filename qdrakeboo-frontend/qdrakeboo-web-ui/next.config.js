const withSass = require('@zeit/next-sass')

module.exports = {
  serverRuntimeConfig: {
    cookieSecret: 'this-is-a-secret-string',
    sessionSecret: 'another-secret-string',
    clientId: 'cea19e6f-fa31-407f-a05a-a20d28c4c74d',
    clientSecret: '8779af4a-d120-4bea-9993-dea2fbc4b571',
    accessTokenUri: 'http://localhost:8088/auth/oauth/token',
    authorizationUri: 'http://localhost:8088/auth/oauth/authorize',
    logoutUri: 'http://localhost:8088/auth/logout',
    redirectUri: 'http://localhost:3000/session',
    scopes: ['read'],
    apiUrl: 'http://localhost:8080'
  },
  publicRuntimeConfig: {
    publicUrl: 'http://localhost:3000'
  },
  ...withSass()
}