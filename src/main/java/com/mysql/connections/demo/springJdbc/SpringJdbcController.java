package com.mysql.connections.demo.springJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpringJdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/selectSpringJdbc")
    @ResponseBody
    public List<Person> getPersons(){
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    @GetMapping("/insertSpringJdbc")
    @ResponseBody
    public String insertNewPerson(){
        jdbcTemplate.update("insert into person values(null,?,?)", "Alexandra", "Ionescu");
        return "s-a inserat cu succes";
    }
}
