package CSDataAccess.CSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import CSDataAccess.CSDTO.CSHormigaDto;

public class CSHormigaDao extends CSDataHelper implements CSIDao<CSHormigaDto> {

    @Override
    public Boolean csCreate(CSHormigaDto entity) throws Exception {
        String query = "INSERT INTO CSHormiga" +
                "(TipoHormiga, idCSSexo, idCSProvincia, idGenoAlimento, idIngestaNativa) VALUES" +
                "(?, ?, ?, ?, ?)";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csStam = csCon.prepareStatement(query);
            csStam.setString(1, entity.getTipoHormiga());
            csStam.setInt(2, entity.getIdCSSexo());
            csStam.setInt(3, entity.getIdCSProvincia());
            csStam.setInt(4, entity.getIdGenoAlimento());
            csStam.setInt(5, entity.getIdIngestaNativa());
            csStam.executeQuery(); 
            return true;
        } catch (SQLException e) {
            throw e ;
        }
    }

    @Override
    public List<CSHormigaDto> csReadAll() throws Exception {
        String query = "SELECT "
        +" H.idCSHormiga,"
        + "H.TipoHormiga, "
        + "S.Nombre , "
        + "P.Nombre , "
        + "G.Nombre , "
        + "I.Nombre , "
        + "H.FechaCreacion "
        + "FROM "
        + "CSHormiga H "
        + "JOIN CSSexo S ON H.idCSSexo = S.idCSSexo "
        + "JOIN CSProvincia P ON H.idCSProvincia = P.idCSProvincia "
        + "JOIN CSAlimento G ON H.idGenoAlimento = G.idCSAlimento "
        + "JOIN CSAlimento I ON H.idIngestaNativa = I.idCSAlimento "
        + "WHERE "
        + "H.Estado = 'A' "
        + "AND S.Estado = 'A' "
        + "AND P.Estado = 'A' "
        + "AND G.Estado = 'A' "
        + "AND I.Estado = 'A' ";
        List<CSHormigaDto> csList = new ArrayList<>();
        try {
            Connection csCon = CSopenConnection();
            Statement csTmt = csCon.createStatement();
            ResultSet csRest = csTmt.executeQuery(query);
            while (csRest.next()) {
                        CSHormigaDto csDto = new CSHormigaDto(
                            csRest.getInt(1), // TipoHormiga
                            csRest.getString(2), // NombreSexo
                            csRest.getString(3), // NombreProvincia
                            csRest.getString(4), // NombreGenoAlimento
                            csRest.getString(5), // NombreIngestaNativa
                            csRest.getString(6), // NombreIngestaNativa
                            "A", // Estado, asumiendo que el estado 'A' es por defecto o calculado en la lógica
                            csRest.getString(7)); // FechaCreacion
                    csList.add(csDto);
            }
        } catch (Exception e) {
            throw e ; 
        }
       return csList; 
    }

    @Override
    public boolean csUpdate(CSHormigaDto entity) throws Exception {
        String query = "UPDATE CSProvincia " +
                        "SET Nombre = ? " +
                        "WHERE idCSProvincia = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csStatement = csCon.prepareStatement(query);
            csStatement.setInt(1, entity.getIdCSProvincia());
            csStatement.setInt(2, entity.getIdCSHormiga());
            csStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean csDelete(Integer id) throws Exception {
        String query = "UPDATE CSHormiga " +
        "SET Estado = ? " +
        "WHERE idCSHormiga = ?;";
try {
    Connection csCon = CSopenConnection();
    PreparedStatement AJpstmt = csCon.prepareStatement(query);
    AJpstmt.setString(1, "X");
    AJpstmt.setInt(2, id);
    AJpstmt.executeQuery();
    return true;
} catch (SQLException e) {
    throw e;
}
    }

    @Override
    public CSHormigaDto readBy(Integer id) throws Exception {
        CSHormigaDto dto = new CSHormigaDto();
        String query = "SELECT "
        + "H.TipoHormiga, "
        + "S.Nombre , "
        + "P.Nombre , "
        + "G.Nombre , "
        + "I.Nombre , "
        + "H.FechaCreacion "
        + "FROM "
        + "CSHormiga H "
        + "JOIN CSSexo S ON H.idCSSexo = S.idCSSexo "
        + "JOIN CSProvincia P ON H.idCSProvincia = P.idCSProvincia "
        + "JOIN CSAlimento G ON H.idGenoAlimento = G.idCSAlimento "
        + "JOIN CSAlimento I ON H.idIngestaNativa = I.idCSAlimento "
        + "WHERE "
        + "H.Estado = 'A' "
        + "AND S.Estado = 'A' "
        + "AND P.Estado = 'A' "
        + "AND G.Estado = 'A' "
        + "AND I.Estado = 'A' "
        + "AND H.idCSHormiga =" + id;  // Parámetro del ID

  // Inicializa a null en caso de que no se encuentre el registro
    try {
        // Abrir conexión
        Connection csCon = CSopenConnection();
        
        // Crear el PreparedStatement
        PreparedStatement csStmt = csCon.prepareStatement(query);
        
        // Ejecutar la consulta
        ResultSet csRs = csStmt.executeQuery();
        
        // Procesar los resultados
        if (csRs.next()) {
            dto = new CSHormigaDto(
                csRs.getString(1), // TipoHormiga
                csRs.getString(2), // NombreSexo
                csRs.getString(3), // NombreProvincia
                csRs.getString(4), // NombreGenoAlimento
                csRs.getString(5), // NombreIngestaNativa
                "A", // Estado, asumiendo que el estado 'A' es por defecto o calculado en la lógica
                csRs.getString(6) // FechaCreacion
                );
                System.out.println("Resultset");
                System.out.println(csRs.getString(1));
                System.out.println(csRs.getString(2));
                System.out.println(csRs.getString(3));
                System.out.println(csRs.getString(4));
                System.out.println(csRs.getString(5));
                System.out.println(csRs.getString(6));
    
        } else {
            // Manejar el caso en que no se encuentra el dato, opcional
            throw new Exception("No se encontraron datos para el ID proporcionado.");
        }
        
    } catch (SQLException e) {
        throw new Exception(e.getMessage(), e);
    }
    return dto;

}
}
