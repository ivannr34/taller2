
package pa.vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    JButton btnInsertar;
    JButton btnConsultar;

    public VentanaPrincipal(){

        setTitle("Sistema de Minipigs");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnInsertar = new JButton("Insertar Minipig");
        btnInsertar.setBounds(100,80,200,30);
        add(btnInsertar);

        btnConsultar = new JButton("Consultar Minipig");
        btnConsultar.setBounds(100,130,200,30);
        add(btnConsultar);

        btnInsertar.addActionListener(e -> {

            VentanaInsertarMinipig vi = new VentanaInsertarMinipig();
            vi.setVisible(true);

        });
        btnConsultar.addActionListener(e -> {
            
            VentanaConsultaMinipig vc = new VentanaConsultaMinipig();
            vc.setVisible(true);
        });

        setVisible(true);
    }
}
