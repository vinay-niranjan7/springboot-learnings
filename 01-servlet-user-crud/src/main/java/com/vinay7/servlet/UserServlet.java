package com.vinay7.servlet;

import com.vinay7.model.User;
import com.vinay7.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (id == null || email == null ||
                name == null || mobile == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n"+
                            " \"message\" : \"Some Fields are missing\"\n"+
                    "}"
            );
        }

            User user = new User(id, name, email, mobile);

            User createdUser = userService.createUser(user);

            // return user json
            response.setStatus(201);
            response.setContentType("application/json");
            response.getWriter().write(
                "{\n"+
                        " \"message\" : \"User added Successfully\"\n"+
                        "}"
        );

        }

        @Override
        public void doGet (HttpServletRequest request,
                HttpServletResponse response) throws IOException {

            String idParam = request.getParameter("id");

            if (idParam == null) {
                // get all users
                List<User> users=userService.getAllUsers();
                if(users.isEmpty()) {
                    response.setStatus(200);
                    response.setContentType("plain/text");
                    response.getWriter().write("no users are added yet");
                    return;
                }
                response.setStatus(200);
                response.setContentType("application/json");
                response.getWriter().write(usersToJson(users));
                return;

            }
            Integer id = Integer.parseInt(idParam);
            User userRes=userService.getUserById(id);

            if(userRes==null){
                response.setStatus(404);
                response.setContentType("application/json");
                response.getWriter().write(
                        "{\n"+
                                " \"message\" : \"Invalid User Not Found\"\n"+
                                "}"
                );
            }
             //return
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(userToJson(userRes));
        }

        @Override
        public void doPut (HttpServletRequest request,
                HttpServletResponse response) throws IOException {
            String idParam = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");

            if (idParam == null || email == null ||
                    name == null || mobile == null) {
                response.setStatus(400);
                response.setContentType("application/json");
                response.getWriter().write(
                        "{\n"+
                                " \"message\" : \"Some Fields are missing\"\n"+
                                "}"
                );
                return;
            }
            Integer id = Integer.parseInt(idParam);
            User userRes=userService.getUserById(id);

            if(userRes==null){
                response.setStatus(404);
                response.setContentType("application/json");
                response.getWriter().write(
                        "{\n"+
                                " \"message\" : \"Invalid User Not Found\"\n"+
                                "}"
                );
                return;
            }
            userRes.setEmail(email);
            userRes.setMobile(mobile);
            userRes.setName(name);
            User updatedUser= userService.createUser(userRes);
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"User updated successfully.\"}");
            return;

        }

        @Override
        public void doDelete (HttpServletRequest request,
                HttpServletResponse response) throws IOException {

            String idParam = request.getParameter("id");

            if (idParam == null) {
                response.setStatus(400);
                response.setContentType("application/json");
                response.getWriter().write(
                        "{\n"+
                                " \"message\" : \"Id is required\"\n"+
                                "}"
                );
            }
            Integer id = Integer.parseInt(idParam);
            User userRes=userService.getUserById(id);
            if(userRes==null){
                response.setStatus(404);
                response.setContentType("application/json");
                response.getWriter().write(
                        "{\n"+
                                " \"message\" : \"Invalid User Not Found\"\n"+
                                "}"
                );
                return;
            }

            userService.deleteUser(id);
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"User Deleted Successfully.\"}");
            return;

        }

        private String userToJson(User user){
           return "{\n" +
                    "    \"id\":" +user.getId()+"\n" +
                    "    \"name\":"+user.getName()+"\n" +
                    "    \"email\":"+user.getEmail()+"\n" +
                    "    \"mobile\":"+user.getMobile()+"\n" +
                    "}";
        }
        private String usersToJson(List<User> users){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            int i;
            for(i=0;i<users.size();i++){
                stringBuilder.append(userToJson(users.get(i)));

                if(i< users.size()-1) stringBuilder.append(",\n");
            }

            stringBuilder.append("]");
            return stringBuilder.toString();
        }

}