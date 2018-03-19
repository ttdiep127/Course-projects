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

import javax.servlet.ServletException;
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
@WebServlet("/ListFriends")
public class ListFriends extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String ac_id_user;
    private static Connection con;
    private static Statement st;

    private List<InfoUser> ListFriends(String ac_id_user)throws SQLException {
        List<InfoUser> listUser = new ArrayList<>();
        InfoUser infoUser = null;
        String sql = "SELECT DISTINCT user.full_name ,info_user.on_off "
                + "FROM (user "
                + "JOIN info_user ON user.idUser = info_user.id_user) "
                + "JOIN relationship_fr "
                + "ON ( (user.idUser = relationship_fr.id_user_1 "
                + "OR user.idUser=relationship_fr.id_user_2 ) "
                + "AND user.idUser !='"+ac_id_user+"') "
                + "WHERE (relationship_fr.id_user_1='"+ac_id_user+"' "
                + "OR relationship_fr.id_user_2='"+ac_id_user+"') "
                + "AND relationship_fr.status='bạn bè' ";
        ResultSet rs = st.executeQuery(sql);
        System.out.println("sql : " + sql);
        while (rs.next()) {
            String full_name = rs.getString(1);
            int on_off = rs.getInt(2);
            infoUser = new InfoUser(full_name, on_off);
            listUser.add(infoUser);
        }
        return listUser;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ac_id_user = (String) session.getAttribute("user_id_login");
        List<InfoUser> listFriends = new ArrayList<>();
        try {
            con = Connect.getConnection();
            st = con.createStatement();
            listFriends = ListFriends(ac_id_user);
            req.setAttribute("size_result_friends", listFriends.size());
            req.setAttribute("listFriends", listFriends);
            req.setAttribute("result_friends", "Danh sách có : "+ listFriends.size()+ " bạn bè.");
            req.getRequestDispatcher("./jsp/ListFriends.jsp").forward(req, resp);
            System.out.println("OK");
        } catch (ClassNotFoundException | SQLException e1) {
            System.out.println(e1.getMessage());
        }
    }
}