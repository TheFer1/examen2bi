package CSDataAccess.CSDTO;

public class CSRegionDto {
    private Integer idCSRegion;  
    private Integer idCSPais;
    private String  Nombre;       
    private String Estado;         
    private String FechaCreacion;

    
    public CSRegionDto() {
    }
    public CSRegionDto(Integer idCSRegion, Integer idCSPais, String nombre, String estado, String fechaCreacion) {
        this.idCSRegion = idCSRegion;
        this.idCSPais = idCSPais;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
    }
    public Integer getIdCSRegion() {
        return idCSRegion;
    }
    public void setIdCSRegion(Integer idCSRegion) {
        this.idCSRegion = idCSRegion;
    }
    public Integer getIdCSPais() {
        return idCSPais;
    }
    public void setIdCSPais(Integer idCSPais) {
        this.idCSPais = idCSPais;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
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
    public String toString(){
        return  "  \n" + getClass().getName()
                + "\n idCSRegion       "+ getIdCSRegion()
                + "\n idCSPais       "+ getIdCSPais()
                + "\n Nombre "        + getNombre()
                + "\n Estado         "+ getEstado()
                + "\n FechaCreacion  "+ getFechaCreacion();
    }

}
