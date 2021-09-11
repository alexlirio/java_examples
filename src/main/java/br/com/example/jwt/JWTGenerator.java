package br.com.example.jwt;

public class JWTGenerator {


	public static void main(String[] args) {

		// The JWT format is: "header.payload.signature"

		String header = "{\"alg\":\"HS512\",\"typ\":\"JWT\"}";

		// To create a "exp" with 1 DAY use: Instant.now().plus(1, ChronoUnit.DAYS).getEpochSecond()
		String payload = "{\"iss\":\"johndoe@example.com\",\"name\":\"John Doe\",\"exp\":1516239022}";

		String encodedData = Base64Url.encode(header) + "." + Base64Url.encode(payload);

		String secretKey = "your-secret-key";
		String signature = HmacSha512.sign(secretKey, encodedData);

		String jwt = encodedData + "." + signature;

		System.out.println(jwt);
	}

}
