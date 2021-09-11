package br.com.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.splunk.Application;
import com.splunk.ResponseMessage;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;
import com.splunk.ServiceArgs;
import com.splunk.User;

public class HelloSplunk {

	public static void main(String[] args) throws IOException {
		// Create a map of arguments and add login parameters
		ServiceArgs loginArgs = new ServiceArgs();
		loginArgs.setUsername("admin");
		loginArgs.setPassword("P@ssw0rd");
		loginArgs.setHost("127.0.0.1");
		loginArgs.setScheme("https");
		loginArgs.setSSLSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
		loginArgs.setPort(8089);

		// Create a Service instance and log in with the argument map
		Service service = Service.connect(loginArgs);
		
		for (User user : service.getUsers().values()) {
			System.out.println(user.getName());
		}
		
		for (Application app : service.getApplications().values()) {
			System.out.println(app.getName());
			if ("splunk_monitoring_console".equalsIgnoreCase(app.getName())) {
				System.out.println(app.getName());
			}
		}
		
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("name", "john snow");
		jsonMap.put("date", new Date());
		jsonMap.put("file", "AAAAAAAAAAA");
		jsonMap.put("line", "bbbbbbbbbbb");
//		jsonMap.put("line", "new_line_example2");
		
//		service.post("path", jsonMap);
		ResponseMessage rm1 = service.post("/servicesNS/nobody/system/apps/local/splunk_monitoring_console/indextest", jsonMap);
		System.out.println(rm1.getStatus());
		System.out.println(convertInputStreamToString(rm1.getContent()));
		System.out.println("aaa");
		
		convertInputStreamToString(service.get("/search/jobs").getContent());
		
		ResponseMessage rm2 = service.get("/servicesNS/nobody/system/apps/local/splunk_monitoring_console/indextest");
		
		System.out.println(service);
	}
	
	private static String convertInputStreamToString(InputStream inputStream) throws IOException {

		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}

		return result.toString(StandardCharsets.UTF_8.name());

	}

}
