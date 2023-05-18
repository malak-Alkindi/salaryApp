package com.example.demoSalaryApp.controllers;

import com.example.demoSalaryApp.models.accountmodel;
import com.example.demoSalaryApp.services.accountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demoSalaryApp.responseopject.GetAccountResponse;
import java.util.Date;
import java.util.List;

@RestController
public class account  {
    @Autowired
    accountservice accountservice;

    @RequestMapping("account/create")
    public void saveAccount() {
        createAccount();
    }

    @RequestMapping("account/get")
    public List<accountmodel> getAccount() {
        return accountservice.getAccount();
    }

    @RequestMapping("account/getone")
    public List<accountmodel> getOneAccount() {
        return accountservice.getOneAccount();
    }

    //Path Variable
    @RequestMapping("account/get/{Id}")
    public GetAccountResponse createAccount (@PathVariable Long Id) {
        return accountservice.getEmployeeById(Id);
    }

    @RequestMapping("account/delete/{Id}")
    public void deleteeAccount (@PathVariable Long Id) {
         accountservice.deleteEmployeeById(Id);
    }
    public void createAccount() {
        accountmodel accountt = new accountmodel();
        accountt.setAccountType("Saving");
        accountt.setAccountNumber("40202020220");
        //account.setId(9092L);
        accountt.setBankName("Muscat");
        accountt.setBankBranch("Seeb");
        accountt.setBranchCode(121);
        accountt.setCreatedDate(new Date());
        accountt.setIsActive(true);
        accountt.setSwiftCode("93939");
        accountt.setAccountHolderName("Mohammed");
        accountservice.saveAccount(accountt);
    }
    @GetMapping("account/quer")
    @ResponseBody
    public GetAccountResponse getFoos(@RequestParam String a,@RequestParam String b,@RequestParam String c,@RequestParam String d) {
        accountmodel accountt = new accountmodel();
        accountt.setBankName(a);
        accountt.setAccountNumber(b);
        accountt.setBankBranch(c);
        accountt.setSwiftCode(d);
        return accountservice.getAccountAsString(accountt);
    }



}
