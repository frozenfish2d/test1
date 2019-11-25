package com.itmo.example.t1.string;

import com.itmo.example.t1.calculate.exception.WrongDataException;
import com.itmo.example.t1.string.exception.RequestBodyItEmptyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class StringOperationControllerController {

    @PostMapping(value = "/toBase64")
    public String minus(@RequestBody String data) {
        String d = data.trim();
        if (d.isEmpty()) {
            throw new RequestBodyItEmptyException();
        }
        return Base64.getEncoder().encodeToString(d.getBytes());
    }

    @PostMapping(value = "/fromBase64")
    public String plus(@RequestBody String data) {
        String d = data.trim();
        if (d.isEmpty()) {
            throw new RequestBodyItEmptyException();
        }
        byte[] valueDecoded = Base64.getDecoder().decode(d);
        return new String(valueDecoded);


    }




    @PostMapping(value = "/split")
    public String minus(@RequestParam(value = "data") String data,
                        @RequestParam(value = "delimiter") String delimiter) {
        if (data == null || data.isEmpty()) {
            throw new WrongDataException();
        }
        return data.replaceAll(delimiter, " ");
    }
}
