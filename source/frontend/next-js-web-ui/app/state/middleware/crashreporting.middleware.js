// @flow
export const crashReportingMiddleware = (store) => (next) => (action) => {
  try {
    return next(action)
  } catch (error) {
    console.error('Exception caught: ', error);
    throw error
  }
};
