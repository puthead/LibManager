import request from './request'

export const dictList = () => {
  return request({
    url: '/base/dict'
  })
}
