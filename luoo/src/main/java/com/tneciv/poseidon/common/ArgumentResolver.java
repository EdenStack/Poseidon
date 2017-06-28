package com.tneciv.poseidon.common;

import com.tneciv.poseidon.annotations.TnecivArgument;
import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Tneciv on 2017/6/28.
 */
@Component
public class ArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private JournalService journalService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(TnecivArgument.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        JournalDto journalDto = journalService.queryByJournalId(1);
        return journalDto;
    }
}
