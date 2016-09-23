package com.example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import healthyhome.bean.LiverMessage;
import healthyhome.bean.UserMessage;
import healthyhome.dao.JDBCLiverMessageDao;
import healthyhome.dao.JDBCLiverMessageDaoImpl;
import healthyhome.dao.JDBCUserMessageDao;
import healthyhome.dao.JDBCUserMessageDaoImpl;

public class FileUploadLiverServlet extends HttpServlet {
	private static final long serialVersionUID = -7744625344830285257L;
	JDBCUserMessageDao umDao = new JDBCUserMessageDaoImpl();
	JDBCLiverMessageDao lmDao = new JDBCLiverMessageDaoImpl();
	 private ServletContext sc;
	 private String savePath;
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  doPost(request, response);
	 }
	 

	 public void init(ServletConfig config) {
	  // 在web.xml中设置的一个初始化参数
	  savePath = config.getInitParameter("savePath");
	  sc = config.getServletContext();
	 }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(factory);
//		 String bloodInspector = request.getParameter("bloodInspector");
//		 String comment = request.getParameter("comment");
//		 String date = request.getParameter("date");
//		 String cardNo = request.getParameter("cardNo");
		 
//		 bloodMessage.setBloodInspector(bloodInspector);
//		 bloodMessage.setComment(comment);
//		 bloodMessage.setDate(date);
		 
//		 userMessage.setCardNo(cardNo);
//		 UserMessage u = umDao.findByExample(userMessage).get(0);
//		 bloodMessage.setUid(u.getId());
		 try {
			 LiverMessage liverMessage = new LiverMessage();
			 UserMessage userMessage = new UserMessage();
			 List items = upload.parseRequest(request);
			 Map<String,String> pm = new HashMap<String,String>();    
			 Iterator itr = items.iterator();
			 while (itr.hasNext()) {
				 FileItem item = (FileItem) itr.next();
				 if (item.isFormField()) {
					 System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
					 pm.put(item.getFieldName(), item.getString("UTF-8"));
				 } else {
					 if (item.getName() != null && !item.getName().equals("")) {
						 System.out.println("上传文件的大小:" + item.getSize());
						 System.out.println("上传文件的类型:" + item.getContentType());
	      // item.getName()返回上传文件在客户端的完整路径名称
						 System.out.println("上传文件的名称:" + item.getName());

						 File tempFile = new File(item.getName());

		//上传文件的保存路径
						 System.out.println("上传文件的保存路径:" + sc.getRealPath("/") + savePath);
						 
						 liverMessage.setLiver("image\\"+tempFile.getName());
						 File file = new File(sc.getRealPath("/") + savePath, tempFile.getName());
						 item.write(file);
						 request.setAttribute("upload.message", "上传文件成功！");
					 }else{
						 request.setAttribute("upload.message", "没有选择上传文件！");
					 }
				 }
			 }
			 liverMessage.setLiverInspector(pm.get("liverInspector"));
			 liverMessage.setComment(pm.get("comment"));
			 liverMessage.setDate(pm.get("date"));
			 userMessage.setCardNo(pm.get("cardNo"));
			 //userMessage.setId(1);
			 UserMessage u = umDao.queryUser(userMessage);
			 int times = lmDao.queryCount(u.getId()) + 1;
			 liverMessage.setTimes(times);
			 liverMessage.setUid(u.getId());
			 lmDao.saveLiverMessage(liverMessage);
		 }catch(FileUploadException e){
			 e.printStackTrace();
		 }catch (Exception e) {
			 e.printStackTrace();
			 request.setAttribute("upload.message", "上传文件失败！");
		 }
		 request.getRequestDispatcher("/uploadResult.jsp").forward(request, response);
	 }
}
