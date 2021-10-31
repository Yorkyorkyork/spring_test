package com.example.demo.controller;

import com.example.demo.CharacterUtils;
import com.example.demo.model.EmailDTO;
import com.example.demo.model.EmailReqDTO;
import com.example.demo.model.EmailResDTO;
import com.example.demo.repository.EmailRepository;
import com.example.demo.service.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/mail")
@Transactional(rollbackFor = {Exception.class}) //下面的api有錯就不執行並rollback
public class MailController {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private mailService ms;

    @PostMapping("/mailTest")
    public @ResponseBody
    Boolean mail(@Valid @RequestBody EmailReqDTO req) {
        if (0 < emailRepository.countByEmailAndStatus(req.getEmail(), 1)) {
            return false;
        }
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setEmail(req.getEmail());
        emailDTO.setStatus(0);
        emailDTO.setVerify(CharacterUtils.getRandomString());
        ms.sendMail(req.getEmail(), "Escape Me 信箱驗證信", "您的驗證碼為: " + emailDTO.getVerify());
        emailRepository.save(emailDTO);
        return true;
    }

    @PostMapping("/mailCheck")
    public @ResponseBody
    EmailResDTO check(@Valid @RequestBody EmailReqDTO req) {
        EmailResDTO res = new EmailResDTO();
        EmailDTO emailDTO = emailRepository.findFirstByEmailAndVerifyAndStatus(req.getEmail(), req.getVerify(), 0);
        if(null == emailDTO){
            res.setStatus(0);
        }else{
            emailDTO.setStatus(1);
            emailRepository.save(emailDTO);
            res.setStatus(1);
        }
        return res;
    }
}