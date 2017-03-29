package cn.zr.wx4j.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyUtils {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 发送get请求
	 */
	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;
		try {

			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 发送post请求
	 */
	public static String sendPost(String url, String param) {
		System.out.println("url:" + url);
		System.out.println("param:" + param);
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 对字符串md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * 发送post请求for json
	 */
	public static String sendBytes(String url, byte[] data) {
		System.out.println("url:" + url);
		System.out.println("data:" + new String(data));
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);

			URLConnection conn = realUrl.openConnection();

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");

			conn.setDoOutput(true);
			conn.setDoInput(true);
			// out = new PrintWriter(conn.getOutputStream());
			// out.print(data);

			conn.getOutputStream().write(data);
			// out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * string转unicode
	 */
	static String string2Unicode(String s) {
		try {
			StringBuffer out = new StringBuffer("");
			byte[] bytes = s.getBytes("unicode");
			for (int i = 2; i < bytes.length - 1; i += 2) {
				out.append("u");
				String str = Integer.toHexString(bytes[i + 1] & 0xff);
				for (int j = str.length(); j < 2; j++) {
					out.append("0");
				}
				String str1 = Integer.toHexString(bytes[i] & 0xff);

				out.append(str);
				out.append(str1);
				out.append(" ");
			}
			return out.toString().toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String china2Unicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * unicode转string
	 */
	public static String unicode2String(String unicode) {

		StringBuffer string = new StringBuffer();

		String[] hex = unicode.split("\\\\u");

		for (int i = 1; i < hex.length; i++) {

			int data = Integer.parseInt(hex[i], 16);

			string.append((char) data);
		}

		return string.toString();
	}

	/**
	 * ascii转native
	 */
	public static String ascii2native(String ascii) {

		List<String> ascii_s = new ArrayList<String>();
		String zhengz = "\\\\u[0-9,a-f,A-F]{4}";
		Pattern p = Pattern.compile(zhengz);
		Matcher m = p.matcher(ascii);
		while (m.find()) {
			ascii_s.add(m.group());
		}
		for (int i = 0, j = 2; i < ascii_s.size(); i++) {
			String code = ascii_s.get(i).substring(j, j + 4);
			char ch = (char) Integer.parseInt(code, 16);
			ascii = ascii.replace(ascii_s.get(i), String.valueOf(ch));
		}
		return ascii;
	}

	/**
	 * 
	 * 传入含有html字符的string，完成替换
	 */
	public static String htmlEscape(String content) {
		if (content == null)
			return "";
		String html = content;

		html = html.replaceAll("&", "&amp;");
		html = html.replaceAll("\"", "&quot;"); // "
		html = html.replaceAll("\t", "&nbsp;&nbsp;");
		html = html.replaceAll(" ", "&nbsp;");
		html = html.replaceAll("<", "&lt;");

		html = html.replaceAll(">", "&gt;");

		return html;
	}

	/**
	 * xml流转map
	 * 
	 */
	public static Map<String, String> xmlInputStream2Map(InputStream is) {
		SAXReader sr = new SAXReader();
		Document doc = null;
		try {
			doc = sr.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();

		List<Element> elements = root.elements();
		Map<String, String> map = new HashMap<String, String>();
		for (Element element : elements) {
			map.put(element.getName(), element.getText());
		}
		return map;
	}

	public static String xmlInputStream2String(InputStream is) {
		SAXReader sr = new SAXReader();
		Document doc = null;
		try {
			doc = sr.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc.getRootElement().asXML();

	}

	public static Map<String, String> xmlString2Map(String xml) {

		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Element root = doc.getRootElement();

		List<Element> elements = root.elements();
		Map<String, String> map = new HashMap<String, String>();
		for (Element element : elements) {
			map.put(element.getName(), element.getText());
		}
		return map;
	}

	/**
	 * 字符串验空
	 * 
	 */
	public static boolean strIsEmpty(String str) {

		if (str.trim().equals("") || str == null)
			return true;
		else
			return false;

	}

	/**
	 * json转对象
	 * 
	 */
	public static <T> T json2Obj(String json, Class<T> c) {
		Gson g = new Gson();

		return g.fromJson(json, c);
	}

	/**
	 * 对象转json字符串
	 * 
	 * @param json
	 * @return
	 */
	public static String obj2Json(Object o) {

		Gson g = new GsonBuilder().disableHtmlEscaping().create();
		return g.toJson(o);
	}

	/***
	 * 
	 * 
	 * 通过httpclient发送post
	 */
	public static String sendPostWithFilesAndDatas(String url, Map<String, String> files, Map<String, String> datas) {

		HttpClient httpClient = HttpClients.createDefault();
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
			if (files != null) {

				for (String key : files.keySet()) {
					entityBuilder.addPart(key, new FileBody(new File(files.get(key))));
				}
			}
			if (datas != null) {
				for (String key : datas.keySet()) {
					entityBuilder.addTextBody(key, datas.get(key));
				}
			}

			HttpEntity entity = entityBuilder.build();
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == HttpStatus.SC_OK) {
				System.out.println("response is ok!");
				HttpEntity resEntity = response.getEntity();
				BufferedReader reader = new BufferedReader(new InputStreamReader(resEntity.getContent()));

				String line = null;
				while ((line = reader.readLine()) != null) {
					result += line;
				}
				EntityUtils.consume(resEntity);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				// httpClient.getConnectionManager().shutdown();
			} catch (Exception ignore) {

			}
		}
		return result;

	}

	public static String sendPostWithFiles(String url, Map<String, String> files) {

		return sendPostWithFilesAndDatas(url, files, null);
	}

	public static String sendPostWithDatas(String url, Map<String, String> datas) {

		return sendPostWithFilesAndDatas(url, null, datas);
	}

	public static String sendPostWithJson(String url, String json) {
		String result = "";
		HttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(json);
			entity.setContentType("application/json");

			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == HttpStatus.SC_OK) {
				System.out.println("response is ok!");
				HttpEntity resEntity = response.getEntity();
				BufferedReader reader = new BufferedReader(new InputStreamReader(resEntity.getContent()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					result += line;
				}
				EntityUtils.consume(resEntity);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				// httpClient.getConnectionManager().shutdown();
			} catch (Exception ignore) {

			}
		}
		return result;

	}

}
