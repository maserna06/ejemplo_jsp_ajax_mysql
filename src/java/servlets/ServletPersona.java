package servlets;

import clases.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletPersona", urlPatterns = {"/ServletPersona"})
public class ServletPersona extends HttpServlet {
    
 // desde aca programamos nosotros   
    
//    arraylist donde se almacenaran las personas que vamos creando
    private ArrayList<Persona> personas = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
//            obtener los parametros que enviamos por con ajax
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            
            if(!nombres.equals("") && !apellidos.equals("")) {
                
    //            instanciar la clase Persona
                Persona p = new Persona();

    //            asignarle los valores a los atributos nombres y apellidos de la clase Persona
                p.setNombres(nombres);
                p.setApellidos(apellidos);

    //            almacenar la persona creada en el arraylist de personas
                personas.add(p);
            }
          
            // inicializacion de la tabla donde se muestra el listado de personas
            String tabla = ""
            + "<table class='table table-hover'>"
                + "<thead>"
                    + "<tr>"
                        + "<th>Nombres</th>"
                        + "<th>Apellidos</th>"
                    + "</tr>"
                + "</thead>"
                + "<tbody>";

                int nroPersonas = personas.size();
            
                if(nroPersonas > 0) {
                    // iterar las personas que estan almacenadas en el arraylist para obtener sus datos y mostrarlos en la tabla
                    for(int i = 0; i < personas.size(); i++) {
                        tabla += ""
                        + "<tr>"
                            + "<td>"+personas.get(i).getNombres()+"</td>"
                            + "<td>"+personas.get(i).getApellidos()+"</td>"
                        + "</tr>";
                    }
                } else {
                    tabla += ""
                        + "<tr>"
                            + "<td colspan='2' class='text-center'>No hay información que mostrar</td>"
                        + "</tr>";
                }
            // cerrar la tabla            
            tabla += ""
                + "</tbody>"
            + "</table>";
            
            // imprimir el resultado que es recibido en el resul de la petición ajax
            out.println(tabla);
            
            // hasta aca programamos nosotros
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
