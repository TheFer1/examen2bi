package CSDataAccess.CSDTO;

public class CSAlimentoDto {
   private Integer idCSAlimento     ; 
   private Integer idCSTipoAlimento ; 
   private String Nombre            ;
   private String Estado            ;
   private String FechaCreacion     ;
   public CSAlimentoDto() {
   }
   public CSAlimentoDto(Integer idCSAlimento, Integer idCSTipoAlimento, String nombre, String estado,
           String fechaCreacion) {
       this.idCSAlimento = idCSAlimento;
       this.idCSTipoAlimento = idCSTipoAlimento;
       this.Nombre = nombre;
       this.Estado = estado;
       this.FechaCreacion = fechaCreacion;
   }
public Integer getIdCSAlimento() {
    return idCSAlimento;
}
public void setIdCSAlimento(Integer idCSAlimento) {
    this.idCSAlimento = idCSAlimento;
}
public Integer getIdCSTipoAlimento() {
    return idCSTipoAlimento;
}
public void setIdCSTipoAlimento(Integer idCSTipoAlimento) {
    this.idCSTipoAlimento = idCSTipoAlimento;
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
            + "\n idCSAlimento"     + getIdCSAlimento()
            + "\n idCSTipoAlimento" + getIdCSTipoAlimento()
            + "\n Nombre"            + getNombre()
            + "\n Estado"           + getEstado()
            + "\n FechaCreacion"     + getFechaCreacion();
}

}
