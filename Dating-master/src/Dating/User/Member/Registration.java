/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dating.System.Database.Connect;

/**
 * 2017/11/29
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/RegistrationWebDating")
public class Registration extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static String full_name;
    private  static String pass;
    private  static String mail = "Chưa cập nhật";
    private  static String day = "14";
    private  static String month = "04";
    private  static String year = "1994";
    private  static String sex = "Chưa cập nhật";
    private  static String weight = "Chưa cập nhật";
    private  static String height = "Chưa cập nhật";
    private  static String address = "Chưa cập nhật";
    private static  String job = "Chưa cập nhật";
    private  static String status = "Chưa cập nhật";
    private  static String introdution = "Chưa cập nhật";
    private  static String religion = "Chưa cập nhật";
    private  static String type = "member";
    private  static String idUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("nextregis")) {
            full_name = req.getParameter("name");
            pass = req.getParameter("password");
            mail = req.getParameter("email");
            day = req.getParameter("birthday_day");
            month = req.getParameter("birthday_month");
            year = req.getParameter("birthday_year");
            sex = req.getParameter("sex");
            req.getRequestDispatcher("./jsp/NextRegis.jsp").forward(req, resp);
        }
        if (action.equals("finishregis")) {
//            weight = req.getParameter("");
//            height = req.getParameter("");
            address = req.getParameter("city");
            job = req.getParameter("job");
            status = req.getParameter("status");
            introdution = req.getParameter("introduction");
            String birthday = year + "-" + month + "-" + day;
            try {
                addUser(req,resp,full_name, pass, type, weight, height, birthday, sex, address, mail, job, status, introdution,
                        religion);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void addUser(HttpServletRequest req,HttpServletResponse resp,String full_name, String pass, String type, String weight, String height, String birthday,
            String sex, String address, String mail, String job, String status, String introdution, String religion)
            throws ClassNotFoundException, UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(full_name + pass + type + weight + height + birthday + sex + address + mail + job + status
                + introdution + religion);
        String sql = "SELECT MAX(id_user) FROM info_user";
        Connection connect;
        try {
            connect = Connect.getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            String idUser_max = rs.getString(1);
            int User = Integer.parseInt(idUser_max.split("user")[1]) + 1;
            if (User < 10) {
                idUser = "user0" + String.valueOf(User);
            } else
                idUser = "user" + String.valueOf(User);
            PreparedStatement pst_ins_user = connect.prepareStatement("insert into user values (?,?,?,?)");
            PreparedStatement pst_ins_info = connect
                    .prepareStatement("insert into info_user values (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst_ins_user.setString(1, idUser);
            pst_ins_user.setString(2, full_name);
            pst_ins_user.setString(3, pass);
            pst_ins_user.setString(4, type);
            pst_ins_user.execute();
            System.out.println("ok");
            System.out.println(idUser);
            pst_ins_info.setString(1, idUser);
            pst_ins_info.setString(2, weight);
            pst_ins_info.setString(3, height);
            pst_ins_info.setString(4, birthday);
            pst_ins_info.setString(5, sex);
            pst_ins_info.setString(6, address);
            pst_ins_info.setString(7, mail);
            pst_ins_info.setString(8, job);
            pst_ins_info.setString(9, status);
            pst_ins_info.setString(10, introdution);
            pst_ins_info.setInt(11, 1);
            pst_ins_info.setString(12, religion);
            pst_ins_info.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        System.out.println("insert suscess");
        try {
            req.setAttribute("mess_regis", "Đăng kí thành công, đăng nhập để trải nghiệm.");
            req.getRequestDispatcher("/jsp/LoginRegistration.jsp").forward(req, resp);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
