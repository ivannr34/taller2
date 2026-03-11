
package pa.dao;

import pa.dto.MinipigDTO;
import pa.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del patrón DAO para la entidad Minipig.
 * Maneja todas las operaciones SQL.
 */
public class MinipigDAOImpl implements MinipigDAO {

    private Connection conexion;

    public MinipigDAOImpl() {
        try {
            conexion = ConexionBD.getInstancia().getConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(MinipigDTO minipig) {

        String sql = "INSERT INTO minipig VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, minipig.getCodigo());
            ps.setString(2, minipig.getNombre());
            ps.setString(3, minipig.getGenero());
            ps.setString(4, minipig.getIdMicrochip());
            ps.setString(5, minipig.getRaza());
            ps.setString(6, minipig.getColor());
            ps.setDouble(7, minipig.getPeso());
            ps.setDouble(8, minipig.getAltura());
            ps.setString(9, minipig.getCaracteristica1());
            ps.setString(10, minipig.getCaracteristica2());
            ps.setString(11, minipig.getUrlFoto());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MinipigDTO consultarPorCodigo(String codigo) {

        String sql = "SELECT * FROM minipig WHERE codigo=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new MinipigDTO(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("genero"),
                        rs.getString("idMicrochip"),
                        rs.getString("raza"),
                        rs.getString("color"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        rs.getString("caracteristica1"),
                        rs.getString("caracteristica2"),
                        rs.getString("urlFoto")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<MinipigDTO> obtenerTodos() {

        List<MinipigDTO> lista = new ArrayList<>();

        String sql = "SELECT * FROM minipig";

        try (Statement st = conexion.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                MinipigDTO m = new MinipigDTO(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("genero"),
                        rs.getString("idMicrochip"),
                        rs.getString("raza"),
                        rs.getString("color"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        rs.getString("caracteristica1"),
                        rs.getString("caracteristica2"),
                        rs.getString("urlFoto")
                );

                lista.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {

        String sql = "DELETE FROM minipig WHERE codigo=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(MinipigDTO minipig) {

        String sql = "UPDATE minipig SET nombre=?, genero=?, raza=?, color=?, peso=?, altura=?, caracteristica1=?, caracteristica2=?, urlFoto=? WHERE codigo=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, minipig.getNombre());
            ps.setString(2, minipig.getGenero());
            ps.setString(3, minipig.getRaza());
            ps.setString(4, minipig.getColor());
            ps.setDouble(5, minipig.getPeso());
            ps.setDouble(6, minipig.getAltura());
            ps.setString(7, minipig.getCaracteristica1());
            ps.setString(8, minipig.getCaracteristica2());
            ps.setString(9, minipig.getUrlFoto());
            ps.setString(10, minipig.getCodigo());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MinipigDTO consultarPorMicrochip(String microchip) {
        return null;
    }

    @Override
    public List<MinipigDTO> consultarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<MinipigDTO> consultarPorRaza(String raza) {
        return null;
    }

    @Override
    public void eliminarPorMicrochip(String microchip) {
    }
}