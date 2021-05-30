package com.csgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TransactionController {


    @GetMapping("/transactionIndex")
    public String transactionIndex()
    {
        return "transaction/transactionIndex";
    }
}
