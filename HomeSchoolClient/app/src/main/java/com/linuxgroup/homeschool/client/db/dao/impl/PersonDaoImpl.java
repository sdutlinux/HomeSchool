package com.linuxgroup.homeschool.client.db.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.linuxgroup.homeschool.client.db.dao.PersonDao;
import com.linuxgroup.homeschool.client.db.model.Person;

import java.sql.SQLException;

/**
 * Created by tan on 14-10-23.
 */
public class PersonDaoImpl extends BaseDaoImpl<Person, Integer> implements PersonDao {
    public PersonDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Person.class);
    }

    public void save(Person person) throws SQLException {
        this.createOrUpdate(person);
    }

    public Person get(Integer id) throws SQLException {
        return this.queryForId(id);
    }
}
