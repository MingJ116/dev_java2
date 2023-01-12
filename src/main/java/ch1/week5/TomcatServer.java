package ch1.week5;
// 이클톰캣서버 불러오기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatServer {
	public static void main (String[] args) {
		String url = "http://192.168.110.8:9000/index.html";
		try { // 에외가 발생할 가능성이 있는 코드
			URL myURL = new URL (url);
			HttpURLConnection con = (HttpURLConnection) myURL.openConnection ();
			int responseCode = con.getResponseCode (); // 200(정상), 204, 404(에러), 500(런타임 에러) 상수 코드를 확인 가능하게 함.
//			System.out.println (responseCode);
//			System.out.println (5 / 0);
			BufferedReader br = new BufferedReader (new InputStreamReader (con.getInputStream (), "UTF-8")); // BufferedReader실제로는 읽어올수있는 메소드가 아님
			StringBuilder sb = new StringBuilder ();
			String line = "";
			while ((line = br.readLine ()) != null) {
				sb.append (line);
			}
			System.out.println (sb.toString ()); // 문자열로 형전환후 출력
			
		} catch (Exception e) {
			System.out.println (e.toString ());
		}
		
	}
}
