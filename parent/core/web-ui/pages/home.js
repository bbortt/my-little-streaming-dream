// @flow
import React from 'react'

import {connect} from 'react-redux'

import axios from 'axios'

import withAuthenticationOnly from '../lib/security/with-authentication-only';

class Home extends React.Component<Home.propTypes> {

  componentWillMount(): void {
    console.log('axios config: ', axios.defaults.headers.common)
  }

  render() {
    return (
        <div className='Home'>
          <h1>Hi there</h1>

          <p>Your current auth looks like the following:
          </p>

          <a href='logout'>
            <button>Logout</button>
          </a>
        </div>
    )
  }
}

export default connect()(withAuthenticationOnly(Home))
