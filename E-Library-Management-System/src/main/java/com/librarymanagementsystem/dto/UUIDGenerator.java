package com.librarymanagementsystem.dto;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UUIDGenerator implements IdentifierGenerator {
	
	public static final String generatorName = "myGenerator";
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
