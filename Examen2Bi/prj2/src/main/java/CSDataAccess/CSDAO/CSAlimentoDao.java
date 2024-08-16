package CSDataAccess.CSDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CSDataAccess.CSDTO.CSAlimentoDto;

public class CSAlimentoDao extends CSDataHelper implements CSIDao <CSAlimentoDto>{
    


    @Override
    public Boolean csCreate(CSAlimentoDto entity) throws Exception {
        String query = " INSERT INTO CSAlimento (idCSTipoAlimento,Nombre) VALUES (?,?)";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt = csCon.prepareStatement(query);
            csPstmt.setInt(1, entity.getIdCSTipoAlimento());    
            csPstmt.setString(2, entity.getNombre());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  
        }
    }

    @Override
    public List<CSAlimentoDto> csReadAll() throws Exception {
        List<CSAlimentoDto> csLst = new ArrayList<>();
        String query = " SELECT   idCSAlimento   "
                        +",idCSTipoAlimento       "
                        +",Nombre                 "     
                        +",Estado                "     
                        +",FechaCreacion         "     
                        +"FROM CSAlimento        "
                        +"WHERE Estado = 'A'     "   ;
        try {
            Connection csCon = CSopenConnection();
            Statement csStmt = csCon.createStatement();
            ResultSet csRs = csStmt.executeQuery(query);
            while (csRs.next()) {
                CSAlimentoDto   csPdto = new CSAlimentoDto( 
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
    public boolean csUpdate(CSAlimentoDto entity) throws Exception {
        String query = "UPDATE CSAlimento SET Nombre = ? WHERE idCSAlimento = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csPstmt  = csCon.prepareStatement(query);
            csPstmt.setInt(1, entity.getIdCSAlimento());
            csPstmt.setString(2, entity.getNombre());
            csPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean csDelete(Integer id) throws Exception {
        String query = " UPDATE CSAlimento SET Estado = ? WHERE idCSAlimento = ?";
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
    public CSAlimentoDto readBy(Integer id) throws Exception {
        CSAlimentoDto csDto = new CSAlimentoDto(); 
        String query ="SELECT idCSTipoAlimento,Nombre,Estado,FechaCreacion FROM CSAlimento WHERE Estado  LIKE 'A' AND idCSAlimento =?  ;";
        try {
            Connection csCon = CSopenConnection();
            Statement csStm = csCon.createStatement();
            ResultSet csRs =  csStm.executeQuery(query);
            while (csRs.next()) {
                    csDto = new CSAlimentoDto(
                    csRs.getInt(1),
                    csRs.getInt(2),
                    csRs.getString(3),
                    "A",
                    csRs.getString(4)

                );
            }

        } catch (SQLException e) {
           throw e ;
        }
        return csDto;
    }

}
