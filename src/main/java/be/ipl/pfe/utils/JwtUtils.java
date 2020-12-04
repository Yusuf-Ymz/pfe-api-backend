package be.ipl.pfe.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.Properties;

public class JwtUtils {

	private static Properties props = new Properties();

	static {
		String profile = System.getenv("PROFILE");
		System.out.println(profile);
		if (profile == null) profile = "local";

		try (FileInputStream file = new FileInputStream("src/main/resources/application-" + profile + ".properties")) {
			props.load(file);
		} catch (IOException ioException) {
			System.out.println("Error while reading profile properties file.");
			System.exit(1);
		}
	}

	public static String createJWT(String id, String username) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Date now = new Date(System.currentTimeMillis());

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(props.getProperty("JWT_SECRET"));
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder()
		                         .setId(id)
		                         .setIssuedAt(now)
		                         .setIssuer(username)
		                         .signWith(signatureAlgorithm, signingKey);

		return builder.compact();
	}

}
