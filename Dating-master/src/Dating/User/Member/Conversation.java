/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dating.System.Database.Connect;
import Dating.User.Bean.InfoUser;
import Dating.User.Bean.Message;

/**
 * 2017/12/07
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/ListMessage")
public class Conversation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	private static Statement st;

	public static int MessageNotYet(String idUser) {
		int messNot = 0;
		try {
			Connection con = Connect.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT COUNT(status) FROM message WHERE id_user_receive = '" + idUser + "' AND status = 1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				messNot = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return messNot;
	}
	private String nameOther(String other){
		String name="";
		try {
			con = Connect.getConnection();
			st = con.createStatement();
			String sql = "SELECT full_name FROM user WHERE idUser = '"+other+"'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return name;
	}
	private List<InfoUser> listTopMessage(String idUser) {
		List<InfoUser> user_mess_list = new ArrayList<>();
		String other = "";
		try {
			con = Connect.getConnection();
			st = con.createStatement();
			String sql = "SELECT id_user_send,id_user_receive " + "FROM message " + "WHERE (id_user_send = '" + idUser
					+ "' OR id_user_receive = '" + idUser + "') " + "GROUP BY id_user_send,id_user_receive";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String id_user_send = rs.getString(1);
				String id_user_receive = rs.getString(2);
				String user_other = id_user_send.equals(idUser) ? id_user_receive : id_user_send;
				if (!user_other.equals(other)) {
					other = user_other;
					String sql_top = "SELECT content , date, status " + "FROM message " + "WHERE (id_user_send ='" + idUser
							+ "' AND id_user_receive = '" + user_other + "' ) " + "OR (id_user_send = '" + user_other
							+ "' AND id_user_receive = '" + idUser + "' ) " + "ORDER BY date DESC LIMIT 1";
					Statement st_top = con.createStatement();
					ResultSet rs_top = st_top.executeQuery(sql_top);
					while (rs_top.next()) {
						String content = rs_top.getString(1);
						String date = rs_top.getString(2).substring(0,16);
						int status = rs_top.getInt(3);
						InfoUser user_mess = new InfoUser(nameOther(other),other);
						user_mess.addMessage(new Message(content, date,status));
						user_mess_list.add(user_mess);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user_mess_list;
	}

	private void listMessage(String idUser) {
		try {
			con = Connect.getConnection();
			st = con.createStatement();
			String sql = "SELECT MAX(date), id_user_send,id_user_receive,content,date FROM message WHERE id_user_send = '"
					+ idUser + "' OR id_user_receive = '" + idUser + "' ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String idUser = (String) session.getAttribute("user_id_login");
		List<InfoUser> message = listTopMessage(idUser);
		req.setAttribute("message", message);
		req.getRequestDispatcher("./jsp/ListMessage.jsp").forward(req, resp);
	}

}
