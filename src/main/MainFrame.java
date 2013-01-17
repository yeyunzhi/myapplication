package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;
import org.json.JSONObject;

public class MainFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Image image=new ImageIcon("5.jpg").getImage();
	ImageIcon labIma=new ImageIcon("5.jpg");
	JButton btn;

	JLabel label;
	JLabel label0;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	JLabel label10;
	
	JTextField textISBN;
	JTextField bookName;
	JTextField authorName;
	JTextField bookIsbn10;
	JTextField bookIsbn13;
	JTextField bookPage;
	JTextField bookPrice;
	JTextField bookBinding;
	JTextField publisher;
	JTextField pubdate;
	JTextField bookDetail;
	
	JPanel panel0;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JPanel panel9;
	JPanel panel10;
	JPanel panel;
	
	public MainFrame() {
		this.setIconImage(image);
		this.setTitle("豆瓣图书信息搜索");
		init();
		this.add(panel);
		this.setSize(500,600);
		this.setVisible(true);
		btn.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent args) {
				System.exit(0);
			}
		});
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension size=toolkit.getScreenSize();
	    this.setLocation((int)(size.getWidth()-this.getWidth())/2,(int)(size.getHeight()-this.getHeight())/2);
	}
	public void init() {
		
		panel=new MyPanel(image);
		panel0=new JPanel();
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		panel8=new JPanel();
		panel9=new JPanel();
		panel10=new JPanel();
		
		label0=new JLabel();
		label1=new JLabel();
		label2=new JLabel();
		label3=new JLabel();
		label4=new JLabel();
		label5=new JLabel();
		label6=new JLabel();
		label7=new JLabel();
		label8=new JLabel();
		label9=new JLabel();
		label10=new JLabel();
		   
		textISBN=new JTextField(20);
		bookName=new JTextField(20);
		authorName=new JTextField(20);
		bookIsbn10=new JTextField(20);
		bookIsbn13=new JTextField(20);
		bookPage=new JTextField(20);
		bookPrice=new JTextField(20);
		bookBinding=new JTextField(20);
		publisher=new JTextField(20);
		pubdate=new JTextField(20);
		bookDetail=new JTextField(20);
		bookDetail.setSize(20, 80);
		
		   
		label0.setText("请输入图书ISBN:");
		label1.setText("图书名称 :");
		label2.setText("作者姓名:");
		label3.setText("ISBN10码:");
		label4.setText("ISBN13码:");
		label5.setText("图书页数:");
		label6.setText("图书价格:");
		label7.setText("装订方式:");
		label8.setText("出版社:  ");
		label9.setText("出版日期:");
		label10.setText("内容概要:");
		label10.setForeground(new Color(255,0,0));
		btn=new JButton();
		btn.setText("搜索");
		
		panel0.add(label0);
		panel0.add(textISBN);
		panel0.add(btn);
		panel1.add(label1);
		panel1.add(bookName);
		panel2.add(label2);
		panel2.add(authorName);
		panel3.add(label3);
		panel3.add(bookIsbn10);
		panel4.add(label4);
		panel4.add(bookIsbn13);
		panel5.add(label5);
		panel5.add(bookPage);
		panel6.add(label6);
		panel6.add(bookPrice);
		panel7.add(label7);
		panel7.add(bookBinding);
		panel8.add(label8);
		panel8.add(publisher);
		panel9.add(label9);
		panel9.add(pubdate);
		panel10.add(label10);
	    panel10.add(bookDetail);
		
	    panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);
		panel7.setOpaque(false);
		panel8.setOpaque(false);
		panel9.setOpaque(false);
		panel10.setOpaque(false);
		panel0.setOpaque(false);

		panel.add(panel0);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel8);
		panel.add(panel9);
		panel.add(panel10);
		panel.setOpaque(false);		   
		panel.setLayout(new GridLayout(0,1));
		this.setResizable(false);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		BookInfo book;
		JSONData isbnTest = new JSONData();
		String isbn = textISBN.getText();//获取输入的图书ISBN码
		String bookjson;
		try {
			bookjson = isbnTest.fetchBookInfoByXML(isbn);
			JSONObject jsonobj=isbnTest.stringToJson(bookjson);				    
		    book = (BookInfo)isbnTest.setBookData();
			bookName.setText(book.getTitle());
		    authorName.setText(book.getAuthor());
		    bookIsbn10.setText(book.getIsbn10());
		    bookIsbn13.setText(book.getIsbn13());
		    bookBinding.setText(book.getBinding());
		    bookDetail.setText(book.getSummary());
		    bookPage.setText(book.getPage());
		    bookPrice.setText(book.getPrice());
		    publisher.setText(book.getPublisher());
		    pubdate.setText(book.getPubdate());
		    
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
	}
}
