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
@WebServlet("/SearchUserOther")
public class SearchUser extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String search_name = " ";
    private String sex;
    private String year_from;
    private String year_to;
    private String city;
    private static Connection con;
    private static Statement st;

    private List<InfoUser> SearchUser(String name_search,String search_name, String year_from, String year_to, String city)
            throws SQLException {
        List<InfoUser> listUser = new ArrayList<>();
        InfoUser infoUser = null;
        String sql = "SELECT user.full_name, info_user.birthday ,info_user.address, info_user.status "
                + "FROM user JOIN info_user ON info_user.id_user = user.idUser WHERE ( user.full_name LIKE '%"
                + search_name + "%' AND user.full_name != '"+ name_search + "') OR info_user.address = '" + city + "' OR year(info_user.birthday) BETWEEN "
                + year_from + " AND " + year_to;
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String full_name = rs.getString(1);
            Date birthday = rs.getDate(2);
            String address = rs.getString(3);
            String status = rs.getString(4);
            infoUser = new InfoUser(full_name, birthday, address, status);
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
        search_name = req.getParameter("name");
        sex = req.getParameter("gender");
        year_from = req.getParameter("min_max");
        year_to = req.getParameter("min_old");
        city = req.getParameter("city");
        String user_name_login = (String) session.getAttribute("user_name_login");
        System.out.println(search_name + sex + year_from + year_to + city);
        List<InfoUser> listSearch = new ArrayList<>();
        try {
            con = Connect.getConnection();
            st = con.createStatement();
            listSearch = SearchUser(user_name_login,search_name, year_from, year_to, city);
            System.out.println("in sise : " + listSearch.size());
            req.setAttribute("listSearch", listSearch);
            req.setAttribute("result_search", "Tìm thấy : "+ listSearch.size()+ " kết quả.");
            req.getRequestDispatcher("./jsp/ListSearch.jsp").forward(req, resp);
            System.out.println("OK");
        } catch (ClassNotFoundException | SQLException e1) {
            System.out.println(e1.getMessage());
        }
    }
}