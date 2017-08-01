package com.sema4genomics.egc.note.aspect;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    private  final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    ObjectMapper mapper = new ObjectMapper();


    @Pointcut("execution(public * com.sema4genomics.egc.note.controller.NoteController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(){
        logger.info("log test 1");
    }


    @After("log()")
    public void doAfter(){

        logger.info("log test 2");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) throws JsonProcessingException {
        logger.info("response={}" , mapper.writeValueAsString(object) );

    }

}
