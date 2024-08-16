package CSDataAccess.CSDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CSDataAccess.CSDTO.CSPaisDto;

public class CSPaisDao extends CSDataHelper implements CSIDao<CSPaisDto> {


    @Override
    public Boolean csCreate(CSPaisDto entity) throws Exception {
        String query = " INSERT INTO CSPais (Nombre) VALUES (?)";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CSPaisDto> csReadAll() throws Exception {
        List<CSPaisDto> csLst = new ArrayList<>();
        String query = " SELECT   idCSPais       "
                        +"Nombre                 "     
                        +",Estado                "     
                        +",FechaCreacion         "     
                        +"FROM CSPais            "
                        +"WHERE Estado = 'A'     "   ;
        try {
            Connection csCon = CSopenConnection();
            Statement csStmt = csCon.createStatement();
            ResultSet csRs = csStmt.executeQuery(query);
            while (csRs.next()) {
                CSPaisDto       csPdto = new CSPaisDto( 
                                csRs.getInt(1),
                                csRs.getString(2),
                                csRs.getString(3),
                                csRs.getString(4));
                                csLst.add(csPdto);
            }
        } catch (Exception e) {
        }  
        return csLst ; 
    }

    @Override
    public boolean csUpdate(CSPaisDto entity) throws Exception {
        String query = "UPDATE CSPais SET Nombre = ? WHERE idCSPais = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt  = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.setInt(2, entity.getIdCSPais());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean csDelete(Integer id) throws Exception {
        String query = " UPDATE CSPais SET Estado = ? WHERE idCSPais = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement  csPstmt = csCon.prepareStatement(query);
            csPstmt.setString(1, "X");
            csPstmt.setInt(2, id);
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public CSPaisDto readBy(Integer id) throws Exception {
        CSPaisDto csDto = new CSPaisDto(); 
        String query = "SELECT idCSPais"
                     +",Nombre"
                     +",Estado"
                     +",FechaCreacion"
                     +"FROM CSPais "
                     +"WHERE Estado  = 'A' AND idCSPais = " + id.toString();
        try {
            Connection csCon = CSopenConnection();
            Statement csStm = csCon.createStatement();
            ResultSet csRs =  csStm.executeQuery(query);
            while (csRs.next()) {
                csDto = new CSPaisDto(
                    csRs.getInt(1),
                    csRs.getString(2),
                    csRs.getString(3),
                    csRs.getString(4)
                );
            }

        } catch (SQLException e) {
           throw e ;
        }
        return csDto;
    }
    


    
}
