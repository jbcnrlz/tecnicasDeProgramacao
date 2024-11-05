package sistema;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import conexaoBanco.GestaoDeConexao;
import conexaoBanco.ManipularGenero;
import dados.Genero;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastroGenero extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static Genero gen = null;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroGenero frame = new cadastroGenero(0);
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
	public cadastroGenero(int id) {
		setClosable(true);
		if (id != 0) {
			cadastroGenero.gen = ManipularGenero.getByID(id);
		}
		setTitle("Cadastrar Genero");
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 96);
		getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		if (id != 0) {
			textField.setText(cadastroGenero.gen.getNome());
		}
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroGenero.gen != null) {
					cadastroGenero.gen.setNome(textField.getText());
					ManipularGenero mg = new ManipularGenero(GestaoDeConexao.constuirConexao(), cadastroGenero.gen);
					mg.atualizar();
				} else {
					Genero g = new Genero(textField.getText());
					ManipularGenero mg = new ManipularGenero(GestaoDeConexao.constuirConexao(), g);
					mg.salvar();	
				}				
				Container c = SwingUtilities.getAncestorOfClass(JInternalFrame.class, (Component) e.getSource());
				if (c != null) {
					JInternalFrame jf = JInternalFrame.class.cast(c);
					ListaGeneros.getCurrWindow().updateTable();
					jf.dispose();					
				}
			}
		});
		getContentPane().add(btnNewButton, "flowx,cell 2 1,alignx right");
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container c = SwingUtilities.getAncestorOfClass(JInternalFrame.class, (Component) e.getSource());
				if (c != null) {
					JInternalFrame jf = JInternalFrame.class.cast(c);
					jf.dispose();					
				}			
			}
		});
		getContentPane().add(btnNewButton_1, "cell 2 1");

	}

}
