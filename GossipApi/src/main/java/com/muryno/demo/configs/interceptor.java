//package com.muryno.demo.configs;
//
//
//import org.springframework.context.annotation.Configuration;
//
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.List;
//
//        import javax.servlet.ServletRequest;
//        import javax.servlet.http.HttpServletRequest;
//        import javax.servlet.http.HttpServletResponse;
//
//        import org.slf4j.Logger;
//        import org.slf4j.LoggerFactory;
//        import org.springframework.stereotype.Component;
//        import org.springframework.util.StringUtils;
//        import org.springframework.web.servlet.HandlerInterceptor;
//
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Component
//public class IncomingRequestInterceptor implements HandlerInterceptor {
//    private static final Logger log = LoggerFactory.getLogger(IncomingRequestInterceptor.class);
//    private List<String> knownClients = new ArrayList(Arrays.asList("WEB_CLIENT", "MOBILE_INTERNAL_CLIENT"));
//    private String apiClient;
//
//    public IncomingRequestInterceptor() {
//    }
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return this.checkHeaders(request);
//    }
//
//    private boolean checkHeaders(ServletRequest reqObj) {
//        HttpServletRequest httpReq = (HttpServletRequest)reqObj;
//        this.apiClient = httpReq.getHeader("xCLIENT");
////        if (StringUtils.isEmpty(this.apiClient)) {
////            log.info("required CLIENT header not found");
////            throw new CustomException(ResponseCode.UNKNOWN_CLIENT);
////        } else if (!this.knownClients.contains(this.apiClient)) {
////            log.info("Invalid CLIENT header value: {}", this.apiClient);
////            throw new CustomException(ResponseCode.UNKNOWN_CLIENT);
////        } else {
////            return true;
////        }
//    }
//}
//
////@Configuration
////public class WebConfig implements WebMvcConfigurer {
////
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new IncomingRequestInterceptor()).excludePathPatterns(new String[] { "/", "/health",
////                "/v2/api-docs/**", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/resources/**" });
////    }
////}