package arfolyam;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import com.sun.net.httpserver.HttpServer;

public class MNBKozep {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(9080), 0);
		server.createContext("/mnb", (exchange -> {
			if ("GET".equals(exchange.getRequestMethod())) {
				
        String mnbKozep = getMNBKozep();
				mnbKozep = mnbKozep.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        
				exchange.sendResponseHeaders(200, mnbKozep.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(mnbKozep.getBytes());
				output.flush();
			} else {
				exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
			}
			exchange.close();
		}));
		server.setExecutor(null); // creates a default executor
		server.start();
	}
/*
*/
	private static String getMNBKozep() throws MalformedURLException, IOException {

		String url = "http://www.mnb.hu/arfolyamok.asmx?singleWSDL";

		HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();

		// add reuqest header
		httpClient.setRequestMethod("POST");
		httpClient.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

		String data = "<?xml version=\"1.0\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.mnb.hu/webservices/\"><soapenv:Header/><soapenv:Body><web:GetCurrentExchangeRates/></soapenv:Body></soapenv:Envelope>";
		// Send post request
		httpClient.setDoOutput(true);

		try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
			wr.writeBytes(data);
			wr.flush();
		}

		int responseCode = httpClient.getResponseCode();

		System.out.println("Response Code : " + responseCode);

		try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

			String line;
			StringBuilder response = new StringBuilder();

			while ((line = in.readLine()) != null) {
				response.append(line);
			}

			// print result
			System.out.println(response.toString());
			return response.toString();
		}
	}
}
