package CSDataAccess.CSDTO;

public class CSHormigaDto {

    private Integer idCSHormiga;
    private String TipoHormiga;
    private Integer idCSSexo;
    private String NombreSexo;
    private String NombreProvincia;
    private String NombreGenoAlimento;
    private String NombreIngestaNativa;
    private Integer idCSProvincia;
    private Integer idGenoAlimento;
    private Integer idIngestaNativa;
    private String Estado;
    private String FechaCreacion;

    

    public CSHormigaDto(String tipoHormiga, String nombreSexo, String nombreProvincia, String nombreGenoAlimento,
            String nombreIngestaNativa, String fechaCreacion) {
        TipoHormiga = tipoHormiga;
        NombreSexo = nombreSexo;
        NombreProvincia = nombreProvincia;
        NombreGenoAlimento = nombreGenoAlimento;
        NombreIngestaNativa = nombreIngestaNativa;
        FechaCreacion = fechaCreacion;
    }

    public String getNombreSexo() {
        return NombreSexo;
    }

    public void setNombreSexo(String nombreSexo) {
        NombreSexo = nombreSexo;
    }

    public String getNombreProvincia() {
        return NombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        NombreProvincia = nombreProvincia;
    }

    public String getNombreGenoAlimento() {
        return NombreGenoAlimento;
    }

    public void setNombreGenoAlimento(String nombreGenoAlimento) {
        NombreGenoAlimento = nombreGenoAlimento;
    }

    public String getNombreIngestaNativa() {
        return NombreIngestaNativa;
    }

    public void setNombreIngestaNativa(String nombreIngestaNativa) {
        NombreIngestaNativa = nombreIngestaNativa;
    }

    public CSHormigaDto(Integer idCSHormiga, String tipoHormiga, Integer idCSSexo, Integer idCSProvincia,
            Integer idGenoAlimento, Integer idIngestaNativa, String estado, String fechaCreacion) {
        this.idCSHormiga = idCSHormiga;
        TipoHormiga = tipoHormiga;
        this.idCSSexo = idCSSexo;
        this.idCSProvincia = idCSProvincia;
        this.idGenoAlimento = idGenoAlimento;
        this.idIngestaNativa = idIngestaNativa;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public CSHormigaDto(String tipoHormiga, String nombreSexo, String nombreProvincia,
            String nombreGenoAlimento, String nombreIngestaNativa, String estado, String fechaCreacion) {
        TipoHormiga = tipoHormiga;
        NombreSexo = nombreSexo;
        NombreProvincia = nombreProvincia;
        NombreGenoAlimento = nombreGenoAlimento;
        NombreIngestaNativa = nombreIngestaNativa;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }



    public CSHormigaDto(Integer idCSHormiga, String tipoHormiga, String nombreSexo,
            String nombreProvincia, String nombreGenoAlimento,
            String nombreIngestaNativa, String estado, String fechaCreacion) {
        this.idCSHormiga = idCSHormiga;
        this.TipoHormiga = tipoHormiga;
        this.NombreSexo = nombreSexo;
        this.NombreProvincia = nombreProvincia;
        this.NombreGenoAlimento = nombreGenoAlimento;
        this.NombreIngestaNativa = nombreIngestaNativa;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
    }

    public CSHormigaDto() {
    }

    public Integer getIdCSHormiga() {
        return idCSHormiga;
    }

    public void setIdCSHormiga(Integer idCSHormiga) {
        this.idCSHormiga = idCSHormiga;
    }

    public String getTipoHormiga() {
        return TipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        TipoHormiga = tipoHormiga;
    }

    public Integer getIdCSSexo() {
        return idCSSexo;
    }

    public void setIdCSSexo(Integer idCSSexo) {
        this.idCSSexo = idCSSexo;
    }

    public Integer getIdCSProvincia() {
        return idCSProvincia;
    }

    public void setIdCSProvincia(Integer idCSProvincia) {
        this.idCSProvincia = idCSProvincia;
    }

    public Integer getIdGenoAlimento() {
        return idGenoAlimento;
    }

    public void setIdGenoAlimento(Integer idGenoAlimento) {
        this.idGenoAlimento = idGenoAlimento;
    }

    public Integer getIdIngestaNativa() {
        return idIngestaNativa;
    }

    public void setIdIngestaNativa(Integer idIngestaNativa) {
        this.idIngestaNativa = idIngestaNativa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "  \n" + getClass().getName()
                + "\n idCSHormiga" + getIdCSHormiga()
                + "\n TipoHormiga" + getTipoHormiga()
                + "\n idCSSexo" + getNombreSexo()
                + "\n idCSProvincia" + getNombreProvincia()
                + "\n idGenoAlimento" + getNombreGenoAlimento()
                + "\n idIngestaNativa" + getNombreIngestaNativa()
                + "\n Estado" + getEstado()
                + "\n FechaCreacion" + getFechaCreacion();
    }

}
