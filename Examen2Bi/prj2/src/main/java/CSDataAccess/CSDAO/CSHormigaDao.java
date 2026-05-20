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
        String query = "INSERT INTO CSHormiga (TipoHormiga, idCSSexo, idCSProvincia, idGenoAlimento, idIngestaNativa, Estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection csCon = CSopenConnection();
             PreparedStatement csStam = csCon.prepareStatement(query)) {
            csStam.setString(1, entity.getTipoHormiga());
            csStam.setInt(2, entity.getIdCSSexo());
            csStam.setInt(3, entity.getIdCSProvincia());
            if (entity.getIdGenoAlimento() != null) {
                csStam.setInt(4, entity.getIdGenoAlimento());
            } else {
                csStam.setNull(4, java.sql.Types.INTEGER);
            }
            if (entity.getIdIngestaNativa() != null) {
                csStam.setInt(5, entity.getIdIngestaNativa());
            } else {
                csStam.setNull(5, java.sql.Types.INTEGER);
            }
            csStam.setString(6, entity.getEstado());
            csStam.executeUpdate(); // Use executeUpdate() for insert operations
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al crear hormiga: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CSHormigaDto> csReadAll() throws Exception {
        String query = "SELECT "
        +" H.idCSHormiga,"
        + "H.TipoHormiga, "
        + "S.Nombre , "
        + "P.Nombre , "
        + "IFNULL(G.Nombre, 'Ninguno') , "
        + "IFNULL(I.Nombre, 'Ninguno') , "
        + "H.FechaCreacion, "
        + "H.Estado  "
        + "FROM "
        + "CSHormiga H "
        + "LEFT JOIN CSSexo S ON H.idCSSexo = S.idCSSexo "
        + "LEFT JOIN CSProvincia P ON H.idCSProvincia = P.idCSProvincia "
        + "LEFT JOIN CSAlimento G ON H.idGenoAlimento = G.idCSAlimento "
        + "LEFT JOIN CSAlimento I ON H.idIngestaNativa = I.idCSAlimento "
        + "WHERE H.Estado = 'VIVA'";
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
        String query = "UPDATE CSHormiga " +
                        "SET TipoHormiga = ?, idGenoAlimento = ?, idIngestaNativa = ? " +
                        "WHERE idCSHormiga = ?";
        try {
            Connection csCon = CSopenConnection();
            PreparedStatement csStatement = csCon.prepareStatement(query);
            csStatement.setString(1, entity.getTipoHormiga() != null ? entity.getTipoHormiga() : "Larva");
            if (entity.getIdGenoAlimento() != null && entity.getIdGenoAlimento() > 0) {
                csStatement.setInt(2, entity.getIdGenoAlimento());
            } else {
                csStatement.setNull(2, java.sql.Types.INTEGER);
            }
            if (entity.getIdIngestaNativa() != null && entity.getIdIngestaNativa() > 0) {
                csStatement.setInt(3, entity.getIdIngestaNativa());
            } else {
                csStatement.setNull(3, java.sql.Types.INTEGER);
            }
            csStatement.setInt(4, entity.getIdCSHormiga());
            int rowsUpdated = csStatement.executeUpdate();
            return rowsUpdated > 0;
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
        + "IFNULL(G.Nombre, 'Ninguno') , "
        + "IFNULL(I.Nombre, 'Ninguno') , "
        +"H.FechaCreacion,  "
        + "H.Estado "
        + "FROM "
        + "CSHormiga H "
        + "LEFT JOIN CSSexo S ON H.idCSSexo = S.idCSSexo "
        + "LEFT JOIN CSProvincia P ON H.idCSProvincia = P.idCSProvincia "
        + "LEFT JOIN CSAlimento G ON H.idGenoAlimento = G.idCSAlimento "
        + "LEFT JOIN CSAlimento I ON H.idIngestaNativa = I.idCSAlimento "
        + "WHERE "
        + "H.Estado = 'VIVA' "
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
