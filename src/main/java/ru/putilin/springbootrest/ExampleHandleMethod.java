package ru.putilin.springbootrest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.server.ResponseStatusException;
import ru.putilin.springbootrest.advice.InvalidCredentials;
import ru.putilin.springbootrest.model.MyNewUser;
import ru.putilin.springbootrest.model.User;

public class ExampleHandleMethod implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(MyNewUser.class) && parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String user = webRequest.getParameter("user");

        if (isEmpty(user))
            throw new InvalidCredentials("User name or password is empty");

        if (chekMyParametres(user, 3, 10)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        String password = webRequest.getParameter("password");

        if (isEmpty(password))
            throw new InvalidCredentials("User name or password is empty");

        if (chekMyParametres(password, 5, 15)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return new User(user, password);
    }

    private boolean isEmpty(String parameter) {
        return parameter == null || parameter.isEmpty();
    }

    private boolean chekMyParametres(String parameter, int min, int max) {
        return parameter.length() < min || parameter.length() > max;
    }

}
