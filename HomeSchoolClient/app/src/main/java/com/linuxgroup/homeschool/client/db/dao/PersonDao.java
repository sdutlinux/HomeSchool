package com.linuxgroup.homeschool.client.db.dao;

import com.linuxgroup.homeschool.client.db.model.Person;

import java.sql.SQLException;

/**
 * Created by tan on 14-10-23.
 */
public interface PersonDao {
    public void save(Person person) throws SQLException;

    public Person get(Integer id) throws SQLException;
}
