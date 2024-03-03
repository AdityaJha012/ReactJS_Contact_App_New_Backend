package com.contact.app.Models;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {
	private static final long serialVersionUID = 1L;
	private int count = 0;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        count++;
        return "User" + count;
    }
}