package servlets;

import clases.Usuario;
import clases.UsuarioDatos;
import java.io.IOException;
import java.io.PrintWriter;
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
            
            String resultado;
            if(respuesta > 0) { 
                resultado = ""+ 
                "<div class=\"alert alert-dismissible alert-success\">\n" +
                "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                "   <strong>Confirmación!</strong> Usuario almacenado con Exito.\n" +
                "</div>"; 
            } else {
                resultado = ""+
                "<div class=\"alert alert-dismissible alert-danger\">\n" +
                "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                "   <strong>Error!</strong> Almacenando el usuario.\n" +
                "</div>"; 
            }
            
            out.println(resultado);
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
