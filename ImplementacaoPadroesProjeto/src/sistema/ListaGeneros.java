package sistema;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import conexaoBanco.ManipularGenero;
import dados.Genero;
import javax.swing.JScrollPane;

public class ListaGeneros extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaGeneros frame = new ListaGeneros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaGeneros() {
		setTitle("Listar generos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[grow][][][]", "[][grow][]"));
		
		textField = new JTextField();
		panel.add(textField, "cell 0 0 2 1,growx");
		textField.setColumns(10);
				
		JButton btnNewButton = new JButton("Buscar");
		panel.add(btnNewButton, "cell 2 0");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "flowx,cell 0 1 3 1");
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(this.getTableMode());
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container c = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component) e.getSource());
				if (c != null) {
					JInternalFrame jf = new cadastroGenero();
					getDesktopPane().add(jf);
					jf.toFront();
					jf.setVisible(true);					
				} else {
					JOptionPane.showMessageDialog(null, "Deu erro");
				}
			}
		});
		panel.add(btnNewButton_1, "cell 0 2,alignx right");
		
		JButton btnNewButton_2 = new JButton("Editar");
		panel.add(btnNewButton_2, "cell 1 2,aligny baseline");
		
		JButton btnNewButton_3 = new JButton("Excluir");
		panel.add(btnNewButton_3, "cell 2 2");

	}

	
	public GeneroTableModel getTableMode() {
		LinkedList<Genero> lgs = ManipularGenero.getAll();
		return new GeneroTableModel(lgs);
	}
	
	public void updateTable() {
		this.table.setModel(this.getTableMode());
	}
	
}
