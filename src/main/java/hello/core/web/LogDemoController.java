package hello.core.web;

import hello.core.common.MYLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MYLogger myLogger;
    //private final ObjectProvider<MYLogger> myLoggers;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        //MYLogger myLogger = myLoggers.getObject();
        String requestURL = request.getRequestURI().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("Controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
