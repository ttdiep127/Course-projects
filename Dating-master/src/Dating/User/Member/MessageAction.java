/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.model.core.ID;

import Dating.System.Database.Connect;
import Dating.User.Bean.InfoUser;
import Dating.User.Bean.Message;

/**
 * 2017/12/07
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/SendMessage")
public class MessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	private static Statement st;
	private static String content_send;

    public void ChangeStatus(String idUser, String idUser_w) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE message SET status = 0 "+ "WHERE (id_user_send = '" + idUser
				+ "' and id_user_receive = '" + idUser_w + "') " + "OR (id_user_send = '" + idUser_w
				+ "' AND id_user_receive = '" + idUser + "')";
        Connection con = Connect.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
    }
	
	private InfoUser Message(String idUser, String idUser_w, String n) {
		InfoUser info = new InfoUser(n, idUser_w);
		try {
			con = Connect.getConnection();
			st = con.createStatement();
			String sql = "SELECT id_user_send,content, date " + "FROM message " + "WHERE (id_user_send = '" + idUser
					+ "' and id_user_receive = '" + idUser_w + "') " + "OR (id_user_send = '" + idUser_w
					+ "' AND id_user_receive = '" + idUser + "') order by date asc";
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				String idUserSend = rs.getString(1);
				String content = rs.getString(2);
				String date = rs.getString(3).substring(0, 16);
				Message message = new Message(idUserSend, content, date);
				info.addMessage(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return info;
	}

	public String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

	private void SendMessage(String idUser_send, String idUser_w_receive, String content) {
		Connection connect;
		String idmess;
		String sql = "SELECT MAX(id_mess) FROM message";
		try {
			connect = Connect.getConnection();
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			String idMess_max = rs.getString(1);
			int mess = Integer.parseInt(idMess_max.split("mess")[1]) + 1;
			if (mess < 10) {
				idmess = "mess0" + String.valueOf(mess);
			} else
				idmess = "mess" + String.valueOf(mess);
			PreparedStatement pst_ins_info = connect.prepareStatement("insert into message values (?,?,?,?,?,?)");
			pst_ins_info.setString(1, idmess);
			pst_ins_info.setString(2, idUser_send);
			pst_ins_info.setString(3, idUser_w_receive);
			pst_ins_info.setString(4, content);
			pst_ins_info.setString(5, getCurrentTimeStamp());
			pst_ins_info.setInt(6, 1);
			pst_ins_info.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		String idUser = (String) session.getAttribute("user_id_login");
		String idUser_w = (String) req.getParameter("w");
		String name_other = (String) req.getParameter("n");
		try {
			ChangeStatus(idUser, idUser_w);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			content_send = (String) req.getParameter("send");
			SendMessage(idUser, idUser_w, content_send);
		} catch (Exception e) {
		}
		System.out.println("con :" + content_send);
		InfoUser info_mess = Message(idUser, idUser_w, name_other);
		req.setAttribute("info_mess", info_mess);
		req.getRequestDispatcher("./jsp/Messages.jsp").forward(req, resp);
	}
}
