package CSDataAccess.CSDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CSDataAccess.CSDTO.CSProvinciaDto;

public class CSProvinciaDao extends CSDataHelper implements CSIDao<CSProvinciaDto> {


    @Override
    public Boolean csCreate(CSProvinciaDto entity) throws Exception {

        String query = " INSERT INTO CSProvincia (Nombre ,idCSRegion) VALUES (?,?)";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.setInt(2, entity.getIdCSRegion());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  
        }
    }

    @Override
    public List<CSProvinciaDto> csReadAll() throws Exception {

         List<CSProvinciaDto> csLst = new ArrayList<>();
        String query = " SELECT   idCSProvincia  "
                        +",Nombre                "   
                        +",idCSRegion            "     
                        +",Estado                "     
                        +",FechaCreacion         "     
                        +"FROM CSProvincia        "
                        +"WHERE Estado = 'A'     "   ;
        try {
            Connection csCon = CSopenConnection();
            Statement csStmt = csCon.createStatement();
            ResultSet csRs = csStmt.executeQuery(query);
            while (csRs.next()) {
                CSProvinciaDto  csPdto = new CSProvinciaDto( 
                                csRs.getInt(1),
                                csRs.getString(2),
                                csRs.getInt(3),
                                csRs.getString(4),
                                csRs.getString(5));
                                csLst.add(csPdto);
            }
        } catch (Exception e) {
        }  
        return csLst ; 
    }

    @Override
    public boolean csUpdate(CSProvinciaDto entity) throws Exception {
        String query = "UPDATE CSProvincia SET Nombre = ? WHERE idCSProvincia = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt  = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.setInt(2, entity.getIdCSProvincia());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean csDelete(Integer id) throws Exception {
        String query = " UPDATE CSProvincia SET Estado = ? WHERE idCSProvincia = ?";
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
    public CSProvinciaDto readBy(Integer id) throws Exception {
        CSProvinciaDto csDto = new CSProvinciaDto(); 
        String query = "SELECT idCSProvincia"
                     +",Nombre"
                     +",idCSRegion"
                     +",Estado"
                     +",FechaCreacion"
                     +"FROM CSProvincia "
                     +"WHERE Estado  = 'A' AND idCSProvincia = " + id.toString();
        try {
            Connection csCon = CSopenConnection();
            Statement csStm = csCon.createStatement();
            ResultSet csRs =  csStm.executeQuery(query);
            while (csRs.next()) {
                    csDto = new CSProvinciaDto(
                    csRs.getInt(1),
                    csRs.getString(2),
                    csRs.getInt(3),
                    csRs.getString(4),
                    csRs.getString(5)
                );
            }

        } catch (SQLException e) {
           throw e ;
        }
        return csDto;

    }

}
