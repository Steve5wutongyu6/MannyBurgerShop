package action;

import bean.User;
import dao.UserDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 检查是否为 multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                String username = null, password = null, name = null, email = null, telephone = null, sex = null, birthdayStr = null, photoPath = null;
                Date birthday = null;

                for (FileItem item : items) {
                    if (item.isFormField()) {
                        switch (item.getFieldName()) {
                            case "username":
                                username = item.getString("UTF-8");
                                break;
                            case "password":
                                password = item.getString("UTF-8");
                                break;
                            case "name":
                                name = item.getString("UTF-8");
                                break;
                            case "email":
                                email = item.getString("UTF-8");
                                break;
                            case "telephone":
                                telephone = item.getString("UTF-8");
                                break;
                            case "sex":
                                sex = item.getString("UTF-8");
                                break;
                            case "birthday":
                                birthdayStr = item.getString("UTF-8");
                                break;
                        }
                    } else {
                        // 处理文件上传
                        if (item.getSize() > 0) {
                            String fileName = new File(item.getName()).getName();
                            // 使用绝对路径
                            String filePath = "D:/JavaWeb/image/userimage/" + fileName;
                            System.out.println(filePath);
                            File uploadedFile = new File(filePath);

                            // 检查并创建目录
                            File directory = new File("D:/JavaWeb/image/userimage/");
                            if (!directory.exists()) {
                                directory.mkdirs(); // 创建所有必要的父目录
                            }

                            item.write(uploadedFile);
                            photoPath = "D:/JavaWeb/image/userimage/" + fileName;
                        }
                    }
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    birthday = sdf.parse(birthdayStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                user.setEmail(email);
                user.setTelephone(telephone);
                user.setSex(sex);
                user.setBirthday(birthday);
                user.setPhoto_path(photoPath); // 设置图片路径

                UserDao userDao = new UserDao();
                boolean isUpdated = userDao.updateUser(user);

                if (isUpdated) {
                    request.setAttribute("message", "用户信息更新成功！");
                    System.out.println("用户信息更新成功！");
                    request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "用户信息更新失败！");
                    System.out.println("用户信息更新失败！");
                    request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByName(new User(username));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
    }
}