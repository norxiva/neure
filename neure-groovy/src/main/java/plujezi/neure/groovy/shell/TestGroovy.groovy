package plujezi.neure.groovy.shell

import plujezi.neure.groovy.bean.Request
import plujezi.neure.groovy.bean.Response

class TestGroovy {

    def static test(){
        println("test222")
    }

    static RespBean test2(Bean bean){
        println(bean)
        RespBean respBean = new RespBean()
        respBean.success = bean.name + bean.password
        return respBean
    }

    static Response test3(Request request){
        println(request.toString())
        Response response = new Response()
        response.setCode("0000")
        return response
    }

    static Map test4(Map<String, Object> request){
        println(request)
        Map<String, Object> resp = new HashMap()
        resp.put("code", "0000")
        return resp
    }
}
