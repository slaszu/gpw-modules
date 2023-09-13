package pl.slaszu.gpw.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) throws Exception {

        log.error("Request: " + req.getRequestURL() + " raised " + ex);


        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error_custom");
        return mav;
    }
}
