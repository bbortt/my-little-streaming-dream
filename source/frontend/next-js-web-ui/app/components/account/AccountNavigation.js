// @flow
import React from 'react'

import ActiveMenuItem from '../layout/header/ActiveMenuItem'

const AccountNavigationClass = () => (
  <ul id="account-navigation" className="vertical menu">
    <li>
      <ActiveMenuItem href="profile">
        <a>Profile</a>
      </ActiveMenuItem>
    </li>
    <li>
      <ActiveMenuItem href="reset-password">
        <a>Reset Password</a>
      </ActiveMenuItem>
    </li>
  </ul>
)

export default AccountNavigationClass
