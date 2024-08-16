package CSDataAccess.CSDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CSDataAccess.CSDTO.CSRegionDto;

public class CSRegionDao extends CSDataHelper implements CSIDao<CSRegionDto> {

    @Override
    public Boolean csCreate(CSRegionDto entity) throws Exception {
        String query = " INSERT INTO CSRegion (idCSPais,Nombre) VALUES (?,?)";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt = csCon.prepareStatement(query);
            csPstmt.setInt(1, entity.getIdCSPais());
            csPstmt.setString(2, entity.getNombre());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  
        }
    }

    @Override
    public List<CSRegionDto> csReadAll() throws Exception {
       List<CSRegionDto> csLst = new ArrayList<>();
        String query = " SELECT   idCSRegion     "
                        +",idCSPais              "     
                        +",Nombre                "   
                        +",Estado                "     
                        +",FechaCreacion         "     
                        +"FROM CSRegion          "
                        +"WHERE Estado = 'A'     "   ;
        try {
            Connection csCon = CSopenConnection();
            Statement csStmt = csCon.createStatement();
            ResultSet csRs = csStmt.executeQuery(query);
            while (csRs.next()) {
                CSRegionDto  csPdto = new CSRegionDto( 
                                csRs.getInt(1),
                                csRs.getInt(2),
                                csRs.getString(3),
                                csRs.getString(4),
                                csRs.getString(5));
                                csLst.add(csPdto);
            }
        } catch (Exception e) {
        }  
        return csLst ; 
    }

    @Override
    public boolean csUpdate(CSRegionDto entity) throws Exception {
        String query = "UPDATE CSRegion SET Nombre = ? WHERE idCSRegion = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt  = csCon.prepareStatement(query);
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
    public boolean csDelete(Integer id) throws Exception {
        String query = " UPDATE CSRegion SET Estado = ? WHERE idCSRegion = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement  csPstmt = csCon.prepareStatement(query);
            csPstmt.setString(1, "X");
            csPstmt.setInt(2, id);
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
        
    }

    @Override
    public CSRegionDto readBy(Integer id) throws Exception {
        CSRegionDto csDto = new CSRegionDto(); 
        String query = "SELECT idCSRegion"
                     +"idCSPais"
                     +",Nombre"
                     +",Estado"
                     +",FechaCreacion"
                     +"FROM CSRegion "
                     +"WHERE Estado  = 'A' AND idCSRegion = " + id.toString();
        try {
            Connection csCon = CSopenConnection();
            Statement csStm = csCon.createStatement();
            ResultSet csRs =  csStm.executeQuery(query);
            while (csRs.next()) {
                csDto = new CSRegionDto(
                    csRs.getInt(1),
                    csRs.getInt(2),
                    csRs.getString(3),
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
