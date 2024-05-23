package com.resturant.management.security;

import java.awt.RenderingHints.Key;

public class JwtToken {

    private static final String KEYS = "JSP2Mx8qKjwp3G6BI6SijadmDZuEDpJK";

    public static boolean isAuthenticated(String token) {
        Key key = getKey();
        Key key2 = getKey2();
        if (null != key && token != null && !token.isEmpty()) {

            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setAllowedClockSkewInSeconds(30)
                    .setExpectedIssuer("RMS")
                    .setExpectedAudience("UserLogin")
                    .setExpectedSubject("Authentication")
                    .setDecryptionKey(key2)
                    .setVerificationKey(key)
                    .setRelaxVerificationKeyValidation()
                    .setRelaxDecryptionKeyValidation()
                    .build();

            try {
                jwtConsumer.processToClaims(token);
                return true;
            } catch (InvalidJwtException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static Key getKey() {
        HmacKey key;
        try {
            key = new HmacKey(KEYS.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
        return key;
    }

    private static Key getKey2() {
        HmacKey key;
        try {
            key = new HmacKey(Arrays.copyOf(KEYS.getBytes("UTF-8"), 32));
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
        return key;
    }

    public static JwtClaims getJwtClaims(String token) {
        Key key = getKey();
        Key key2 = getKey2();
        if (null != key && token != null && !token.isEmpty()) {

            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setAllowedClockSkewInSeconds(30)
                    .setExpectedIssuer("RMS")
                    .setExpectedAudience("UserLogin")
                    .setExpectedSubject("Authentication")
                    .setDecryptionKey(key2)
                    .setVerificationKey(key)
                    .setRelaxVerificationKeyValidation()
                    .setRelaxDecryptionKeyValidation()
                    .build();

            try {
                return jwtConsumer.processToClaims(token);
            } catch (InvalidJwtException e) {
                // token expires 
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null; // throw exception
    }

    public static String getToken(UserLogin userLogin) throws JoseException {
        return performJsonWebEncrption(getJsonWebSignature(buildClaim(userLogin)));
    }

    private static String performJsonWebEncrption(String jwt) throws JoseException {
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setAlgorithmHeaderValue(
                KeyManagementAlgorithmIdentifiers.DIRECT);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        jwe.setKey(getKey2());
        jwe.setContentTypeHeaderValue("JWT");
        jwe.setDoKeyValidation(false);
        jwe.setPayload(jwt);

        return jwe.getCompactSerialization();
    }

    private static String getJsonWebSignature(JwtClaims jwtClaims) throws JoseException {
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(jwtClaims.toJson());
        jws.setKey(getKey());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setDoKeyValidation(false);
        String jwt = jws.getCompactSerialization();
        return jwt;
    }

    private static JwtClaims buildClaim(UserLogin user) {

        JwtClaims claims = new JwtClaims();
        claims.setIssuer("RMS");
        claims.setAudience("UserLogin");
        claims.setSubject("Authentication");
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        claims.setClaim("userId", user.getId().longValue());
        claims.setClaim("tokenCreateDate", new Date());
        claims.setClaim("username", user.getUsername());
        claims.setExpirationTimeMinutesInTheFuture(30);

//            claims.setStringListClaim("roles", roles); // add roles
        return claims;
    }

    public static String getStringValuefromJwtClaims(String token, String key) {
        return (String) getJwtClaims(token).getClaimValue(key);
    }

    public static Integer getInegerValuefromJwtClaims(String token, String key) {
        Long value = (Long) getJwtClaims(token).getClaimValue(key);
        return value.intValue();
    }

    public static Boolean getBooleanValuefromJwtClaims(String token, String key) {
        return (Boolean) Optional.ofNullable(getJwtClaims(token).getClaimValue(key)).orElse(false);
    }

}

