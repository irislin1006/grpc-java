package com.codenotfound.grpc_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringGrpcClientController {

    @Autowired
    private SpringGrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "hello") String method, @RequestParam(defaultValue = "Iris") String name) {
        if (method.equals("hello")) {
            return grpcClientService.sendHello(name);
        } else {
            return grpcClientService.sendPalindrome(name);
        }
    }
}
