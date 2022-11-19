import request from "../util/request.js";
export function getData(){
    return request({
        //请求地址..
        url:'user/queryAll',
        //请求方式..
        method:"get",
        // //post请求时使用..
        // data:{
        //     name:'lisi'
        // },
        // //get请求时使用..
        // params:{
        //     id:'hahahhaahah'
        // }
    })
}
export function login(uName,uPassword) {
    return request({
        url:'user/login',
        method:'post',
        params:{
            uname:uName,
            upassword:uPassword
        }
    })
}