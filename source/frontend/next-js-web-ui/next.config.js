const withSass = require('@zeit/next-sass')

module.exports = {
  serverRuntimeConfig: {},
  publicRuntimeConfig: {},
  ...withSass()
}