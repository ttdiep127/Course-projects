/**
 * 
 */
package Dating.User.Bean;

import java.util.Date;

/**
 * 2017/11/21
 * 
 * @author HaiRBk
 *
 */
public class Message {
	private String id_mess;
	private String content;
	private String date;
	private int status;
	private String id_user_send;
	private String id_user_reveive;

	/**
	 * @param id_user_send2
	 * @param id_user_receive
	 * @param content2
	 * @param date2
	 */
	public Message(String content, String date, int status) {
		this.content = content;
		this.date = date;
		this.status = status;
	}
	public Message(String id_user_send,String content, String date) {
		this.id_user_send = id_user_send;
		this.content = content;
		this.date = date;
	}
	/**
	 * 
	 */
	public Message() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id_mess
	 */
	public String getId_mess() {
		return id_mess;
	}

	/**
	 * @param id_mess
	 *            the id_mess to set
	 */
	public void setId_mess(String id_mess) {
		this.id_mess = id_mess;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the id_user_send
	 */
	public String getId_user_send() {
		return id_user_send;
	}

	/**
	 * @param id_user_send
	 *            the id_user_send to set
	 */
	public void setId_user_send(String id_user_send) {
		this.id_user_send = id_user_send;
	}

	/**
	 * @return the id_user_reveive
	 */
	public String getId_user_reveive() {
		return id_user_reveive;
	}

	/**
	 * @param id_user_reveive
	 *            the id_user_reveive to set
	 */
	public void setId_user_reveive(String id_user_reveive) {
		this.id_user_reveive = id_user_reveive;
	}

}
