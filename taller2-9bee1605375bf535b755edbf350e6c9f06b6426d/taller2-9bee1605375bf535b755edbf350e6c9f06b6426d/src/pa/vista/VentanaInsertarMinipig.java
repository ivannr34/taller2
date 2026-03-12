package pa.vista;

import javax.swing.*;
import pa.modelo.Genero;
import pa.modelo.Raza;
import pa.control.ControlMinipig;
import pa.dto.MinipigDTO;
import pa.modelo.CategoriaAltura;
import pa.modelo.CategoriaEdad;

public class VentanaInsertarMinipig extends JFrame {

    JTextField txtCodigo;
    JTextField txtNombre;
    JTextField txtMicrochip;
    JComboBox<Genero> comboGenero;
    JComboBox<Raza> comboRaza;
    JTextField txtColor;
    JTextField txtPeso;
    JComboBox<CategoriaAltura> comboAltura;
    JComboBox<CategoriaEdad> comboEdad;
    JTextField txtCaracteristica1;
    JTextField txtCaracteristica2;

    JButton btnGuardar;


    ControlMinipig control = new ControlMinipig();


    public VentanaInsertarMinipig(){

        setTitle("Insertar Minipig");
        setSize(300,540);
        setLayout(null);
        setLocationRelativeTo(null);


        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(20,20,100,20);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(100,20,150,20);
        add(txtCodigo);


        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20,60,100,20);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100,60,150,20);
        add(txtNombre);

        //MICROCHIP
        JLabel lblMicrochip = new JLabel("Microchip:");
        lblMicrochip.setBounds(20,100,100,20);
        add(lblMicrochip);

        txtMicrochip = new JTextField();
        txtMicrochip.setBounds(100,100,150,20);
        add(txtMicrochip);

        // RAZA
        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setBounds(20,140,100,20);
        add(lblRaza);

        comboRaza = new JComboBox<>(Raza.values());
        comboRaza.setBounds(100,140,150,20);
        add(comboRaza);


        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setBounds(20,180,100,20);
        add(lblGenero);

        comboGenero = new JComboBox<>(Genero.values());
        comboGenero.setBounds(100,180,150,20);
        add(comboGenero);

        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(20,220,100,20);
        add(lblColor);

        txtColor = new JTextField();
        txtColor.setBounds(100,220,150,20);
        add(txtColor);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(20,260,100,20);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(100,260,150,20);
        add(txtPeso);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(20,300,100,20);
        add(lblAltura);

        comboAltura = new JComboBox<>(CategoriaAltura.values());
        comboAltura.setBounds(100,300,150,20);
        add(comboAltura);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20,340,100,20);
        add(lblEdad);

        comboEdad = new JComboBox<>(CategoriaEdad.values());
        comboEdad.setBounds(100,340,150,20);
        add(comboEdad);    
        
        JLabel lblCaracteristica1 = new JLabel("Caracteristica1:");
        lblCaracteristica1.setBounds(20,380,100,20);
        add(lblCaracteristica1);

        txtCaracteristica1 = new JTextField();
        txtCaracteristica1.setBounds(115,380,150,20);
        add(txtCaracteristica1);

        JLabel lbltxtCaracteristica2 = new JLabel("Caracteristica2:");
        lbltxtCaracteristica2.setBounds(20,420,100,20);
        add(lbltxtCaracteristica2);

        txtCaracteristica2 = new JTextField();
        txtCaracteristica2.setBounds(115,420,150,20);
        add(txtCaracteristica2);


        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(80,450,120,30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardarMinipig());
    }


        private void guardarMinipig(){

            try{

                String codigo = txtCodigo.getText();
                String nombre = txtNombre.getText();
                String microchip = txtMicrochip.getText();
                String genero = comboGenero.getSelectedItem().toString();
                String raza = comboRaza.getSelectedItem().toString();
                String color = txtColor.getText();

                double peso = Double.parseDouble(txtPeso.getText());
                String altura = comboAltura.getSelectedItem().toString();

                String caracteristica1 = txtCaracteristica1.getText();
                String caracteristica2 = txtCaracteristica2.getText();

                String foto = "";

                MinipigDTO minipig = new MinipigDTO(
                        codigo,
                        nombre,
                        genero,
                        microchip,
                        raza,
                        color,
                        peso,
                        altura,
                        caracteristica1,
                        caracteristica2,
                        foto
                );

                control.insertarMinipig(minipig);

                JOptionPane.showMessageDialog(this,"Minipig guardado correctamente");

                this.dispose(); // 🔹 cierra la ventana

            }catch(Exception e){

                JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());

            }
    }
}
