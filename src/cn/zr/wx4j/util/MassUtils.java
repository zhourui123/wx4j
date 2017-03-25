package cn.zr.wx4j.util;


import cn.zr.wx4j.exception.IllegalFileNameException;
import cn.zr.wx4j.model.mass.VideoMaterial;
import cn.zr.wx4j.model.mass.openid.BaseMassWithOpenId;
import cn.zr.wx4j.model.mass.openid.CardMassWithOpenId;
import cn.zr.wx4j.model.mass.openid.ImageMassWithOpenId;
import cn.zr.wx4j.model.mass.openid.NewsMassWithOpenId;
import cn.zr.wx4j.model.mass.openid.TextMassWithOpenId;
import cn.zr.wx4j.model.mass.openid.VideoMassWithOpenId;
import cn.zr.wx4j.model.mass.openid.VoiceMassWithOpenId;
import cn.zr.wx4j.model.mass.preview.BasePreviewMass;
import cn.zr.wx4j.model.mass.preview.CardPreviewMass;
import cn.zr.wx4j.model.mass.preview.ImagePreviewMass;
import cn.zr.wx4j.model.mass.preview.NewsPreviewMass;
import cn.zr.wx4j.model.mass.preview.TextPreviewMass;
import cn.zr.wx4j.model.mass.preview.VideoPreviewMass;
import cn.zr.wx4j.model.mass.preview.VoicePreviewMass;
import cn.zr.wx4j.model.mass.tag.BaseMassWithTag;
import cn.zr.wx4j.model.mass.tag.CardMassWithTag;
import cn.zr.wx4j.model.mass.tag.ImageMassWithTag;
import cn.zr.wx4j.model.mass.tag.NewsMassWithTag;
import cn.zr.wx4j.model.mass.tag.TextMassWithTag;
import cn.zr.wx4j.model.mass.tag.VideoMassWithTag;
import cn.zr.wx4j.model.mass.tag.VoiceMassWithTag;
import cn.zr.wx4j.model.material.NewsMaterials;

public class MassUtils {

	public String uploadNewsMass(NewsMaterials news) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());
		String json = MyUtils.obj2Json(news);
		String result = MyUtils.sendPostWithJson(url, json);
		return result;
	}

	public String uploadVideoMass(VideoMaterial video) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());
		String json = MyUtils.obj2Json(video);
		String result = MyUtils.sendPostWithJson(url, json);
		return result;
	}

	public String uploadImageMass(String file) throws IllegalFileNameException {

		return MaterialUtils.uploadImageMaterial(file);
	}

	private String sendMassWithTagHelp(BaseMassWithTag mass) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());

		String json = MyUtils.obj2Json(mass);
		return MyUtils.sendPostWithJson(url, json);
	}

	private String sendMassWithOpenIdHelp(BaseMassWithOpenId mass) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());

		String json = MyUtils.obj2Json(mass);
		return MyUtils.sendPostWithJson(url, json);
	}

	private String sendPreviewMass(BasePreviewMass mass) {
		String url = "https:// api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());

		String json = MyUtils.obj2Json(mass);
		return MyUtils.sendPostWithJson(url, json);
	}

	public String sendMassWithTag(NewsMassWithTag mass) {
		return sendMassWithTagHelp(mass);
	}

	public String sendMassWithTag(TextMassWithTag mass) {

		return sendMassWithTagHelp(mass);
	}

	public String sendMassWithTag(VoiceMassWithTag mass) {

		return sendMassWithTagHelp(mass);
	}

	public String sendMassWithTag(ImageMassWithTag mass) {

		return sendMassWithTagHelp(mass);
	}

	public String sendMassWithTag(VideoMassWithTag mass) {

		return sendMassWithTagHelp(mass);
	}

	public String sendMassWithTag(CardMassWithTag mass) {
		return sendMassWithTagHelp(mass);
	}

	public String sendMassWithOpenId(NewsMassWithOpenId mass) {

		return sendMassWithOpenIdHelp(mass);
	}

	public String sendMassWithOpenId(TextMassWithOpenId mass) {

		return sendMassWithOpenIdHelp(mass);
	}

	public String sendMassWithOpenId(VoiceMassWithOpenId mass) {

		return sendMassWithOpenIdHelp(mass);
	}

	public String sendMassWithOpenId(ImageMassWithOpenId mass) {

		return sendMassWithOpenIdHelp(mass);
	}

	public String sendMassWithOpenId(VideoMassWithOpenId mass) {

		return sendMassWithOpenIdHelp(mass);
	}

	public String sendMassWithOpenId(CardMassWithOpenId mass) {

		return sendMassWithOpenIdHelp(mass);
	}

	public String deleteMass(int msgId) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());
		String json = "{\"msg_id\":MSG_ID}".replace("MSG_ID", String.valueOf(msgId));
		return MyUtils.sendPostWithJson(url, json);
	}

	public String previewNewsMass(NewsPreviewMass mass) {

		return sendPreviewMass(mass);
	}

	public String previewTextMass(TextPreviewMass mass) {

		return sendPreviewMass(mass);
	}

	public String previewVoiceMass(VoicePreviewMass mass) {

		return sendPreviewMass(mass);
	}

	public String previewImageMass(ImagePreviewMass mass) {

		return sendPreviewMass(mass);
	}

	public String previewVideoMass(VideoPreviewMass mass) {

		return sendPreviewMass(mass);
	}

	public String previewCardMass(CardPreviewMass mass) {

		return sendPreviewMass(mass);
	}

	public String getMassStatus(String msgId) {
		// https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN

		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());
		String json = "{\"msg_id\":MSG_ID}".replace("MSG_ID", msgId);
		return MyUtils.sendPostWithJson(url, json);
	}

}
