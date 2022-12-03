package com.fusky.example.consumer.controller;

import com.husky.example.consumer.client.DemoApi;
import com.husky.example.consumer.model.ClientApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "test")
@RequestMapping("/")
@Slf4j
public class ClientController implements ClientApi {

    @RpcReference(microserviceName = "Husky:ServiceCombProvider", schemaId = "test")
    private DemoApi demoApi;

    @GetMapping(path = "/client")
    public String callClient(String name) {
        return "client return: " + demoApi.hello(name);
    }
}

