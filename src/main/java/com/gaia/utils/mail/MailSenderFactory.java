package com.gaia.utils.mail;

public class MailSenderFactory {
	/**
	 * 服务邮箱
	 */
	private static SimpleMailSender serviceSms = null;

	/**
	 * 获取邮箱
	 * @return 符合类型的邮箱
	 */
	public static SimpleMailSender getSender() {
		if (serviceSms == null) {
			serviceSms = new SimpleMailSender("dexia115@sina.com", "Lxd53650205");
		}
		return serviceSms;
	}
}
