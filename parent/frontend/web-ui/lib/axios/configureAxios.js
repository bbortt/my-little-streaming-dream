// @flow
import axios from 'axios'

export default () => {
  axios.defaults.maxRedirects = 0;
}
