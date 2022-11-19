import router from "@/router";

export function tokenValidres(res){
    if (res.code === 600){
        localStorage.removeItem('token')
        router.push("/login")
    }
}