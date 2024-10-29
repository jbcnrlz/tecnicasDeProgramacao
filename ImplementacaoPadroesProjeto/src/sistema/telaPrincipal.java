package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import conexaoBanco.GestaoDeConexao;
import conexaoBanco.ManipularGenero;
import dados.Genero;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import net.miginfocom.swing.MigLayout;

public class telaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
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
	public telaPrincipal() {
		setTitle("Sistema de Jogos Radical");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 140);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Genero");

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Jogos");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		desktopPane.setLayout(new MigLayout("", "[]", "[]"));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame jf = new ListaGeneros();
				desktopPane.add(jf);
				jf.setVisible(true);
			}
		});

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame jf = new CadastroJogo();
				desktopPane.add(jf);
				jf.setVisible(true);
			}
		});

		
	}
}
