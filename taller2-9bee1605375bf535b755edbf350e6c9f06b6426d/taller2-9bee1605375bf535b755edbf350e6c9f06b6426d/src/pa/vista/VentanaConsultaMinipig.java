package pa.vista;

import javax.swing.*;
import pa.control.ControlMinipig;
import pa.dto.MinipigDTO;
import java.util.List;
import java.awt.Image;
import pa.modelo.Raza;

public class VentanaConsultaMinipig extends JFrame {

    JTextField txtCodigo;
    JTextField txtMicrochip;
    JTextField txtNombre;

    JComboBox<Raza> comboRaza;
    JComboBox<String> comboMinipigs;

    JButton btnBuscarCodigo;
    JButton btnBuscarMicrochip;
    JButton btnBuscarNombre;
    JButton btnBuscarRaza;

    JTextArea areaDatos;

    JLabel lblFoto;

    ControlMinipig control = new ControlMinipig();

    public VentanaConsultaMinipig(){

        setTitle("Consultar Minipigs");
        setSize(600,450);
        setLayout(null);
        setLocationRelativeTo(null);

        // CODIGO
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(20,20,80,20);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(100,20,120,20);
        add(txtCodigo);

        btnBuscarCodigo = new JButton("Buscar");
        btnBuscarCodigo.setBounds(230,20,100,20);
        add(btnBuscarCodigo);

        // MICROCHIP
        JLabel lblMicrochip = new JLabel("Microchip:");
        lblMicrochip.setBounds(20,60,80,20);
        add(lblMicrochip);

        txtMicrochip = new JTextField();
        txtMicrochip.setBounds(100,60,120,20);
        add(txtMicrochip);

        btnBuscarMicrochip = new JButton("Buscar");
        btnBuscarMicrochip.setBounds(230,60,100,20);
        add(btnBuscarMicrochip);

        // NOMBRE
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20,100,80,20);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100,100,120,20);
        add(txtNombre);

        btnBuscarNombre = new JButton("Buscar");
        btnBuscarNombre.setBounds(230,100,100,20);
        add(btnBuscarNombre);

        // RAZA
        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setBounds(20,140,80,20);
        add(lblRaza);

        comboRaza = new JComboBox<>(Raza.values());
        comboRaza.setBounds(100,140,120,20);
        add(comboRaza);

        btnBuscarRaza = new JButton("Buscar");
        btnBuscarRaza.setBounds(230,140,100,20);
        add(btnBuscarRaza);

        // COMBO MINIPIGS
        JLabel lblLista = new JLabel("Minipigs:");
        lblLista.setBounds(20,180,80,20);
        add(lblLista);

        comboMinipigs = new JComboBox<>();
        comboMinipigs.setBounds(100,180,200,25);
        add(comboMinipigs);

        // AREA DATOS
        areaDatos = new JTextArea();
        areaDatos.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaDatos);
        scroll.setBounds(20,220,250,170);
        add(scroll);

        // FOTO
        lblFoto = new JLabel();
        lblFoto.setBounds(350,220,200,170);
        add(lblFoto);

        // CARGAR MINIPIGS
        cargarMinipigs();

        // EVENTOS
        btnBuscarCodigo.addActionListener(e -> buscarCodigo());
        btnBuscarMicrochip.addActionListener(e -> buscarMicrochip());
        btnBuscarNombre.addActionListener(e -> buscarNombre());
        btnBuscarRaza.addActionListener(e -> buscarRaza());

        comboMinipigs.addActionListener(e -> seleccionarMinipig());
    }

    private void cargarMinipigs(){

        comboMinipigs.removeAllItems();

        List<MinipigDTO> lista = control.obtenerTodos();

        if(lista == null) return;

        for(MinipigDTO m : lista){

            comboMinipigs.addItem(m.getCodigo() + " - " + m.getNombre());

        }
    }

    private void buscarCodigo(){

        MinipigDTO m = control.consultarPorCodigo(txtCodigo.getText());

        if(m != null) mostrarDatos(m);

        else JOptionPane.showMessageDialog(this,"Minipig no encontrado");
    }

    private void buscarMicrochip(){

        MinipigDTO m = control.consultarPorMicrochip(txtMicrochip.getText());

        if(m != null) mostrarDatos(m);

        else JOptionPane.showMessageDialog(this,"Minipig no encontrado");
    }

    private void buscarNombre(){

        String nombre = txtNombre.getText();

        List<MinipigDTO> lista = control.consultarPorNombre(nombre);

        comboMinipigs.removeAllItems();

        if(lista == null || lista.isEmpty()){

            JOptionPane.showMessageDialog(this,"No se encontraron minipigs");
            return;
        }

        for(MinipigDTO m : lista){

            comboMinipigs.addItem(m.getCodigo() + " - " + m.getNombre());

        }
    }

    private void buscarRaza(){

        Raza razaSeleccionada = (Raza) comboRaza.getSelectedItem();

        String raza = razaSeleccionada.name();

        List<MinipigDTO> lista = control.consultarPorRaza(raza);

        comboMinipigs.removeAllItems();

        if(lista == null || lista.isEmpty()){

            JOptionPane.showMessageDialog(this,"No hay minipigs de esa raza");
            return;
        }

        for(MinipigDTO m : lista){

            comboMinipigs.addItem(m.getCodigo() + " - " + m.getNombre());

        }
    }

    private void seleccionarMinipig(){

        if(comboMinipigs.getSelectedItem()==null) return;

        String texto = comboMinipigs.getSelectedItem().toString();

        String codigo = texto.split(" - ")[0];

        MinipigDTO m = control.consultarPorCodigo(codigo);

        if(m != null){

            mostrarDatos(m);

        }
    }

    private void mostrarLista(List<MinipigDTO> lista){

        areaDatos.setText("");

        if(lista == null || lista.isEmpty()){

            areaDatos.setText("No se encontraron minipigs");
            return;
        }

        for(MinipigDTO m : lista){

            areaDatos.append(
                    "Codigo: " + m.getCodigo() +
                    " | Nombre: " + m.getNombre() +
                    " | Raza: " + m.getRaza() + "\n"
            );
        }
    }

    private void mostrarDatos(MinipigDTO m){

        areaDatos.setText(
                "Codigo: " + m.getCodigo() + "\n" +
                "Nombre: " + m.getNombre() + "\n" +
                "Microchip: " + m.getIdMicrochip() + "\n" +
                "Genero: " + m.getGenero() + "\n" +
                "Raza: " + m.getRaza() + "\n" +
                "Color: " + m.getColor() + "\n" +
                "Peso: " + m.getPeso() + "\n" +
                "Altura: " + m.getAltura() + "\n" +
                "Caracteristica 1: " + m.getCaracteristica1() + "\n" +
                "Caracteristica 2: " + m.getCaracteristica2()
        );

        try{

            ImageIcon img = new ImageIcon(m.getUrlFoto());

            Image imagen = img.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);

            lblFoto.setIcon(new ImageIcon(imagen));

        }catch(Exception e){

            lblFoto.setIcon(null);

        }
    }
}