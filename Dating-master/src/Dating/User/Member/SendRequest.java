/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dating.System.Database.Connect;

/**
 * 2017/12/20
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void accept(String idOfMe, String idUser) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE relationship_fr SET status = 'Bạn Bè' WHERE (id_user_1='" + idOfMe + "' AND id_user_2 = '"+idUser+"') OR (id_user_2 = '" + idOfMe
					+ "' " + "AND id_user_1 = '"+idUser+"')";
        Connection con = Connect.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
	}

	private void unAccept(String idOfMe, String idUser) throws ClassNotFoundException, SQLException {
		Connection connection = Connect.getConnection();
		String sql = "DELETE FROM relationship_fr WHERE relationship_fr.id_user_1 ='"+idUser+"' AND relationship_fr.id_user_2 = '"+idOfMe+"'";
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(sql);
	}

	private void sendRequest(String idOfMe, String idUser) throws ClassNotFoundException, SQLException {
		Connection connection = Connect.getConnection();
		String sql = "insert into relationship_fr ( id_user_1,id_user_2,status ,action_user)" + " values (?, ?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(sql);
		preparedStmt.setString(1, idOfMe);
		preparedStmt.setString(2, idUser);
		preparedStmt.setString(3, "Đang chờ");
		preparedStmt.setString(4, idOfMe);
		preparedStmt.execute();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String idOfMe = (String) session.getAttribute("user_id_login");
		String mess = null;
		String nUser = null;
		try {
			String idUser = req.getParameter("i");
			String rs_srq = (String) req.getParameter("rs_srq");
			if (rs_srq != null) {
				if (rs_srq.equals("ok")) {
					accept(idOfMe, idUser);
					mess = "Các bạn đã trở thành bạn bè";
				} else {
					unAccept(idOfMe, idUser);
					mess = "Bạn không đồng ý";
				}
				req.setAttribute("mess_srq", mess);
				req.getRequestDispatcher("/ViewInfoUser?search_user_name=" + nUser + "&&view_info_me=true&&ac=srq")
						.forward(req, resp);
			} else {

				nUser = req.getParameter("search_user_name");
				sendRequest(idOfMe, idUser);
				mess = "Gửi lời mời kết bạn thành công";
				req.setAttribute("mess_srq", mess);
				req.getRequestDispatcher("/ViewInfoUser?search_user_name=" + nUser + "&&view_info_me=false&&ac=srq")
						.forward(req, resp);
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
