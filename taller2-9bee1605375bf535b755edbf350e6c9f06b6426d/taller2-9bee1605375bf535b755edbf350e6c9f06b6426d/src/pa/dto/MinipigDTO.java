package pa.dto;

/**
 * DTO utilizado para transportar los datos de un Minipig
 * entre la capa DAO, control y vista.
 */
public class MinipigDTO {

    private String codigo;
    private String nombre;
    private String genero;
    private String idMicrochip;
    private String raza;
    private String color;
    private double peso;
    private String altura;
    private String caracteristica1;
    private String caracteristica2;
    private String urlFoto;

    public MinipigDTO() {
    }

    public MinipigDTO(String codigo, String nombre, String genero, String idMicrochip,
                      String raza, String color, double peso, String altura,
                      String caracteristica1, String caracteristica2, String urlFoto) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.idMicrochip = idMicrochip;
        this.raza = raza;
        this.color = color;
        this.peso = peso;
        this.altura = altura;
        this.caracteristica1 = caracteristica1;
        this.caracteristica2 = caracteristica2;
        this.urlFoto = urlFoto;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getIdMicrochip() { return idMicrochip; }
    public void setIdMicrochip(String idMicrochip) { this.idMicrochip = idMicrochip; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getAltura() { return altura; }
    public void setAltura(String altura) { this.altura = altura; }

    public String getCaracteristica1() { return caracteristica1; }
    public void setCaracteristica1(String caracteristica1) { this.caracteristica1 = caracteristica1; }

    public String getCaracteristica2() { return caracteristica2; }
    public void setCaracteristica2(String caracteristica2) { this.caracteristica2 = caracteristica2; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }
}