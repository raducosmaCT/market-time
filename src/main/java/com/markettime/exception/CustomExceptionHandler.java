package com.markettime.exception;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.markettime.context.RequestContext;
import com.markettime.context.UserContext;
import com.markettime.service.UserContextService;
import com.markettime.util.ValidationUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Autowired
    private UserContext userContext;

    @Autowired
    private RequestContext requestContext;

    @Autowired
    private UserContextService userContextService;

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ValidationErrorsException.class)
    public ModelAndView handleValidationErrorsException(HttpServletRequest request, ValidationErrorsException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userContext", userContext);
        modelAndView.addObject("validationErrors", ValidationUtil.extractValidationErrors(e.getErrors()));
        modelAndView.addObject(requestContext.getModelObjectName(), requestContext.getModelObject());
        modelAndView.setViewName(
                requestContext.getReturnToViewName() != null ? requestContext.getReturnToViewName() : "error500");
        return modelAndView;
    }

    /**
     * For all requests that require the user to be logged in, but this condition is not satisfied, this method sends a
     * redirect to the absolute path {@code /market-time/login}. If a referrer is available, it is passed on as a query
     * parameter.
     *
     * @param request
     * @param response
     * @param e
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    @ExceptionHandler(NotLoggedInException.class)
    public String handleAuthenticationException(HttpServletRequest request, HttpServletResponse response,
            NotLoggedInException e) throws UnsupportedEncodingException, IOException {
        String baseRedirect = "redirect:/login";
        String requestUrl = request.getRequestURL().toString();
        return String.format("%s?return=%s", baseRedirect, URLEncoder.encode(requestUrl, "UTF-8"));
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest request, ApplicationException e) {
        LOGGER.error("An exception occured!", e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userContext", userContext);
        modelAndView.addObject("generalErrorMessage", e.getMessage());
        modelAndView.setViewName(
                requestContext.getReturnToViewName() != null ? requestContext.getReturnToViewName() : "error500");
        return modelAndView;
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException(HttpServletRequest request, NoHandlerFoundException e) {
        LOGGER.warn(e.getMessage());
        userContextService.initializeUserContext(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userContext", userContext);
        modelAndView.setViewName("error404");
        return modelAndView;
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception e) {
        LOGGER.error("An exception occured!", e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userContext", userContext);
        modelAndView.addObject("generalErrorMessage", "Oops! It seems we're having some issues... Please try again.");
        modelAndView.setViewName(
                requestContext.getReturnToViewName() != null ? requestContext.getReturnToViewName() : "error500");
        return modelAndView;
    }

}
