/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.control;


import pa.dao.MinipigDAO;
import pa.dao.MinipigDAOImpl;
import pa.dto.MinipigDTO;
import pa.modelo.Minipig;

import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con Minipig.
 * 
 * Esta clase actúa como intermediaria entre la Vista y el DAO, aplicando el
 * patrón MVC y respetando el principio de separación de responsabilidades.
 * 
 * Responsabilidades:
 * - Recibir solicitudes desde la vista
 * - Invocar las operaciones correspondientes en el DAO
 * - Manejar objetos DTO durante procesos de modificación
 */
    public class ControlMinipig {

    private MinipigDAO dao;

    /**
     * Constructor del controlador.
     * Inicializa la implementación del DAO que se utilizará
     * para interactuar con la base de datos.
     */
    public ControlMinipig() {
        dao = new MinipigDAOImpl();
    }

    /**
     * Inserta un nuevo Minipig en la base de datos.
     * 
     * @param minipig objeto DTO con la información del minipig
     */
    public void insertarMinipig(MinipigDTO minipig) {
        dao.insertar(minipig);
    }

    /**
     * Consulta un Minipig a partir de su código.
     * 
     * @param codigo código del minipig
     * @return objeto MinipigDTO encontrado
     */
    public MinipigDTO consultarPorCodigo(String codigo) {
        return dao.consultarPorCodigo(codigo);
    }

    /**
     * Consulta un Minipig utilizando el id del microchip.
     * 
     * @param microchip identificador del microchip
     * @return objeto MinipigDTO encontrado
     */
    public MinipigDTO consultarPorMicrochip(String microchip) {
        return dao.consultarPorMicrochip(microchip);
    }

    /**
     * Consulta los minipigs registrados que coincidan con un nombre.
     * 
     * @param nombre nombre del minipig
     * @return lista de MinipigDTO encontrados
     */
    public List<MinipigDTO> consultarPorNombre(String nombre) {
        return dao.consultarPorNombre(nombre);
    }

    /**
     * Consulta los minipigs registrados según una raza.
     * 
     * @param raza raza del minipig
     * @return lista de MinipigDTO encontrados
     */
    public List<MinipigDTO> consultarPorRaza(String raza) {
        return dao.consultarPorRaza(raza);
    }

    /**
     * Obtiene todos los minipigs almacenados en la base de datos.
     * 
     * @return lista con todos los minipigs registrados
     */
    public List<MinipigDTO> obtenerTodos() {
        return dao.obtenerTodos();
    }

    /**
     * Elimina un minipig utilizando su código.
     * 
     * @param codigo código del minipig
     */
    public void eliminarPorCodigo(String codigo) {
        dao.eliminarPorCodigo(codigo);
    }

    /**
     * Elimina un minipig utilizando el id de su microchip.
     * 
     * @param microchip identificador del microchip
     */
    public void eliminarPorMicrochip(String microchip) {
        dao.eliminarPorMicrochip(microchip);
    }

    /**
     * Actualiza la información de un minipig existente.
     * 
     * @param minipig objeto DTO con los datos actualizados
     */
    public void actualizarMinipig(MinipigDTO minipig) {
        dao.actualizar(minipig);
    }
}