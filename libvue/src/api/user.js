import request from './request'

export const userList = () => {
  return request({
    url: '/user/queryAll'
  })
}
export const userEdit = (data) => {
  return request({
    url: '/user/update',
    data
  })
}
export const userQuery = (uId) => {
  return request({
    url: '/user/queryObject'
  })
}
