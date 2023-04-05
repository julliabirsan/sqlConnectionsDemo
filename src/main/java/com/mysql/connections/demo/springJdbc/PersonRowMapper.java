package com.mysql.connections.demo.springJdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setNume(rs.getString("nume"));
        p.setPrenume(rs.getString("prenume"));
        return p;
    }
}
