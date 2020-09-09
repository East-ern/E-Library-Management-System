package com.librarymanagementsystem.dto;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomGenerator implements IdentifierGenerator {
	
	public static final String generatorName = "myGenerator";
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Random ran = new Random(); 
		int num = ran.nextInt(100000);
		return String.valueOf(num);
	}
}
