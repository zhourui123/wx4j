package cn.zr.wx4j.util;

import java.util.HashMap;
import java.util.Map;

import cn.zr.wx4j.model.Kefu;
import cn.zr.wx4j.model.KefuInvite;

public class KefuUtils {
	public String addKefu(Kefu kefu) {
		String json = MyUtils.obj2Json(kefu);
		return MyUtils
				.sendPostWithJson("https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN"
						.replace("ACCESS_TOKEN", WxUtils.getAccessToken()), json);
	}

	public String inviteWorker(KefuInvite info) {
		String json = MyUtils.obj2Json(info);
		return MyUtils.sendPostWithJson(
				"https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=ACCESS_TOKEN"
						.replace("ACCESS_TOKEN", WxUtils.getAccessToken()),
				json);

	}

	public String deleteKefu(String kefuAccount) {
		return MyUtils.sendGet(
				"https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT"
						.replace("ACCESS_TOKEN", WxUtils.getAccessToken()).replace("KFACCOUNT", kefuAccount));
	}

	public String updateKefu(Kefu kefu) {
		String json = MyUtils.obj2Json(kefu);
		return MyUtils
				.sendPostWithJson("https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN"
						.replace("ACCESS_TOKEN", WxUtils.getAccessToken()), json);
	}

	public String uploadKefuHeadImg(String kefuAccount, String headImgPath) {
		Map<String, String> map = new HashMap<String, String>();
		return MyUtils
				.sendPostWithFiles(
						"https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT"
								.replace("ACCESS_TOKEN", WxUtils.getAccessToken()).replace("KFACCOUNT", kefuAccount),
						map);

	}

	public String getOnlineKefuList() {

		return MyUtils
				.sendGet("https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN"
						.replace("ACCESS_TOKEN", WxUtils.getAccessToken()));
	}

	public String getKefuList() {
		return MyUtils.sendGet("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken()));
	}
}
