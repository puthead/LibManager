import request from './request'

export const userList = () => {
  return request({
    url: '/user/queryAll'
  })
}
export const userEdit = () => {
  return request({
    url: '/user/update'
  })
}
