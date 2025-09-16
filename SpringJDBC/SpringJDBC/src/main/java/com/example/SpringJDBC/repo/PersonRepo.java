package com.example.SpringJDBC.repo;

import com.example.SpringJDBC.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class PersonRepo {
private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Person alien){
        String sql = "insert into alien(Id, name, tech) values(?,?,?)";
        template.update(sql, alien.getId(),alien.getName(),alien.getTech());
        System.out.println("Added");
    }

    public List<Person> findAll(){
        String sql = "select * from alien";

       RowMapper<Person>mapper = new RowMapper<>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person a = new Person();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }
        };

       List<Person>aliens = template.query(sql, mapper );
        return aliens;
    }
}
