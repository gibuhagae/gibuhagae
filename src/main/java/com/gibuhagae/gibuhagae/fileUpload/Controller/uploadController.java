package com.gibuhagae.gibuhagae.fileUpload.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileUpload")
public class uploadController {

    @GetMapping(value = {"/upload"})
    public String defaultLocation() {
        return "fileUpload/upload";
    }
}
