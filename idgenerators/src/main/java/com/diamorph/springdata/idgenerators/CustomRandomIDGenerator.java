package com.diamorph.springdata.idgenerators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.Random;

public class CustomRandomIDGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        Random random = null;
        long id = 0;
        random = new Random();
        id = random.nextInt(100000);
        return id;
    }
}
