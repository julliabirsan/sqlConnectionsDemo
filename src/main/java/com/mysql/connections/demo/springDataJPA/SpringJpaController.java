package com.mysql.connections.demo.springDataJPA;

import com.mysql.connections.demo.hibernate.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpringJpaController {
    @Autowired
    PersonJpaDao personJpaDao;

    @GetMapping("/selectjpa")
    @ResponseBody
    public List<Person> selectPerson(){
        //select din bd
        return (List<Person>) personJpaDao.findAll();
    }

    @GetMapping("/insertjpa")
    @ResponseBody
    public String insertPerson(){
        //insert in bd
        Person p = new Person();
        p.setNume("Matei");
        p.setPrenume("Vlad");
        personJpaDao.save(p);
        return "s-a facut insert cu succes";
    }
}
