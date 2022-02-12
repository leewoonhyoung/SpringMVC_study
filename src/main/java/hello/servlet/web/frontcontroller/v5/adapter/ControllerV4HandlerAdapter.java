package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler; // handler가  V4를 Casting 받아.

        Map<String , String> paramMap = createParamMap(request);//request에서 파라미터 정보를 받아서
        // paramMap으로 전달.

        HashMap<String, Object> model = new HashMap<>(); //Model 정보를 받을 HashMap생성

        String viewName = controller.process(paramMap, model);// viewName을 paramMap과 model을 통해서 값을 받음 // 여기서 model은 빈 값
        ModelView mv = new ModelView(viewName); // viewName을 가지고 ModelView로 변환.
        mv.setModel(model); //modelView에 model값을 넣는다.

        return mv;


    }

    private Map<String, String> createParamMap(HttpServletRequest request){

        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;

    }
}
