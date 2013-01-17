package main;

import java.io.*;
import java.net.*;

import org.json.JSONException;
import org.json.JSONObject;


class JSONData {
	String isbnUrl = "https://api.douban.com/v2/book/isbn/:";
	JSONObject jsonobj;
	BookInfo book;
    /*
     * ���ݴ��ݵ�ͼ��ISBN�����ö���API��ȡjson�ַ���
     */
	public String fetchBookInfoByXML(String isbnNo) throws IOException  {    
	    String requestUrl = isbnUrl + isbnNo+"?alt=json";    
	    URL url = new URL(requestUrl);    
	    URLConnection conn = url.openConnection();    
	    InputStream is = conn.getInputStream();    
	    InputStreamReader isr = new InputStreamReader(is, "utf-8");    
	    BufferedReader br = new BufferedReader(isr);    
	    StringBuilder sb = new StringBuilder();    
	        
	    String line = null;    
	    while ((line = br.readLine()) != null) {    
	        sb.append(line);    
	    }    
	        
	    br.close();    
	    return sb.toString();    
	}
	//��json�ַ���ת��Ϊjson
	public JSONObject stringToJson(String str) throws JSONException
	{
		jsonobj = new JSONObject(str);
		return jsonobj;
	}
	//���û�ȡ��ͼ����Ϣ�����ض���
	public BookInfo setBookData() throws JSONException
	{
		book = new BookInfo();
		String name = jsonobj.getString("title");
		book.setTitle(name);//��������
		
		String author = jsonobj.getString("author");
		book.setAuthor(author);//������������
		
		String isbn10 = jsonobj.getString("isbn10");
		book.setIsbn10(isbn10);//����ISBN10
		
		String isbn13 = jsonobj.getString("isbn13");
		book.setIsbn13(isbn13);//����ISBN13
		
		String pages = jsonobj.getString("pages");
		book.setPage(pages);//����ͼ��ҳ��
		
		String price = jsonobj.getString("price");
		book.setPrice(price);//����ͼ��۸�
		
		String binding = jsonobj.getString("binding");
		book.setBinding(binding);//����װ����ʽ
		
		String publisher = jsonobj.getString("publisher");
		book.setPublisher(publisher);//���ó�����
		
		String pubdate = jsonobj.getString("pubdate");
		book.setPubdate(pubdate);//���ó�������
		
		String summary = jsonobj.getString("summary");
		book.setSummary(summary);//����ͼ���Ҫ��Ϣ
		return book;
	}	
}
