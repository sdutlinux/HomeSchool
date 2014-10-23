package com.linuxgroup.homeschool.client.db.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.linuxgroup.homeschool.client.db.dao.PersonDao;
import com.linuxgroup.homeschool.client.db.model.ChatMessage;
import com.linuxgroup.homeschool.client.db.model.Person;
import com.linuxgroup.homeschool.client.db.model.RecentChat;

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

    /**
     * 根据帐号获取用户信息
     * @param account
     * @return
     * @throws SQLException
     */
    public Person queryBy(String account) throws SQLException {
        Where<Person, Integer> where = this.queryBuilder().where();

        where.eq("account", account);

        Person person = where.queryForFirst();

        return person;
    }
}
