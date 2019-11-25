package com.itmo.example.t1.calculate;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculateController {

    private final Map<String, String> users = new HashMap<>();

    @GetMapping(value = "/sum")
    public String sum(@RequestParam(value = "first") Double first,
                      @RequestParam(value = "second", defaultValue = "1") Double second) {
        return first + second + "";
    }

    @PostMapping(value = "/minus")
    public String minus(@RequestHeader(value = "first") Double first,
                        @RequestHeader(value = "second", defaultValue = "1") Double second) {
        return first - second + "";
    }

    @RequestMapping(value = "/multi", method = RequestMethod.DELETE)
    public String multi(@RequestParam(value = "first") Double first,
                        @RequestParam(value = "second", defaultValue = "1") Double second) {
        return first*second + "";

    }



}
