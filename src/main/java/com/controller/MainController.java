package com.controller;

import com.service.ConsumerService;
import com.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/8/4
 * @Version: 1.0
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ProducerService producerService;
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/main.html")
    public String index() {
        return "main";
    }


}
