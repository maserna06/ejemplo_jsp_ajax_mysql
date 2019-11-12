package servlets;

import clases.Usuario;
import clases.UsuarioDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String accion = request.getParameter("accion");
            
            if(accion.equals("crear")) {
                String nombres     = request.getParameter("nombres");
                String apellidos   = request.getParameter("apellidos");
                String email       = request.getParameter("email");
                String contrasenia = request.getParameter("contrasenia");

                Usuario u = new Usuario();
                u.setNombres(nombres);
                u.setApellidos(apellidos);
                u.setEmail(email);
                u.setContrasenia(contrasenia);

                int respuesta = UsuarioDatos.crear(u);
                out.println(respuesta);
            }
            
            if(accion.equals("listar")) {
                List<Usuario> usuarios = UsuarioDatos.listarUsuarios();

                String tabla = "" +
                "<table class=\"table table-hover\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">Nombres</th>\n" +
                "      <th scope=\"col\">Apellidos</th>\n" +
                "      <th scope=\"col\">Email</th>\n" +
                "      <th scope=\"col\"></th>\n" +
                "      <th scope=\"col\"></th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>";
                
                for(int i = 0; i < usuarios.size(); i++) {
                    tabla += "" +
                    "    <tr class=\"table-active\">\n" +
                    "      <td>"+usuarios.get(i).getNombres()+"</td>\n" +
                    "      <td>"+usuarios.get(i).getApellidos()+"</td>\n" +
                    "      <td>"+usuarios.get(i).getEmail()+"</td>\n" +
                    "      <td><a href='#' class=\"btn btn-info btn-sm\" onclick='editarUsuario("+usuarios.get(i).getId()+")'>Editar</a></td>\n" +
                    "      <td><a href='#' class=\"btn btn-danger btn-sm\" onclick='eliminarUsuario("+usuarios.get(i).getId()+")'>Eliminar</a></td>\n" +
                    "    </tr>";
                }
                        
                tabla += "" +
                "  </tbody>\n" +
                "</table>\n";
                
                out.println(tabla);
            }
            
            if(accion.equals("editar")) {
                String id = request.getParameter("id");
                Usuario u = UsuarioDatos.getUsuarioPorId(Integer.parseInt(id));
                String json = "{ \"title\": \"testTitle\", \"link\" : \"testLink\"}";
//                String json = "{ " + 
//                    "\"id\"          : \""+Integer.toString(u.getId())+"\", " +
//                    "\"nombres\"     : \""+u.getNombres()+"\"" +
//                    "\"apellidos\"   : \""+u.getApellidos()+"\"" +
//                    "\"email\"       : \""+u.getEmail()+"\"" +
//                    "\"contrasenia\" : \""+u.getContrasenia()+"\"" +
//                "}";
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(json);
                out.flush();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
