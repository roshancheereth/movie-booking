package org.publicissapient.moviesearch.api;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";
    private final HttpServletResponse httpServletResponse;

    public CustomErrorController(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @RequestMapping(value = PATH)
    public String error() {

        return "Error handling = HTTP Error " + httpServletResponse.getStatus();
    }

}
