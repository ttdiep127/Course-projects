/**
 * 
 */
package Dating.User.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 2017/11/21
 * 
 * @author HaiRBk
 *
 */
public class InfoUser {
	private String id_user;
	private String full_name;
	private String password;
	private String weight;
	private String height;
	private Date birthday;
	private String sex;
	private String mail;
	private String religion;
	private String job;
	private String status;
	private String introduction;
	private int on_off;
	private String type;
	private String address;
	private String id_add;
	private String date;
	private Set<ImageOfUser> mageOfUser;
	private Set<Message> message;
	public InfoUser() {
	}

	public InfoUser(String full_name,String idUser) {
		this.full_name = full_name;
		this.id_user = idUser;
	}
	public InfoUser(String full_name){
		this.full_name = full_name;
	}
	/**
	 * @return the id_add
	 */
	public String getId_add() {
		return id_add;
	}

	/**
	 * @param id_add the id_add to set
	 */
	public void setId_add(String id_add) {
		this.id_add = id_add;
	}

	public InfoUser(String idUser, String full_name, String type, String weight, String height, Date birthday,
			String sex, String address, String mail, String job, String status, String introdution, int on_off,
			String religion) {
		this.id_user = idUser;
		this.full_name = full_name;
		this.type = type;
		this.weight = weight;
		this.height = height;
		this.birthday = birthday;
		this.sex = sex;
		this.mail = mail;
		this.religion = religion;
		this.job = job;
		this.status = status;
		this.introduction = introdution;
		this.on_off = on_off;
		this.type = type;
		this.address = address;
	}

	/**
	 * @param full_name2
	 * @param birthday2
	 * @param address2
	 * @param status2
	 */
	public InfoUser(String full_name, Date birthday, String address, String status) {
		this.full_name = full_name;
		this.birthday = birthday;
		this.address = address;
		this.status = status;
	}
	public void InfoUserAdmin(String idUser, String full_name, String date,String id_add) {
		this.id_user = idUser;
		this.full_name = full_name;
		this.date = date;
		this.id_add = id_add;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param full_name2
	 * @param on_off2
	 */
	public InfoUser(String full_name, int on_off) {
		this.full_name = full_name;
		this.on_off = on_off;
	}

	/**
	 * @return the id_user
	 */
	public String getId_user() {
		return id_user;
	}

	/**
	 * @param id_user
	 *            the id_user to set
	 */
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}

	/**
	 * @param full_name
	 *            the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */

	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the on_off
	 */
	public int getOn_off() {
		return on_off;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion
	 *            the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction
	 *            the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the on_off
	 */
	public int isOn_off() {
		return on_off;
	}

	/**
	 * @param on_off
	 *            the on_off to set
	 */
	public void setOn_off(int on_off) {
		this.on_off = on_off;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the mageOfUser
	 */
	public Set<ImageOfUser> getMageOfUser() {
		return mageOfUser;
	}

	/**
	 * @param mageOfUser
	 *            the mageOfUser to set
	 */
	public void setMageOfUser(Set<ImageOfUser> mageOfUser) {
		this.mageOfUser = mageOfUser;
	}

	/**
	 * @return the message
	 */
	public Set<Message> getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(Set<Message> message) {
		this.message = message;
	}

	public void addMessage(Message message) {
		if (this.message == null)
			this.message = new HashSet<Message>();
		this.message.add(message);
	}
}
