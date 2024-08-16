package CSDataAccess.CSDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CSDataAccess.CSDTO.CSSexoDto;

public class CSSexoDao extends CSDataHelper implements CSIDao<CSSexoDto> {
   
    @Override
    public Boolean csCreate(CSSexoDto entity) throws Exception {
        String query = " INSERT INTO CSSexo (Nombre) VALUES (?)";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  
        }
    }

    @Override
    public List<CSSexoDto> csReadAll() throws Exception {
        List<CSSexoDto> csLst = new ArrayList<>();
        String query = " SELECT   idCSSexo       "
                        +"Nombre                 "     
                        +",Estado                "     
                        +",FechaCreacion         "     
                        +"FROM CSSexo            "
                        +"WHERE Estado = 'A'     "   ;
        try {
            Connection csCon = CSopenConnection();
            Statement csStmt = csCon.createStatement();
            ResultSet csRs = csStmt.executeQuery(query);
            while (csRs.next()) {
                CSSexoDto   csPdto = new CSSexoDto( 
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
    public boolean csUpdate(CSSexoDto entity) throws Exception {
        String query = "UPDATE CSSexo SET Nombre = ? WHERE idCSSexo = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt  = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.setInt(2, entity.getIdCSSexo());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
    }
    }
    
    @Override
    public boolean csDelete(Integer id) throws Exception {
        String query = " UPDATE CSSexo SET Estado = ? WHERE idCSSexo = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement  csPstmt = csCon.prepareStatement(query);
            csPstmt.setString(1, "X");
            csPstmt.setInt(2, id);
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e ;
    }
}

    @Override
    public CSSexoDto readBy(Integer id) throws Exception {
        CSSexoDto csDto = new CSSexoDto(); 
        String query = "SELECT idCSSexo"
                     +",Nombre"
                     +",Estado"
                     +",FechaCreacion"
                     +"FROM CSSexo "
                     +"WHERE Estado  = 'A' AND idCSSexo = " + id.toString();
        try {
            Connection csCon = CSopenConnection();
            Statement csStm = csCon.createStatement();
            ResultSet csRs =  csStm.executeQuery(query);
            while (csRs.next()) {
                csDto = new CSSexoDto(
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
