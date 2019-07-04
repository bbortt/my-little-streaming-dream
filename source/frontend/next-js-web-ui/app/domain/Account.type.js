// @flow
export type Account = {
  displayName: String,
  id: String,
  userId: String,
  name: {
    familyName: String,
    givenName: String
  },
  picture: String,
  nickname: String
}
