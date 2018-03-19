/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dating.System.Database.Connect;
import Dating.User.Bean.*;;

/**
 * 2017/11/26
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/ViewInfoUser")
public class ViewInfoUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Connection con;
	private static Statement st;
	
	public static int sttRs(String idOfMe){
		return listRequest(idOfMe).size();
	}
	private static List<InfoUser> listRequest(String idOfMe) {
		List<InfoUser> user_list = new ArrayList<>();
		String other = "";
		try {
			con = Connect.getConnection();
			st = con.createStatement();
			String sql = "SELECT id_user_1,id_user_2 FROM relationship_fr " + "WHERE (id_user_1='" + idOfMe + "' OR id_user_2 = '" + idOfMe
					+ "') " + "AND status = 'Đang chờ' AND action_user != '"+idOfMe+"'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String id_user_1 = rs.getString(1);
				String id_user_2 = rs.getString(2);
				String user_other = id_user_1.equals(idOfMe) ? id_user_2 : id_user_1;
				if (!user_other.equals(other)) {
					other = user_other;
					String sql_name = "SELECT idUser, full_name FROM user where idUser = '"+other +"'";
					Statement st_name = con.createStatement();
					ResultSet rs_name = st_name.executeQuery(sql_name);
					while (rs_name.next()) {
						String idUser = rs_name.getString(1);
						String name = rs_name.getString(2);
						InfoUser user = new InfoUser(name,idUser);
						user_list.add(user);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user_list;
	}
	
	private boolean Relationship(String idOfMe, String idUser) throws SQLException {
		boolean checkRelation = false;
		String sql = "SELECT * FROM relationship_fr " + "WHERE (id_user_1='" + idOfMe + "' OR id_user_1 = '" + idUser
				+ "') " + "AND (id_user_2='" + idOfMe + "' OR id_user_2 ='" + idUser + "') " + "AND status = 'ban be'";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			checkRelation = true;
		}
		return checkRelation;
	}
	private InfoUser LoadDbUser(String user_name) throws SQLException {
		InfoUser infoUser = null;
		String sql = "SELECT user.idUser,user.full_name,user.type, info_user.weight,info_user.height,info_user.birthday,info_user.sex,info_user.address,info_user.mail,info_user.job,info_user.status,info_user.introduction,info_user.on_off,info_user.religion FROM user JOIN info_user ON info_user.id_user = user.idUser WHERE user.full_name=\""
				+ user_name + "\"";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String idUser = rs.getString(1);
			String full_name = rs.getString(2);
			String type = rs.getString(3);
			String weight = rs.getString(4);
			String height = rs.getString(5);
			Date birthday = rs.getDate(6);
			String sex = rs.getString(7);
			String address = rs.getString(8);
			String mail = rs.getString(9);
			String job = rs.getString(10);
			String status = rs.getString(11);
			String introdution = rs.getString(12);
			int on_off = rs.getInt(13);
			String religion = rs.getString(14);
			infoUser = new InfoUser(idUser, full_name, type, weight, height, birthday, sex, address, mail, job, status,
					introdution, on_off, religion);
		}

		return infoUser;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			con = Connect.getConnection();
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		HttpSession session = req.getSession();
		String user_name_login = (String) session.getAttribute("user_name_login");
		String user_id_login = (String) session.getAttribute("user_id_login");
		String view_info_me = req.getParameter("view_info_me");
		req.setAttribute("mess", " ");
		req.setAttribute("type", " ");
		String mess_srq=" ";
		try {
			if (view_info_me.equals("true")) {
				InfoUser infoUser = LoadDbUser(user_name_login);
				req.setAttribute("infoUser", infoUser);
				List<InfoUser> User_request = listRequest(user_id_login);
				req.setAttribute("user_rs", User_request);
				System.out.println(User_request.size());
				req.getRequestDispatcher("./jsp/ViewInfoUser.jsp?view_info_me=true").forward(req, resp);
			} else {
				String relationship = "notyet";
				String search_user_name = (String) req.getParameter("search_user_name");
				InfoUser infoUser = LoadDbUser(search_user_name);
				if (Relationship(user_id_login, infoUser.getId_user())) {
					relationship = "friend";
				}
				try{
					String ac = (String) req.getParameter("ac");
					if(ac.equals("srq")) {relationship="pending";
					mess_srq= (String)req.getAttribute("mess_srq");
					}
				}catch(Exception e){
					
				}
				req.setAttribute("mess_srq", mess_srq);
				req.setAttribute("relationship", relationship);
				req.setAttribute("infoUser", infoUser);
				req.getRequestDispatcher("./jsp/ViewInfoUser.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}