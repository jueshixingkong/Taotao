package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {

	@Test
	public void testFtpClient() throws Exception{
//		FTPClient ftpClient = new FTPClient();
//		ftpClient.connect("192.168.1.120");
//		ftpClient.login("lisi", "wlx139");
//		FileInputStream inputStream = new FileInputStream(new File("E:\\tupian\\xiaoqingxin1.jpg"));
//		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//		ftpClient.storeFile("123.jpg", inputStream);
//		inputStream.close();
//		
//		ftpClient.logout();

		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接，默认是21端口
		ftpClient.connect("192.168.1.100", 21);
		//登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "wlx139");
		//上传文件
		//读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("E:\\tupian\\xiaoqingxin1.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/");
		//修改上传文件格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数:服务器端文档名
		//第二个参数:上传文件的inputStream
		ftpClient.storeFile("hello1.jpg", inputStream);
		//关闭连接
	
		ftpClient.logout();
		
	}
	
	
	
	@Test
	public void testFtpUtil() throws Exception{
		FileInputStream inputStream = new FileInputStream(new File("E:\\tupian\\xiaoqingxin1.jpg"));
		FtpUtil.uploadFile("192.168.1.100", 21, "lisi", "wlx139", "/", 
						"2017/4/27", "hello.jpg", inputStream);
		
		
	}
	
	
	
	
	
	
	
	
	
}
