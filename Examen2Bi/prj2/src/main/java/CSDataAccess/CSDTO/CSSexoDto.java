package CSDataAccess.CSDTO;

public class CSSexoDto {
private Integer   idCSSexo        ;
private String   Nombre           ;
private String   Estado           ;
private String   FechaCreacion    ;
public CSSexoDto() {
}
public CSSexoDto(Integer idCSSexo, String nombre, String estado, String fechaCreacion) {
    this.idCSSexo = idCSSexo;
    this.Nombre = nombre;
    this.Estado = estado;
    this.FechaCreacion = fechaCreacion;
}
public Integer getIdCSSexo() {
    return idCSSexo;
}
public void setIdCSSexo(Integer idCSSexo) {
    this.idCSSexo = idCSSexo;
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
            + "\n idCSSexo"     + getIdCSSexo()
            + "\n Nombre"            + getNombre()
            + "\n Estado"           + getEstado()
            + "\n FechaCreacion"     + getFechaCreacion();
}
}
