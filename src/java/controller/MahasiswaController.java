package controller;

import dao.MahasiswaDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mahasiswa;

public class MahasiswaController extends HttpServlet {

    MahasiswaDao mahasiswaDao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String page=request.getParameter("page");
            String view=null;
            mahasiswaDao=new MahasiswaDao();
            
            if(page!=null){
                if(page.equals("tambah")){
                    
                   view="formTambah";
                   
                }else if(page.equals("edit")){
                    
                    view="formEdit";
                    String nim=request.getParameter("nim");
                    Mahasiswa mahasiswa=mahasiswaDao.getMahasiswa(nim);
                    request.setAttribute("mahasiswa", mahasiswa);
                    
                }else if(page.equals("hapus")){
                    
                    view="index";
                    String nim=request.getParameter("nim");
                    mahasiswaDao.hapusMahasiswa(nim);
                    
                }
            }else{
                view="index";
                List<Mahasiswa> mahasiswas=mahasiswaDao.getAllMahasiswa();
                request.setAttribute("mahasiswas", mahasiswas);    
            }
            
            String url="/WEB-INF/"+view+".jsp";
            request.getRequestDispatcher(url).forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
