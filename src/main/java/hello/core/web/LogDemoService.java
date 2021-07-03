package hello.core.web;

import hello.core.common.MYLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MYLogger myLogger;
    //private final ObjectProvider<MYLogger> myLoggers;

    public void logic(String id) {
        //MYLogger myLogger = myLoggers.getObject();
        myLogger.log("service id = " + id);
    }
}
