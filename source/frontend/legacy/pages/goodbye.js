// @flow
import React from 'react'

import Head from 'next/head'
import Router from 'next/router'

type GoodByeProps = {}

require('./goodbye.scss')

export class GoodbyeClass extends React.Component<GoodByeProps> {
  backToHome() {
    Router.push('/')
  }

  render() {
    return (
      <div className="goodbye">
        <Head>
          <title>Qdrakeboo | Good Bye</title>
          <meta
            name="viewport"
            content="initial-scale=1.0, width=device-width"
          />
        </Head>

        <div className="container">
          <h1>We hope to see you again soon..</h1>
          <br />
          <button
            type="button"
            className="button"
            aria-label="Back to Qdrakeboo"
            onClick={this.backToHome}
          >
            Back to Qdrakeboo
          </button>
        </div>
      </div>
    )
  }
}

export default GoodbyeClass