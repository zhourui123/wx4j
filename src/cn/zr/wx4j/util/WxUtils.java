package cn.zr.wx4j.util;

import java.io.IOException;
import java.util.Properties;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;

import cn.zr.wx4j.model.AcessToken;
import cn.zr.wx4j.model.sendMsg.Item;
import cn.zr.wx4j.model.sendMsg.Message;
import cn.zr.wx4j.model.sendMsg.NewsMessage;

public class WxUtils {

	private static AcessToken token = null;
	private static Long acessTokenSaveTime = 0L;
	// 测试账号key
	public static final String APP_SECRET;
	public static final String APP_ID;
	public static final String WX_TOKEN;
	public static final String AES_KEY;
	public static final boolean IS_SAFE_MODE;
	public static final String ADAPTER_PATH;

	// 周睿1996公众号key
	// private static final String APPID = "wx7cd11cb5c49e5f39";
	// private static final String APPSECRET =
	// "ba787a886fe3158492e8a00563617486";

	static {
		System.out.println("wxutils static area excute");
		Properties prop = new Properties();
		try {
			prop.load(WxUtils.class.getResourceAsStream("/sys.properties"));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		APP_ID = prop.getProperty("app_id");
		APP_SECRET = prop.getProperty("app_secret");
		WX_TOKEN = prop.getProperty("token");
		IS_SAFE_MODE = prop.getProperty("is_safe_mode").equals("true");
		ADAPTER_PATH = prop.getProperty("adapterPath");

		if (IS_SAFE_MODE) {
			AES_KEY = prop.getProperty("encodingAesKey");
		} else {
			AES_KEY = null;
		}
		System.out.println(APP_ID);
		System.out.println(APP_SECRET);
	}

	/**
	 * 获取token字符串
	 * 
	 */
	public static String getAccessToken() {
		AcessToken token = getTokenFromLocal();

		if (token == null || isExpires()) {
			System.out.println("使用wx的token");
			return getTokenFromWx().getAccess_token();
		} else {
			System.out.println("使用本地的token");
			return token.getAccess_token();

		}

	}

	/**
	 * 从本地获取token
	 * 
	 */
	private static AcessToken getTokenFromLocal() {

		return token;
	}

	/**
	 * 从微信接口获取token
	 * 
	 */
	private static AcessToken getTokenFromWx() {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		String json = MyUtils.sendGet(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"
						.replace("APPID", APP_ID).replace("APPSECRET", APP_SECRET));
		System.out.println("从wx获得acesstoken json：" + json);
		AcessToken t = MyUtils.json2Obj(json, AcessToken.class);
		saveToken(t);
		return t;
	}

	/**
	 * 保存token到本地
	 * 
	 */
	private static void saveToken(AcessToken t) {
		token = t;
		acessTokenSaveTime = System.currentTimeMillis();
		System.out.println("保存token成功");

	}

	/**
	 * 
	 * 检查token是否过期
	 * 
	 * @return
	 */
	private static boolean isExpires() {
		Long currentTime = System.currentTimeMillis();

		// System.out.println("currentTime:" + currentTime);
		// System.out.println("acessTokenSaveTime:" + acessTokenSaveTime);
		// System.out.println("currentTime-acessTokenSaceTime=" + (currentTime -
		// acessTokenSaveTime));

		if (currentTime - acessTokenSaveTime > (token.getExpires_in() - 10) * 1000) {
			// if (currentTime - acessTokenSaveTime > 20000) {// 测试20秒就会过期
			// 超时了
			System.out.println("token过期了");
			return true;
		}
		System.out.println("token没过期");
		return false;

	}

	/**
	 * message转xml字符串
	 * 
	 * @param <T>
	 * 
	 */
	public static String message2Xml(Message message) {
		XStream xs = new XStream();
		xs.alias("xml", message.getClass());
		// xs.alias("item", Item.class);T
		return xs.toXML(message);

	}

	/**
	 * news转xml字符串
	 * 
	 */
	public static String news2Xml(NewsMessage news) {
		XStream xs = new XStream();
		xs.alias("xml", NewsMessage.class);
		xs.alias("item", Item.class);

		return xs.toXML(news);

	}

	public static String encryptMsg(String token, String encodingAesKey, String appId, String replyMsgXml,
			String timestamp, String nonce) throws AesException {
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		return pc.encryptMsg(replyMsgXml, timestamp, nonce);

	}

	public static String decryptMsg(String token, String encodingAesKey, String appId, String msgSignature,
			String timestamp, String nonce, String fromXML) throws AesException {
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
	}

}
