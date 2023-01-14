package com.mercubuana.tugasbesar2.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mercubuana.tugasbesar2.Buku;
import com.mercubuana.tugasbesar2.BukuDAO;
import com.mercubuana.tugasbesar2.Peminjam;
import com.mercubuana.tugasbesar2.PeminjamDAO;
import com.mercubuana.tugasbesar2.TB02PBOPersistentManager;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.JulianFields;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.transaction.Transaction;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;

public class FormUtamaPinjamBuku {

	private JFrame frmPinjamBuku;
	private JTextField txtNamaBuku;
	private JTextField txtJumlahBuku;
	private JTextField txtSisaBuku;
	private JPanel panelRincianDataBuku;
	private JButton btnTambahData;
	private JList listDaftarBuku;
	private JComboBox cmbJenisBuku;
	private Buku[] dataBuku = null;
	private JButton btnRekamDataBuku;
	private JScrollPane scrollPane;
	private JButton btnHapus;
	private JButton btnUbahData;
	private JButton btnBatal;
	private JButton btnRekamPerubahan;
	private boolean apakahTambahData = true;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Buku[] dataBukuSesuai = new Buku[0];
	private JRadioButton rdbtnNovel;
	private JRadioButton rdbtnBukuPelajaran;
	private JRadioButton rdbtnMajalah;
	private JButton btnCariBuku;
	private JLabel lblDaftarBukuSesuai;
	private JList listDaftarBukuSesuai;
	private JLabel lblNamaBukuDipilih;
	private JLabel lblJumlahBukuPanelDua;
	private JLabel lblSisaBukuPanelDua;
	private JTextField txtNamaBukuPanelDua;
	private JTextField txtJumlahBukuPanelDua;
	private JTextField txtSisaBukuPanelDua;
	private JPanel panelRincianDataPeminjam;
	private JLabel lblNamaPeminjam;
	private JLabel lblTanggalPinjam;
	private JTextField txtNamaPeminjam;
	private JButton btnRekamPinjam;
	private JList listDaftarBukuPanelTiga;
	private JLabel lblDaftarPinjam;
	private JList listDaftarPinjamPanelTiga;
	private JScrollPane scrollPane_2;
	private JPanel panelTiga;
	private JLabel lblJenisBukuPanelTiga;
	private JLabel lblTanggalPinjamPanelTiga;
	private JTextField txtTanggalPinjamPanelTiga;
	private JComboBox cmbJenisBukuPanelTiga;
	private JTextField txtTanggalPinjamPanelDua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUtamaPinjamBuku window = new FormUtamaPinjamBuku();
					window.frmPinjamBuku.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormUtamaPinjamBuku() {
		// 1. Inisialiasi dan menampilkan form utama
		initialize();
		/* 2. Membaca data dari database */
		bacaDataDariDatabase();
		/* 3. Memeriksa jika sudah ada data untuk
		 * 	  ditampilkan pada list
		 */
		if (dataBuku.length>0) {
			tampilkanDataBukuPadaList();
			// 4. Pilih buku teratas pada list
			listDaftarBuku.setSelectedIndex(0);
			/* 5. Tampilkan data buku pada list yang ada 
			 *    pada panel tiga
			 */
			listDaftarBukuPanelTiga.setListData(dataBuku);
		}
		nonAktifkanPanelRincian();
//		tampilkanDataKonserPadaList();
//		pilihSebuahKonserPadaList(0);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPinjamBuku = new JFrame();
		frmPinjamBuku.setTitle("Peminjaman Buku");
		frmPinjamBuku.setBounds(100, 100, 650, 545);
		frmPinjamBuku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPinjamBuku.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 632, 498);
		frmPinjamBuku.getContentPane().add(tabbedPane);
		
		JPanel panelSatu = new JPanel();
		tabbedPane.addTab("Daftar Buku", null, panelSatu, null);
		panelSatu.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 396, 146);
		panelSatu.add(scrollPane);
		
		listDaftarBuku = new JList();
		scrollPane.setViewportView(listDaftarBuku);
		listDaftarBuku.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahTampilanPadaPanelRincian();
			}
		});
		listDaftarBuku.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarBuku.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblDaftarBuku = new JLabel("Data Buku");
		lblDaftarBuku.setBounds(12, 12, 113, 16);
		panelSatu.add(lblDaftarBuku);
		lblDaftarBuku.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnTambahData = new JButton("Tambah Data");
		btnTambahData.setBounds(420, 40, 123, 26);
		panelSatu.add(btnTambahData);
		btnTambahData.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panelRincianDataBuku = new JPanel();
		panelRincianDataBuku.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Rincian Data Buku", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRincianDataBuku.setName("");
		panelRincianDataBuku.setBounds(12, 199, 507, 177);
		panelSatu.add(panelRincianDataBuku);
		panelRincianDataBuku.setLayout(null);
		
		JLabel lblNamaBuku = new JLabel("Nama Buku : ");
		lblNamaBuku.setBounds(12, 27, 123, 16);
		panelRincianDataBuku.add(lblNamaBuku);
		lblNamaBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamaBuku.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblJenisBuku = new JLabel("Jenis Buku : ");
		lblJenisBuku.setBounds(12, 55, 123, 16);
		panelRincianDataBuku.add(lblJenisBuku);
		lblJenisBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJenisBuku.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblJumlahBuku = new JLabel("Jumlah Buku: ");
		lblJumlahBuku.setBounds(12, 83, 123, 16);
		panelRincianDataBuku.add(lblJumlahBuku);
		lblJumlahBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahBuku.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSisaBuku = new JLabel("Sisa Buku : ");
		lblSisaBuku.setBounds(12, 111, 123, 16);
		panelRincianDataBuku.add(lblSisaBuku);
		lblSisaBuku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaBuku.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtNamaBuku = new JTextField();
		txtNamaBuku.setBounds(139, 27, 150, 20);
		panelRincianDataBuku.add(txtNamaBuku);
		txtNamaBuku.setColumns(10);
		
		txtJumlahBuku = new JTextField();
		txtJumlahBuku.setBounds(139, 83, 60, 20);
		panelRincianDataBuku.add(txtJumlahBuku);
		txtJumlahBuku.setColumns(10);
		
		txtSisaBuku = new JTextField();
		txtSisaBuku.setBounds(139, 111, 60, 20);
		panelRincianDataBuku.add(txtSisaBuku);
		txtSisaBuku.setColumns(10);
		
		cmbJenisBuku = new JComboBox();
		cmbJenisBuku.setBounds(139, 53, 150, 25);
		panelRincianDataBuku.add(cmbJenisBuku);
		cmbJenisBuku.setModel(new DefaultComboBoxModel(new String[] {"Novel", "Majalah", "Buku Pelajaran"}));
		
		btnRekamDataBuku = new JButton("Rekam Data Buku");
		btnRekamDataBuku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataBuku();
				//rekamDataKonser();
			}
		});
		btnRekamDataBuku.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRekamDataBuku.setBounds(12, 139, 175, 26);
		panelRincianDataBuku.add(btnRekamDataBuku);
		
		btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				masukModeBrowsing();
//				batalkanProsesManipulasiData();
			}
		});
		btnBatal.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBatal.setBounds(372, 139, 123, 26);
		panelRincianDataBuku.add(btnBatal);
		
		btnRekamPerubahan = new JButton("Rekam Perubahan");
		btnRekamPerubahan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rekamPerubahan();
//				masukModeEditing();
//				btnRekamPerubahan.setEnabled(true);
			}
		});
		btnRekamPerubahan.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRekamPerubahan.setBounds(199, 139, 161, 26);
		panelRincianDataBuku.add(btnRekamPerubahan);
		
		btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hapusData();
			}
		});
		btnHapus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnHapus.setBounds(420, 160, 123, 26);
		panelSatu.add(btnHapus);
		
		btnUbahData = new JButton("Ubah Data");
		btnUbahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apakahTambahData = false;
				masukModeEditing();
				btnRekamPerubahan.setEnabled(true);
				btnRekamDataBuku.setEnabled(false);
			}
		});
		btnUbahData.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUbahData.setBounds(420, 78, 123, 26);
		panelSatu.add(btnUbahData);
		
		JPanel panelDua = new JPanel();
		tabbedPane.addTab("Peminjaman Buku", null, panelDua, null);
		panelDua.setLayout(null);
		
		JLabel lblPilihJenisBuku = new JLabel("Pilih Jenis Tiket ");
		lblPilihJenisBuku.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPilihJenisBuku.setBounds(12, 12, 129, 16);
		panelDua.add(lblPilihJenisBuku);
		
		rdbtnNovel = new JRadioButton("Novel");
		rdbtnNovel.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnNovel.setSelected(true);
		buttonGroup.add(rdbtnNovel);
		rdbtnNovel.setBounds(136, 8, 89, 24);
		panelDua.add(rdbtnNovel);
		
		rdbtnBukuPelajaran = new JRadioButton("Buku Pelajaran");
		rdbtnBukuPelajaran.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonGroup.add(rdbtnBukuPelajaran);
		rdbtnBukuPelajaran.setBounds(136, 64, 137, 29);
		panelDua.add(rdbtnBukuPelajaran);
		
		rdbtnMajalah = new JRadioButton("Majalah");
		rdbtnMajalah.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonGroup.add(rdbtnMajalah);
		rdbtnMajalah.setBounds(136, 36, 89, 24);
		panelDua.add(rdbtnMajalah);
		
		btnCariBuku = new JButton("Cari Buku");
		btnCariBuku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cariBuku();
			}
		});
		btnCariBuku.setBounds(280, 35, 121, 26);
		panelDua.add(btnCariBuku);
		
		lblDaftarBukuSesuai = new JLabel("Daftar Buku Sesuai :");
		lblDaftarBukuSesuai.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDaftarBukuSesuai.setBounds(12, 96, 162, 16);
		panelDua.add(lblDaftarBukuSesuai);
		
		listDaftarBukuSesuai = new JList();
		listDaftarBukuSesuai.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarBukuSesuai.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahRincianDataBukuDipilih();
			}
		});
		listDaftarBukuSesuai.setBorder(new LineBorder(new Color(0, 0, 0)));
		listDaftarBukuSesuai.setBounds(12, 120, 430, 112);
		panelDua.add(listDaftarBukuSesuai);
		
		lblNamaBukuDipilih = new JLabel("Nama Buku Dipilih");
		lblNamaBukuDipilih.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamaBukuDipilih.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNamaBukuDipilih.setBounds(22, 244, 152, 16);
		panelDua.add(lblNamaBukuDipilih);
		
		lblJumlahBukuPanelDua = new JLabel("Jumlah Buku");
		lblJumlahBukuPanelDua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahBukuPanelDua.setFont(new Font("Dialog", Font.BOLD, 14));
		lblJumlahBukuPanelDua.setBounds(22, 272, 152, 16);
		panelDua.add(lblJumlahBukuPanelDua);
		
		lblSisaBukuPanelDua = new JLabel("Sisa Buku");
		lblSisaBukuPanelDua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaBukuPanelDua.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSisaBukuPanelDua.setBounds(22, 299, 152, 16);
		panelDua.add(lblSisaBukuPanelDua);
		
		txtNamaBukuPanelDua = new JTextField();
		txtNamaBukuPanelDua.setBounds(192, 243, 114, 20);
		panelDua.add(txtNamaBukuPanelDua);
		txtNamaBukuPanelDua.setColumns(10);
		
		txtJumlahBukuPanelDua = new JTextField();
		txtJumlahBukuPanelDua.setBounds(192, 271, 57, 20);
		panelDua.add(txtJumlahBukuPanelDua);
		txtJumlahBukuPanelDua.setColumns(10);
		
		txtSisaBukuPanelDua = new JTextField();
		txtSisaBukuPanelDua.setBounds(192, 298, 57, 20);
		panelDua.add(txtSisaBukuPanelDua);
		txtSisaBukuPanelDua.setColumns(10);
		
		panelRincianDataPeminjam = new JPanel();
		panelRincianDataPeminjam.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		panelRincianDataPeminjam.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rincian Data Peminjaman", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRincianDataPeminjam.setBounds(12, 340, 430, 118);
		panelDua.add(panelRincianDataPeminjam);
		panelRincianDataPeminjam.setLayout(null);
		
		lblNamaPeminjam = new JLabel("Nama Peminjam");
		lblNamaPeminjam.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNamaPeminjam.setBounds(12, 45, 120, 16);
		panelRincianDataPeminjam.add(lblNamaPeminjam);
		
		lblTanggalPinjam = new JLabel("Tanggal Pinjam");
		lblTanggalPinjam.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTanggalPinjam.setBounds(12, 72, 143, 16);
		panelRincianDataPeminjam.add(lblTanggalPinjam);
		
		txtNamaPeminjam = new JTextField();
		txtNamaPeminjam.setBounds(173, 44, 245, 20);
		panelRincianDataPeminjam.add(txtNamaPeminjam);
		txtNamaPeminjam.setColumns(10);
		
		txtTanggalPinjamPanelDua = new JTextField();
		txtTanggalPinjamPanelDua.setBounds(170, 67, 146, 26);
		panelRincianDataPeminjam.add(txtTanggalPinjamPanelDua);
		txtTanggalPinjamPanelDua.setColumns(10);
	
		btnRekamPinjam = new JButton("Rekam Pinjam");
		btnRekamPinjam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(null, "Siap rekam");
				rekamDataPemesanan();
			}
		});
		btnRekamPinjam.setBounds(454, 388, 152, 26);
		panelDua.add(btnRekamPinjam);
		
		panelTiga = new JPanel();
		tabbedPane.addTab("Data Peminjaman", null, panelTiga, null);
		panelTiga.setLayout(null);
		
		JLabel lblDaftarBukuPanelTiga = new JLabel("Daftar Buku");
		lblDaftarBukuPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDaftarBukuPanelTiga.setBounds(12, 12, 97, 19);
		panelTiga.add(lblDaftarBukuPanelTiga);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 38, 418, 140);
		panelTiga.add(scrollPane_1);
		
		listDaftarBukuPanelTiga = new JList();
		listDaftarBukuPanelTiga.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahDaftarPemesanPadaBukuPanelTiga();
			}
		});
		scrollPane_1.setViewportView(listDaftarBukuPanelTiga);
		listDaftarBukuPanelTiga.setBorder(new LineBorder(new Color(0, 0, 0)));
		listDaftarBukuPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		
		lblDaftarPinjam = new JLabel("Daftar Pinjam");
		lblDaftarPinjam.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDaftarPinjam.setBounds(12, 190, 110, 19);
		panelTiga.add(lblDaftarPinjam);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 221, 415, 137);
		panelTiga.add(scrollPane_2);
		
		listDaftarPinjamPanelTiga = new JList();
		listDaftarPinjamPanelTiga.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahRincianPemesanPanelTiga();
			}
		});
		scrollPane_2.setViewportView(listDaftarPinjamPanelTiga);
		listDaftarPinjamPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarPinjamPanelTiga.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblJenisBukuPanelTiga = new JLabel("Jenis Buku : ");
		lblJenisBukuPanelTiga.setHorizontalAlignment(SwingConstants.LEFT);
		lblJenisBukuPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		lblJenisBukuPanelTiga.setBounds(12, 370, 152, 19);
		panelTiga.add(lblJenisBukuPanelTiga);
		
		lblTanggalPinjamPanelTiga = new JLabel("Tanggal pinjam :");
		lblTanggalPinjamPanelTiga.setHorizontalAlignment(SwingConstants.LEFT);
		lblTanggalPinjamPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTanggalPinjamPanelTiga.setBounds(12, 402, 152, 19);
		panelTiga.add(lblTanggalPinjamPanelTiga);
		
		cmbJenisBukuPanelTiga = new JComboBox();
		cmbJenisBukuPanelTiga.setModel(new DefaultComboBoxModel(new String[] {"Novel", "Majalah", "Buku Pelajaran"}));
		cmbJenisBukuPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		cmbJenisBukuPanelTiga.setBounds(170, 370, 114, 25);
		panelTiga.add(cmbJenisBukuPanelTiga);
		
		txtTanggalPinjamPanelTiga = new JTextField();
		txtTanggalPinjamPanelTiga.setBounds(170, 402, 114, 20);
		panelTiga.add(txtTanggalPinjamPanelTiga);
		txtTanggalPinjamPanelTiga.setColumns(10);
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apakahTambahData = true;
				masukModeEditing();
				btnRekamDataBuku.setEnabled(true);
				btnRekamPerubahan.setEnabled(false);
			}
		});
	}
	
	private void panelRincianDataPeminjaman() {
		// TODO Auto-generated method stub
		
	}

	void rekamDataBuku() {
		// 1. Membaca input User dari GUI
		String namaBuku = "";
		namaBuku = txtNamaBuku.getText();
		
		char jenisBuku = 'N';
		if (cmbJenisBuku.getSelectedIndex()==1) {
			jenisBuku = 'M';
		}
		else if (cmbJenisBuku.getSelectedIndex()==2) {
			jenisBuku = 'P';
		}
		
		int jumlahBuku = 0;
		int sisaBuku = 0;
		try {
			jumlahBuku = Integer.parseInt(txtJumlahBuku.getText());
			txtSisaBuku.setText("" + jumlahBuku);
			sisaBuku = jumlahBuku;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
					"Isian Jumlah Pinjam harus berupa bilangan bulat");
			return;
		}
		
		// 2. Memulai transaction baru
		PersistentTransaction t = null; 
		try {
			t = TB02PBOPersistentManager
					.instance().getSession().beginTransaction();
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal memulai transaction\n"
					+ "Pesan Error : " + e.getMessage());
			return;
		}
		
		/* 3. Membungkus semua proses perubahan dalam try-catch agar bisa dibatalkan
		 *    (roll-back) seandainya terjadi error
		 */	
		try {
			// 3a. Membuat objek buku baru (memori + database)
			Buku bukuBaru= BukuDAO.createBuku();
			// 3b. Mengubah atribut objek buku baru
			bukuBaru.setNamaBuku(namaBuku);
			bukuBaru.setJenisBuku(jenisBuku);
			bukuBaru.setJumlahBuku(jumlahBuku);
			bukuBaru.setSisaBuku(sisaBuku); 
			// 3c. Rekam perubahan ke dalam database
			BukuDAO.save(bukuBaru);
			// 3d. Jika semua perubahan berhasil, maka lakukan commit
			t.commit();
			JOptionPane.showMessageDialog(null, 
					"Data buku baru berhasil ditambahkan");
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal merekam data buku\n"
					+ "Pesan Error : " + e.getMessage());
			try {
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback\n"
						+ "Pesan Error : " + e1.getMessage());
			}
			return;
		}
		bacaDataDariDatabase();
		tampilkanDataBukuPadaList();
		int indeksDipilih = dataBuku.length - 1;
		pilihSebuahBukuPadaList(indeksDipilih);
		masukModeBrowsing();
	}
	
	void rekamPerubahan() {
	// 1. Membaca input User dari GUI
		String namaBuku = "";
		namaBuku = txtNamaBuku.getText();
				
		char jenisBuku = 'N';
		if (cmbJenisBuku.getSelectedIndex()==1) {
			jenisBuku = 'M';
		}
		else if (cmbJenisBuku.getSelectedIndex()==2) {
			jenisBuku = 'P';
		}
		int jumlahBuku = 0;
		int sisaBuku = 0;
		try {
			jumlahBuku = Integer.parseInt(txtJumlahBuku.getText());
					txtSisaBuku.setText("" + jumlahBuku);
					sisaBuku = jumlahBuku;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, 
							"Isian Jumlah Pinjam harus berupa bilangan bulat");
					return;
				}
				
				// 2. Memulai transaction baru
				PersistentTransaction t = null; 
				try {
					t = TB02PBOPersistentManager
							.instance().getSession().beginTransaction();
				} catch (PersistentException e) {
					JOptionPane.showMessageDialog(null, 
							"Gagal memulai transaction\n"
							+ "Pesan Error : " + e.getMessage());
					return;
				}
				
				/* 3. Membungkus semua proses perubahan dalam try-catch agar bisa dibatalkan
				 *    (roll-back) seandainya terjadi error
				 */	
				try {
					int index = listDaftarBuku.getSelectedIndex();
					Buku bukuBaru = (Buku) listDaftarBuku
								.getModel().getElementAt(index);
					// 3b. Mengubah atribut objek buku baru
					bukuBaru.setNamaBuku(namaBuku);
					bukuBaru.setJenisBuku(jenisBuku);
					bukuBaru.setJumlahBuku(jumlahBuku);
					bukuBaru.setSisaBuku(sisaBuku); 
					// 3c. Rekam perubahan ke dalam database
					BukuDAO.save(bukuBaru);
					// 3d. Jika semua perubahan berhasil, maka lakukan commit
					t.commit();
					JOptionPane.showMessageDialog(null, 
							"Data buku berhasil diubah");
				} catch (PersistentException e) {
					JOptionPane.showMessageDialog(null, 
							"Gagal merubah data buku\n"
							+ "Pesan Error : " + e.getMessage());
					try {
						t.rollback();
					} catch (PersistentException e1) {
						JOptionPane.showMessageDialog(null, 
								"Gagal melakukan rollback\n"
								+ "Pesan Error : " + e1.getMessage());
					}
					return;
				}
				//bacaDataDariDatabase();
				int indeksDipilih = listDaftarBuku
						.getSelectedIndex();
				tampilkanDataBukuPadaList();
				//int indeksDipilih = dataBuku.length - 1;
				pilihSebuahBukuPadaList(indeksDipilih);
				masukModeBrowsing();
	}
	
	void tambahDataBuku() {
		masukModeEditing();
		btnRekamDataBuku.setText("Rekam Data Buku");
		txtNamaBuku.setText("");
		cmbJenisBuku.setSelectedIndex(0);
		txtJumlahBuku.setText("");
		txtSisaBuku.setText("");
	}
	
	void ubahData() {
		aktifkanPanelRincian();
	}
	
	void masukModeEditing() {
		aktifkanPanelRincian();
		panelRincianDataBuku.setVisible(true);
		listDaftarBuku.setEnabled(false);
		btnTambahData.setEnabled(false);
		btnUbahData.setEnabled(false);
		btnHapus.setEnabled(false);
//		btnRekamDataBuku.setVisible(true);
		btnRekamDataBuku.setEnabled(true);
		btnRekamPerubahan.setVisible(true);
//		btnBatal.setVisible(true);
		btnBatal.setEnabled(true);
		if (apakahTambahData==true) {
			txtNamaBuku.setText("");
			cmbJenisBuku.setSelectedIndex(0);
			txtJumlahBuku.setText("");
			txtSisaBuku.setText("");
		} 
	}
	
	void masukModeBrowsing() {
		nonAktifkanPanelRincian();
		listDaftarBuku.setEnabled(true);
//		btnRekamDataBuku.setVisible(false);
		btnRekamDataBuku.setEnabled(false);
		btnRekamPerubahan.setEnabled(false);
//		btnBatal.setVisible(false);
		btnBatal.setEnabled(false);
		btnTambahData.setEnabled(true);
		btnUbahData.setEnabled(true);
		btnHapus.setEnabled(true);
	}
	
	void bacaDataDariDatabase() {
		try {
			dataBuku = BukuDAO.listBukuByQuery(null, null);
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal membaca data buku\n"
					+ "Pesan Error : " + e.getMessage());
		}
	}
	
	void tampilkanDataBukuPadaList() {
		listDaftarBuku.setListData(dataBuku);
		listDaftarBukuPanelTiga.setListData(dataBuku);
	}
	
	void ubahTampilanPadaPanelRincian() {
		if (listDaftarBuku.getModel().getSize()==0) {
			/* Jika list data buku kosong, maka kosongkan
			 * juga panel rincian data buku
			 */
			txtNamaBuku.setText("");
			txtJumlahBuku.setText("");
			txtSisaBuku.setText("");
			cmbJenisBuku.setSelectedIndex(0);
			return;
		}
		int index = listDaftarBuku.getSelectedIndex();
		if (index==-1) {
			return;
		}
//		if (index==-1) {
//			index = dataBuku.length - 1;
//		}
		Buku bukuDipilihPadaList = (Buku) listDaftarBuku
				.getModel().getElementAt(index);
		txtNamaBuku.setText(bukuDipilihPadaList.getNamaBuku());
		cmbJenisBuku.setSelectedIndex(0);
		if (bukuDipilihPadaList.getJenisBuku()=='T') {
			cmbJenisBuku.setSelectedIndex(1);
		}
		else if (bukuDipilihPadaList.getJenisBuku()=='V') {
			cmbJenisBuku.setSelectedIndex(2);
		}
		txtJumlahBuku.setText("" + bukuDipilihPadaList.getJumlahBuku());
		txtSisaBuku.setText("" + bukuDipilihPadaList.getSisaBuku());	
	}
	
	void batalkanProsesManipulasiData() {
		/*1. Aktifkan/NonAktifkan Tombol GUI */
		masukModeBrowsing();
		
		/*2. Update Tampilan Isian Data Sesuai Pilihan pada list */
		ubahTampilanPadaPanelRincian();
	}
	
	void hapusData() {
		int pilihanKonfirmasi = JOptionPane.showConfirmDialog(null, 
				"Apakah anda yakin untuk menghapus data buku " 
				+ listDaftarBuku.getSelectedValue(),
				"Konfirmasi Hapus Data",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (pilihanKonfirmasi == JOptionPane.OK_OPTION) {
		// 1. Menentukan objek buku yang sedang dipilih pada list
		int index = listDaftarBuku.getSelectedIndex();
		Buku bukuDipilihPadaList = (Buku) listDaftarBuku
					.getModel().getElementAt(index);
			// 2. Hapus data dari database
			PersistentTransaction t = null;
			int indeksDataDipilih = listDaftarBuku.getSelectedIndex();
			int jumlahBuku = dataBuku.length;
			if (indeksDataDipilih == jumlahBuku-1 && jumlahBuku >= 2) {
				/* Yang dipilih adalah yang terakhir dan masih
				 * ada sisa buku belum dihapus di dalam list
				 */
				indeksDataDipilih -= 1;
			} else if (indeksDataDipilih == 0 && jumlahBuku == 1) {
				// Yang dipilih adalah satu-satunya buku dalam list
				indeksDataDipilih = -1;
			} 
			try {
				t = TB02PBOPersistentManager
						.instance().getSession().beginTransaction();
				BukuDAO.deleteAndDissociate(bukuDipilihPadaList);
				t.commit();
			} catch (PersistentException e) {
				try {
					JOptionPane.showMessageDialog(null, 
							"Gagal hapus data\n"
							+ "Pesan Error : " + e.getMessage());
					t.rollback();
				} catch (PersistentException e1) {
					JOptionPane.showMessageDialog(null, 
							"Gagal melakukan rollback\n"
							+ "Pesan Error : " + e1.getMessage());
				}
				return;
			}
			bacaDataDariDatabase();
			tampilkanDataBukuPadaList();	
			pilihSebuahBukuPadaList(indeksDataDipilih);
		}
	}
	
	void pilihSebuahBukuPadaList(int indeksDipilih) {
		if (indeksDipilih==-1) {
			return;
		}
		listDaftarBuku.setSelectedIndex(indeksDipilih);
	}
	
	void aktifkanPanelRincian() {
		for (Component guiObject:panelRincianDataBuku
				.getComponents()) {
			guiObject.setEnabled(true);
		}
	}
	
	void nonAktifkanPanelRincian() {
		for (Component guiObject:panelRincianDataBuku
				.getComponents()) {
			guiObject.setEnabled(false);
		}
	}
	
	void cariBuku() {
		// 1. Membuat string query
		String kondisi = String.format("jenis_buku = " + "'%s' and sisa_buku > 0" , 
				rdbtnNovel.isSelected() ? "N" : rdbtnMajalah.isSelected() ? "M" : "P"  );
		//2. Mengeksekusi hasil query dengan kondisi dan
		//Menyimpan hasil query ke dalam array
		dataBukuSesuai = new Buku[0];
		try {
			dataBukuSesuai = BukuDAO.listBukuByQuery(kondisi,
					"sisa_buku DESC");
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, "Gagal"
					+ "membaca data buku\n"
					+ "Pesan error:" + e.getMessage());
			
			return;
		}
		
		/* 3. Menampilkan data buku yang sesuai
		 * pada list daftar buku sesuai, jika ada minimal
		 * 1 buku sebagai hasil query
		 */
		
		if(dataBukuSesuai.length>0) {
			listDaftarBukuSesuai.setListData(dataBukuSesuai);
		} else {
			JOptionPane.showMessageDialog(null, 
					"Tidak tersedia buku yang masih memiliki"
					+ "tiket kosong");
			return;
		}
	}
	
	void ubahRincianDataBukuDipilih() {
		/* 1. Memeriksa apakah event list selection change dipicu
		 * oleh perubahan pilihan user pada list atau oleh proses
		 * menampilkan data pad list
		 */
		
		int indeksDipilih = listDaftarBukuSesuai.getSelectedIndex();
		if (indeksDipilih == -1) {
			txtNamaBukuPanelDua.setText("");
			txtJumlahBukuPanelDua.setText("");
			txtSisaBukuPanelDua.setText("");
			return;
		}
		
		/* 2. Menentukan objek kamar yang dipilih
		 * user pada list
		 */
		Buku bukuDipilih = (Buku) listDaftarBukuSesuai.getModel()
				.getElementAt(indeksDipilih);
	
	/* 3. Mengisi rincian data buku sesuai yang dipilih user
	 * 
	 */
	txtNamaBukuPanelDua.setText(""+bukuDipilih.getNamaBuku());
	txtJumlahBukuPanelDua.setText(""+bukuDipilih.getJumlahBuku());
	txtSisaBukuPanelDua.setText(""+bukuDipilih.getSisaBuku());
	}
	void rekamDataPemesanan() {
		//1. Memeriksa apakah buku sudah dipilih
		if (listDaftarBukuSesuai.getSelectedIndex()==1) {
			JOptionPane.showMessageDialog(null, 
					"Buku untuk Peminjam harus dipilih terlebih dahulu. \n"
					+ "Silahkan Perbaiki.");
			return;
		}
		
		/* 2. Menentukan objek kamar yang dipilih
		 * user pada list
		 */
		int indeksDipilih = listDaftarBukuSesuai.getSelectedIndex();
		Buku bukuDipilih = (Buku) listDaftarBukuSesuai.getModel()
				.getElementAt(indeksDipilih);
	
		/*3. Memeriksa apakah nama Peminjam sudah diisi 
		 */
		if(txtNamaPeminjam.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nama Peminjam harus diisi terlebih dahulu.\n"
				+ "Silahkan Perbaiki");
			return;
		}
		String namaPeminjam = txtNamaPeminjam.getText();
		
		/* 4. Memeriksa apakah tanggal Peminjaman adalah tanggal yang valid
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date tanggalPinjam = null;
		try {
			tanggalPinjam = sdf.parse(txtTanggalPinjamPanelDua
					.getText());
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, 
					"Tanggal Peminjaman harus ditulis dengan format"
					+ "DD/MM/YYYY.\n"
					+ "Silahkan perbaiki.");
			return;
		}
		
		// 5. Merekam data pendaftaran ke dalam database
		// 5a. Membuat transaction
		PersistentTransaction t = null;
		try {
			t = TB02PBOPersistentManager.instance().getSession().beginTransaction();
		} catch (PersistentException e1) {
			JOptionPane.showMessageDialog(null, 
					"Gagal membuat transaction.\n"
					+ "Pesan Error : " + e1.getMessage());
		}
		
		try {
			// 5b. Melakukan langkah perubahan data
			// 5b1. Membuat objek Peminjam baru
			Peminjam peminjamBaru = PeminjamDAO.createPeminjam();
			// 5b2. Mengubah berbagai atribut objek Peminjam
			peminjamBaru.setNamaPeminjam(namaPeminjam);
			peminjamBaru.setTanggalPeminjam(tanggalPinjam);
			// 5b3. Mengubah berbagai atribut objek buku
			bukuDipilih.peminjam.add(peminjamBaru);
			bukuDipilih.setSisaBuku(bukuDipilih
					.getSisaBuku() - 1);
			// 5b4. Merekam perubahan ke dalam database
			PeminjamDAO.save(peminjamBaru);
			BukuDAO.save(bukuDipilih);
			t.commit();
		} catch (PersistentException e) {
			JOptionPane.showConfirmDialog(null, 
					"Gagal merekam data Peminjam\n"
					+ "Pesan Error : " + e.getMessage());
			try {
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback.\n"
						+ "Pesan Error : " + e1.getMessage());
			}
			return;
		}
		JOptionPane.showMessageDialog(null, 
				"Data Peminjam berhasil ditambahkan");
		txtNamaPeminjam.setText("");
		txtJumlahBukuPanelDua.setText("");
		txtSisaBukuPanelDua.setText("");
		listDaftarBukuSesuai.setListData(new Buku[0]);
		rdbtnNovel.setSelected(true);
	}
	
	void ubahDaftarPemesanPadaBukuPanelTiga() {
		/* 1. Memeriksa apakah event selection-change dipicu oleh
		 * berubahnya pilihan user pada list atau dipicu oleh awal 
		 * ditampilkannya daftar buku pada list
		 */
		int indeksDipilih = listDaftarBukuPanelTiga.getSelectedIndex();
		if (indeksDipilih==-1) {
			// Dipicu oleh awal ditampilkannya daftar
			return;
		}
		// 2. Mendapatkan objek buku yang dipilih pada list
		Buku bukuDipilih = (Buku) listDaftarBukuPanelTiga.getModel()
				.getElementAt(indeksDipilih);
		// 3. Membuat daftar Peminjam
		/* 3a. Membuat array objek Peminjam dengan jumlah elemen sebanyak 
		 * jumlah objek Peminjam dalam koleksi Peminjam pada objek buku dipilih
		 */
		Peminjam[] dataPeminjam = new Peminjam[bukuDipilih.peminjam.size()];
		/* 3b. Konversi koleksi Peminjam menjadi array */
		dataPeminjam = (Peminjam[]) bukuDipilih.peminjam.getCollection()
				.toArray(dataPeminjam);
		// 4. Menampilkan daftar Peminjam pada list
		listDaftarPinjamPanelTiga.setListData(dataPeminjam);
	}
	
	void ubahRincianPemesanPanelTiga() {
		/* 1. Memeriksa apakah perubahan pilihan list dipicu oleh 
		 * berubahnya pilihan user atau dipicu oleh baru
		 * ditampilkannya daftar Peminjam
		 */
		int indeksDipilih = listDaftarPinjamPanelTiga.getSelectedIndex();
		if (indeksDipilih==-1) {
			// Dipicu oleh baru ditampilkannya daftar
			if (listDaftarPinjamPanelTiga.getModel().getSize()>0) {
				// Jika list tidak kosong, pilih Peminjam pada daftar paling atas
				listDaftarPinjamPanelTiga.setSelectedIndex(0);
			}
			return;
		}
		// 2. Ubah rincian
		cmbJenisBukuPanelTiga.setSelectedIndex(0);
		Peminjam peminjamDipilih = (Peminjam) listDaftarPinjamPanelTiga
				.getModel().getElementAt(indeksDipilih);
		if (peminjamDipilih.getJenisBuku()=='M') {
			cmbJenisBukuPanelTiga.setSelectedIndex(1);
		} else if (peminjamDipilih.getJenisBuku()=='P') {	
			cmbJenisBukuPanelTiga.setSelectedIndex(2);
		}
		String tanggal = "";
		LocalDate tanggalPinjam = Instant.ofEpochMilli(peminjamDipilih
				.getTanggalPeminjam().getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		tanggal += tanggalPinjam.getDayOfMonth() + "/";
		tanggal += tanggalPinjam.getMonthValue() + "/";
		tanggal += tanggalPinjam.getYear();
		txtTanggalPinjamPanelTiga.setText(tanggal);
	}
}