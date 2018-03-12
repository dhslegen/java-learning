package java实例与思考;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestWithJdao {
	public static void main(String[] args) throws IOException, URISyntaxException {
		String pathString = new TestWithJdao().getPath();
		System.out.println(pathString + "service.xml");
		ApplicationContext ac = new FileSystemXmlApplicationContext(pathString + "service.xml");
		JdbcTemplate jdao = (JdbcTemplate) ac.getBean("jdao");
		queryAsTable(jdao, "select top 10 * FROM Z_ALIPAY_DUMP");
	}

	String getPath() throws UnsupportedEncodingException {
		return java.net.URLDecoder.decode(this.getClass().getClassLoader().getResource("").getPath(), "UTF-8");
	}

	private static void queryAsTable(JdbcTemplate jdao, String sql) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> sList = jdao.queryForList(sql);
		int p = 0;
		for (Map<String, Object> map : sList) {
			String keys = "";
			String values = "";
			Iterator<Entry<String, Object>> valuesIterator = map.entrySet().iterator();
			while (valuesIterator.hasNext()) {
				Entry<String, Object> valueEntry = valuesIterator.next();
				String key = valueEntry.getKey();
				keys = keys + String.format("%-20s", key);
				Object value = valueEntry.getValue();
				values = values + (value instanceof String ? String.format("%-20s", value) : String.valueOf(value));
			}
			if (p == 0) {
				System.out.println(keys);
			}
			System.out.println(values);
			p = 1;
		}
	}
}
