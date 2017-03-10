package com.msse.web.utilities

import javax.persistence.AttributeConverter
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

/**
 * Created by z001hk8 on 2/15/17.
 */
class EncryptPassword implements AttributeConverter<String, String> {


    @Override
    String convertToDatabaseColumn(String attribute) {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(attribute));
        return String.format("%032x", new BigInteger(1, md5.digest()));

    }

    @Override
    String convertToEntityAttribute(String dbData) {
        return null
    }
}

