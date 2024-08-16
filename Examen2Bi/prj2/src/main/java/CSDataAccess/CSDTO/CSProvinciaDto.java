package CSDataAccess.CSDTO;

public class CSProvinciaDto {
    private Integer idCSProvincia;
    private String Nombre;
    private Integer idCSRegion;
    private String Estado;
    private String FechaCreacion;




    public CSProvinciaDto() {
    }

    public CSProvinciaDto(Integer idCSProvincia, String nombre, Integer idCSRegion, String estado,
            String fechaCreacion) {
        this.idCSProvincia = idCSProvincia;
        this.Nombre = nombre;
        this.idCSRegion = idCSRegion;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
    }

    public Integer getIdCSProvincia() {
        return idCSProvincia;
    }

    public void setIdCSProvincia(Integer idCSProvincia) {
        this.idCSProvincia = idCSProvincia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getIdCSRegion() {
        return idCSRegion;
    }

    public void setIdCSRegion(Integer idCSRegion) {
        this.idCSRegion = idCSRegion;
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
                + "\n idCSProvincia"     + getIdCSProvincia()
                + "\n Nombre"             + getNombre()
                + "\n idCSRegion"        + getIdCSRegion()
                + "\n Estado"           + getEstado()
                + "\n FechaCreacion"    + getFechaCreacion();
    }
}
