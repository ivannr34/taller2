
package pa.dao;

import java.util.List;
import pa.dto.MinipigDTO;

/**
 * Interfaz que define las operaciones de acceso a datos
 * para los objetos Minipig.
 */
public interface MinipigDAO {

    void insertar(MinipigDTO minipig);

    MinipigDTO consultarPorCodigo(String codigo);

    MinipigDTO consultarPorMicrochip(String microchip);

    List<MinipigDTO> consultarPorNombre(String nombre);

    List<MinipigDTO> consultarPorRaza(String raza);

    List<MinipigDTO> obtenerTodos();

    void eliminarPorCodigo(String codigo);

    void eliminarPorMicrochip(String microchip);

    void actualizar(MinipigDTO minipig);
}