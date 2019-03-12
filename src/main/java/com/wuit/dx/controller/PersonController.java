package com.wuit.dx.controller;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${DX} on 2018/10/27.
 */
@Controller
public class PersonController {

    @Resource
    private LocalAuthService localAuthService;

    @ResponseBody
    @RequestMapping("/nameverify")
    public Boolean nameIsExists(String username){
        return !localAuthService.isNameExists(username);
    }

    @RequestMapping("/toregister")
    public String register(LocahAuth locahAuth, HttpServletRequest request){
        localAuthService.registerAuth(locahAuth);
        request.getSession().setAttribute("user",locahAuth);
        return "redirect:/";
    }

    @RequestMapping("/tologin")
    public String login(LocahAuth locahAuth,Model model,HttpServletRequest request){
       LocahAuth auth=  localAuthService.loginAuth(locahAuth);
        if(auth!=null){
            request.getSession().setAttribute("user",auth);
            return "redirect:/";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "/login";
        }
    }
    @RequestMapping("/forelogout")
    public String forelogout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }


    @RequestMapping("/personinfo")
    public String personinfo(MultipartFile profile,String email,String name,String gender) throws IOException {
        System.out.println(email);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(profile.getName());
        InputStream inputStream=profile.getInputStream();
        BufferedInputStream bis=new BufferedInputStream(inputStream);

        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("d:/dengxin.jpg"));
        byte[] imgs=new byte[1024];
        int i=0;
        while ((i=bis.read(imgs))!=-1){
            bos.write(imgs,0,i);
        }
        bos.close();
        bis.close();
        return "redirect:/";
    }

}
