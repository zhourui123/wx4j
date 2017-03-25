package cn.zr.wx4j.util;

import java.util.HashMap;
import java.util.Map;

import cn.zr.wx4j.exception.IllegalFileNameException;
import cn.zr.wx4j.model.material.NewsMaterials;
import cn.zr.wx4j.model.material.VideoDescription;

public class MaterialUtils {
	// /***
	// *
	// * 获取所有永久素材
	// *
	// */
	// public static String getMaterialList() {
	//
	// return null;
	//
	// }

	/***
	 * 
	 * 新增其它素材，image、voice、thumb
	 * 
	 * @param type
	 * @param filePath
	 * @throws IllegalFileNameException
	 */
	public static String addPerpetualOtherMaterial(String type, String filePath) throws IllegalFileNameException {
		if (!checkIsIllegalMaterial(filePath))
			throw new IllegalFileNameException("请输入正确的文件路径，文件必须是voice/bmp/png/jpeg/jpg/gif/mp3/wma/wav/amr/mp4等格式");

		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken()).replace("TYPE", type);
		Map<String, String> files = new HashMap<String, String>();
		files.put("media", filePath);
		return MyUtils.sendPostWithFiles(url, files);

	}

	/***
	 * 
	 * 新增video素材，video、thumb
	 * 
	 * @return 返回mediaId
	 * @param type
	 * @param filePath
	 * @throws IllegalFileNameException
	 */
	public static String addPerpetualVideoMaterial(String filePath, VideoDescription description)
			throws IllegalFileNameException {
		if (!checkVideoIsMp4(filePath))
			throw new IllegalFileNameException("视频只能是mp4格式");

		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken()).replace("TYPE", "video");
		Map<String, String> files = new HashMap<String, String>();
		Map<String, String> datas = new HashMap<String, String>();
		files.put("media", filePath);
		datas.put("description", MyUtils.obj2Json(description));

		return MyUtils.sendPostWithFilesAndDatas(url, files, datas);

	}

	/**
	 * 
	 * 添加临时素材
	 * 
	 * @param filePath
	 *            只允许image voice video和thumb
	 * @param type
	 * @return jsonStr
	 */
	public static String addTempMaterial(String type, String filePath) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken()).replace("TYPE", type);
		Map<String, String> files = new HashMap<String, String>();
		files.put("media", filePath);
		return MyUtils.sendPostWithFiles(url, files);

	}

	/***
	 * 
	 * 新增其它素材，image、voice、thumb bmp/png/jpeg/jpg/gif格式
	 * 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式 视频（video）：10MB，支持MP4格式
	 * 缩略图（thumb）：64KB，支持JPG格式
	 * 
	 * @param type
	 * @param filePath
	 */
	public static String addPerpetualNewsMaterials(NewsMaterials newsMaterials) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());
		String json = MyUtils.obj2Json(newsMaterials);
		return  MyUtils.sendPostWithJson(url, json);

	}

	/***
	 * 
	 * 
	 * @param filePath
	 * @return 返回图片url，只允许在腾讯系域名使用
	 * @throws IllegalFileNameException
	 */
	public static String uploadImageMaterial(String filePath) throws IllegalFileNameException {
		if (!checkImgIsPngOrJpg(filePath))
			throw new IllegalFileNameException("图片只能是png/jpg格式");
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", WxUtils.getAccessToken());
		Map<String, String> files = new HashMap<String, String>();
		files.put("media", filePath);
		return MyUtils.sendPostWithFilesAndDatas(url, files, null);

	}

	/***
	 * 移除永久素材
	 * 
	 * @param mediaId
	 */
	public String removePerpetualMaterial(String mediaId) {
		// https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN
		mediaId = "{\"media_id\":\"" + mediaId + "\"}";
		return MyUtils
				.sendPostWithJson("https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN"
						.replace("ACCESS_TOKEN", WxUtils.getAccessToken()), mediaId);

	}

	// public void getTempMaterial(OutputStream os) {
	// //"https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
	// }
	/**
	 * 
	 * 检查图片格式是否正确
	 * 
	 * @param filePath
	 * @return
	 */
	private static boolean checkImgIsPngOrJpg(String filePath) {
		filePath = filePath.toLowerCase();
		if (filePath.endsWith(".jpg") || filePath.endsWith("png"))
			return true;
		return false;
	}

	/**
	 * 
	 * 检查视频格式是否正确
	 * 
	 * @param filePath
	 * @return
	 */
	private static boolean checkVideoIsMp4(String filePath) {
		filePath = filePath.toLowerCase();
		if (filePath.toLowerCase().endsWith(".mp4"))
			return true;
		return false;
	}

	/**
	 * 
	 * 检查其它素材格式是否正确
	 * 
	 * @param filePath
	 * @return
	 */
	private static boolean checkIsIllegalMaterial(String filePath) {
		filePath = filePath.toLowerCase();
		if (filePath.endsWith(".bmp") || filePath.endsWith(".png") || filePath.endsWith(".jpg")
				|| filePath.endsWith(".gif") || filePath.endsWith(".mp3") || filePath.endsWith("wma")
				|| filePath.endsWith("wav") || filePath.endsWith("amr") || filePath.endsWith("mp4")) {
			return true;
		}
		return false;
	}

	/*
	 * private static boolean checkVideoSize(String filePath) { filePath =
	 * filePath.toLowerCase(); if (filePath.endsWith(".bmp") ||
	 * filePath.endsWith(".png") || filePath.endsWith(".jpg") ||
	 * filePath.endsWith(".gif") || filePath.endsWith(".mp3") ||
	 * filePath.endsWith("wma") || filePath.endsWith("wav") ||
	 * filePath.endsWith("amr") || filePath.endsWith("mp4")) { return true; }
	 * return false; }
	 * 
	 * private static boolean checkImageSize(String filePath) { filePath =
	 * filePath.toLowerCase(); if (filePath.endsWith(".bmp") ||
	 * filePath.endsWith(".png") || filePath.endsWith(".jpg") ||
	 * filePath.endsWith(".gif") || filePath.endsWith(".mp3") ||
	 * filePath.endsWith("wma") || filePath.endsWith("wav") ||
	 * filePath.endsWith("amr") || filePath.endsWith("mp4")) { return true; }
	 * return false; }
	 */
}
