/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Brand;
import models.BrandFacade;

/**
 *
 * @author admin
 */
@WebServlet(name = "BrandController", urlPatterns = {"/brand"})
public class BrandController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getAttribute("action").toString();
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "save":
                save(request, response);
                break;
            case "confirm":
                confirm(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;           
            default:
                request.setAttribute("action", "error");
        }
        //Chon view de hien ket qua
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);

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

    private void index(HttpServletRequest request, HttpServletResponse response) {
        BrandFacade bf = new BrandFacade();
        List<Brand> list = bf.readAll();
        request.setAttribute("list", list);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String op = request.getParameter("op");
            
            request.setAttribute("id", id);
            request.setAttribute("name", name);
            
            if (op.equals("save")) {
                if(id.isEmpty()|| name.isEmpty()){
                    throw new Exception();
                }
                Brand brand = new Brand(id, name);
                BrandFacade bf = new BrandFacade();
                bf.create(brand);
            }
            index(request, response);
            request.setAttribute("action", "index");
            
        } catch (Exception e) {
            request.setAttribute("action", "create");
            request.setAttribute("errorMessage", "Error when saving this brand.");
        }
    }

    private void confirm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("yes")) {
                String id = request.getParameter("id");
                BrandFacade bf = new BrandFacade();
                bf.delete(id); 
            }
            //Quay ve view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            //Quay ve view confirm va hien thong bao loi
            request.setAttribute("action", "confirm");
            request.setAttribute("errorMessage", "Error when deleting this toy.");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        //String id = request.getParameter("id");
        //request.setAttribute("id", id);
        //System.out.println("id id nefg: "+ id);        
        String id = request.getParameter("id");
        BrandFacade bf = new BrandFacade();
        Brand brand = bf.read(id);
        request.setAttribute("brand", brand);
        request.setAttribute("id", id);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            String id = request.getParameter("id");
            System.out.println("op ne: "+ op);
            if (op.equals("update")) {
                System.out.println("id ne:" + id);
                String name = request.getParameter("name");
                System.out.println("name : "+ name);
                Brand brand = new Brand(id, name);
                BrandFacade bf = new BrandFacade();
                bf.update(brand);
            }
            //Quay ve view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            //Quay ve view edit va hien thong bao loi
            request.setAttribute("action", "edit");
            request.setAttribute("errorMessage", "Error when updating this toy.");
        }
    }

}
