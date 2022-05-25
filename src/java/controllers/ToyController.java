/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Toy;
import models.ToyFacade;

/**
 *
 * @author PHT
 */
@WebServlet(name = "ToyController", urlPatterns = {"/toy"})
public class ToyController extends HttpServlet {

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
                //Xu ly
                index(request, response);
                break;
            case "create":
                //Hien form nhap du lieu cho doi tuong toy (create -> save)
                create(request, response);
                break;
            case "save":
                //Luu doi tuong toy vao database
                save(request, response);
                break;
            case "edit":
                //Hien form sua du lieu cho doi tuong toy (edit -> update)
                edit(request, response);
                break;
            case "update":
                //Cap nhat doi tuong toy
                update(request, response);
                break;
            case "confirm":
                //Hien form confirm (confirm -> delete)
                confirm(request, response);
                break;
            case "delete":
                //Xoa doi tuong toy
                delete(request, response);
                break;
            default:
                request.setAttribute("action", "error");
        }
        //Chon view de hien ket qua
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
        ToyFacade tf = new ToyFacade();
        List<Toy> list = tf.readAll();
        request.setAttribute("list", list);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Toy toy = new Toy();
        request.setAttribute("toy", toy);
    }

    private void save1(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("save")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                BigDecimal price = new BigDecimal(request.getParameter("price"));
                Date expDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expDate"));
                String brandId = request.getParameter("brandId");
                Toy toy = new Toy(id, name, price, expDate, brandId);
                ToyFacade tf = new ToyFacade();
                tf.create(toy);
            }
            //Quay ve view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            //Quay ve view create va hien thong bao loi
            request.setAttribute("action", "create");
            request.setAttribute("errorMessage", "Error when saving this toy.");
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sprice = request.getParameter("price");
        String sexpDate = request.getParameter("expDate");
        String brandId = request.getParameter("brandId");
        
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("price", sprice);
        request.setAttribute("expDate", sexpDate);
        request.setAttribute("brandId", brandId);
        try {
            String op = request.getParameter("op");
            if (op.equals("save")) {
                BigDecimal price = new BigDecimal(sprice);
                Date expDate = new SimpleDateFormat("yyyy-MM-dd").parse(sexpDate);
                Toy toy = new Toy(id, name, price, expDate, brandId);
                ToyFacade tf = new ToyFacade();
                tf.create(toy);
            }
            //Quay ve view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            //Quay ve view create va hien thong bao loi
            request.setAttribute("action", "create");
            request.setAttribute("errorMessage", "Error when saving this toy.");
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        ToyFacade tf = new ToyFacade();
        Toy toy = tf.read(id);
        request.setAttribute("toy", toy);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("update")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                BigDecimal price = new BigDecimal(request.getParameter("price"));
                Date expDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expDate"));
                String brandId = request.getParameter("brandId");
                Toy toy = new Toy(id, name, price, expDate, brandId);
                ToyFacade tf = new ToyFacade();
                tf.update(toy);
            }
            //Quay ve view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            //Quay ve view edit va hien thong bao loi
            request.setAttribute("action", "edit");
            request.setAttribute("errorMessage", "Error when updating this toy.");
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
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
                ToyFacade tf = new ToyFacade();
                tf.delete(id);
            }
            //Quay ve view index
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            //Quay ve view confirm va hien thong bao loi
            request.setAttribute("action", "confirm");
            request.setAttribute("errorMessage", "Error when deleting this toy.");
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
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
