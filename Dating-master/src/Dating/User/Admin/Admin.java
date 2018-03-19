/**
 * 
 */
package Dating.User.Admin;

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
import Dating.User.Bean.*;
import Dating.User.Member.SearchUser;;

/**
 * 2017/11/26
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private List<InfoUser> showAdmin() throws ClassNotFoundException, SQLException{
    	 List<InfoUser> listUser = new ArrayList<>();
         InfoUser infoUser = null;
         String sql = "SELECT user.idUser, user.full_name,decentrals.date,decentrals.id_add FROM user JOIN decentrals ON user.idUser = decentrals.idUser WHERE user.type='admin' ";
         Connection con = Connect.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next()) {
             String idUser = rs.getString(1);
             String full_name = rs.getString(2);
             String date = rs.getString(3);
             String id_add = rs.getString(4);
             if(id_add==null) id_add = "";
             infoUser = new InfoUser();
             infoUser.InfoUserAdmin(idUser, full_name, date, id_add);
             listUser.add(infoUser);
         }
         return listUser;
    }
    private void searchName(){
//    	List<InfoUser> = SearchUser.
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		String del = (String) req.getParameter("del");
    		if(del.equals("true")){
    			String idAdmin = (String) req.getParameter("i");
    			delAdmin(idAdmin);
    		}
			List<InfoUser> listAdmin = showAdmin();
			req.setAttribute("listAdmin", listAdmin);
			req.getRequestDispatcher("./jsp/Decentrals.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	/**
	 * @param idAdmin
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void delAdmin(String idAdmin) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE user SET type = 'member' WHERE idUser =\"" + idAdmin + "\" ";
        Connection con = Connect.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
	}
}