package CSDataAccess.CSDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CSDataAccess.CSDTO.CSTipoAlimentoDto;

public class CSTipoAlimentoDao extends CSDataHelper implements CSIDao<CSTipoAlimentoDto> {

    @Override
    public Boolean csCreate(CSTipoAlimentoDto entity) throws Exception {
        String query = " INSERT INTO CSTipoAlimento (Nombre) VALUES (?)";
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
    public List<CSTipoAlimentoDto> csReadAll() throws Exception {
        List<CSTipoAlimentoDto> csLst = new ArrayList<>();
        String query = " SELECT   idCSTipoAlimento       "
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
            CSTipoAlimentoDto   csPdto = new CSTipoAlimentoDto( 
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
    public boolean csUpdate(CSTipoAlimentoDto entity) throws Exception {
        String query = "UPDATE CSTipoAlimento SET Nombre = ? WHERE idCSTipoAlimento = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt  = csCon.prepareStatement(query);
            csPstmt.setString(1, entity.getNombre());
            csPstmt.setInt(2, entity.getIdCSTipoAlimento());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
      
    }

    @Override
    public boolean csDelete(Integer id) throws Exception {
        String query = " UPDATE CSTipoAlimento SET Estado = ? WHERE idCSTipoAlimento = ?";
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
    public CSTipoAlimentoDto readBy(Integer id) throws Exception {
        CSTipoAlimentoDto csDto = new CSTipoAlimentoDto(); 
        String query = "SELECT idCSTipoAlimento"
                     +",Nombre"
                     +",Estado"
                     +",FechaCreacion"
                     +"FROM CSTipoAlimento "
                     +"WHERE Estado  = 'A' AND idCSTipoAlimento = " + id.toString();
        try {
            Connection csCon = CSopenConnection();
            Statement csStm = csCon.createStatement();
            ResultSet csRs =  csStm.executeQuery(query);
            while (csRs.next()) {
                csDto = new CSTipoAlimentoDto(
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
