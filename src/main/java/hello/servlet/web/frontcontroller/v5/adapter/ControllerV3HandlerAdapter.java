package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    } //이코드가 ControllerV3를 포함하고 있어? Yes or No 반환해


    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler){
        ControllerV3 controller = (ControllerV3) handler; // handler가  V3를 Casting 받아.
        Map<String, String> paramMap = createParamMap(request); //request에서 파라미터 정보를 받아서
        // paramMap으로 전달.
        ModelView mv = controller.process(paramMap); // /ModelView로 paramMap에 전달된 내용들을 반환시켜 보내.
        return mv;
    }

    //HttpServletRequest에서 파라미터 정보를 꺼내서 Map으로 변환한다.
    // 그리고 해당 Map( paramMap )을 컨트롤러에 전달하면서 호출한다.
    private Map<String, String> createParamMap(HttpServletRequest request){
        Map<String , String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;

    }
}
