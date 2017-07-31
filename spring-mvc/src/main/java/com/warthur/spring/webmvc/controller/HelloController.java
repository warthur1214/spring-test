package com.warthur.spring.webmvc.controller;

import com.warthur.spring.webmvc.model.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/person")
    public String getPersonInfo(String name, int age) {
        System.out.println(name + " " + age);
        return hello();
    }

    @RequestMapping("/getPerson")
    public String getPerson(Person person) {
        System.out.println(person.getName() + " " + person.getAge());
        return "hello";
    }

    @RequestMapping("/date")
    public String date(Date date) {
        System.out.println(date);
        return "hello";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:hello";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        FileOutputStream fileOutputStream = new FileOutputStream(
                request.getSession().getServletContext().getRealPath("/")
                        + "upload/" + sdf.format(new Date()) +
                        fileName.substring(fileName.lastIndexOf('.')));
        fileOutputStream.write(file.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        return "hello";
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public Person getJsonData() {
        Person p = new Person();
        p.setName("warthur");
        p.setAge(27);
        System.out.println(p.toString());
        return p;
    }

    @RequestMapping("/error")
    public void error(){
        throw new RuntimeException("RuntimeException!");
    }
}
