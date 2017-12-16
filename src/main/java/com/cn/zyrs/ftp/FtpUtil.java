/*
 * 文 件 名: JavaFtp.java
 * 版    权:  zx
 * 描    述:  <描述>
 * 修 改 人:  Wayne
 * 修改时间:  2017年10月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.cn.zyrs.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FtpUtil {

	private static Logger logger = Logger.getLogger(FtpUtil.class);

	private static FTPClient ftp;

	/**
	 * 获取ftp连接
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public static boolean connectFtp(Ftp f) throws Exception {

		ftp = new FTPClient();
		boolean flag = false;
		int reply;
		if (f.getPort() == null) {
			ftp.connect(f.getIpAddr(), 21);
		} else {
			ftp.connect(f.getIpAddr(), f.getPort());
		}
		ftp.login(f.getUserName(), f.getPwd());
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return flag;
		}
		ftp.changeWorkingDirectory(f.getPath());
		flag = true;
		return flag;
	}

	/**
	 * 关闭ftp连接
	 */
	public static void closeFtp() {
		if (ftp != null && ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ftp上传文件
	 * 
	 * @param f
	 * @throws Exception
	 */
	public static void upload(File f) throws Exception {
		ftp.enterLocalPassiveMode();
		if (f.isDirectory()) {
			ftp.makeDirectory(f.getName());
			ftp.changeWorkingDirectory(f.getName());
			String[] files = f.list();
			for (String fstr : files) {
				File file1 = new File(f.getPath() + "/" + fstr);
				if (file1.isDirectory()) {
					upload(file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(f.getPath() + "/" + fstr);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					input.close();
				}
			}
		} else {
			File file2 = new File(f.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.storeFile(file2.getName(), input);
			input.close();
		}
	}

	// java web FTPClient 实现上传文件到指定服务器
	// 原创 2017年02月08日 14:14:05 标签：ftp服务器 172
	// FTPClient 实现上传文件到指定服务器
	//
	// 调用

	// 1
	// 2
	// 方法

	/**
	 * Description: 向FTP服务器上传文件
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 * @throws IOException 
	 */

	public static boolean moveFile(String url, int port, String username, String password, String path, String filename, InputStream input)  {
		boolean success = false;
		FTPClient ftp = new FTPClient();
//		ftp.setDataTimeout(60000);       //设置传输超时时间为60秒 
//		ftp.enterLocalActiveMode();      //主动模式
//		ftp.enterLocalPassiveMode();     //被动模式
        try {
			int reply;
			ftp.connect(url, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			ftp.setFileType(ftp.BINARY_FILE_TYPE);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			// 创建路径
			try {
				ftp.makeDirectory(path);
			} catch (Exception e) {
			}
			ftp.enterLocalPassiveMode();
			ftp.changeWorkingDirectory(path);
			boolean f = ftp.storeFile(filename, input);
			logger.error(f);
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}

	/**
	 * 下载链接配置
	 * 
	 * @param f
	 * @param localBaseDir
	 *            本地目录
	 * @param remoteBaseDir
	 *            远程目录
	 * @throws Exception
	 */
	// public static void startDown(Ftp f, String localBaseDir, String
	// remoteBaseDir)
	// throws Exception
	// {
	// if (FtpUtil.connectFtp(f))
	// {
	//
	// try
	// {
	// FTPFile[] files = null;
	// boolean changedir = ftp.changeWorkingDirectory(remoteBaseDir);
	// if (changedir)
	// {
	// ftp.setControlEncoding("GBK");
	// files = ftp.listFiles();
	// for (int i = 0; i < files.length; i++)
	// {
	// try
	// {
	// downloadFile(files[i], localBaseDir, remoteBaseDir);
	// }
	// catch (Exception e)
	// {
	// logger.error(e);
	// logger.error("<" + files[i].getName() + ">下载失败");
	// }
	// }
	// }
	// }
	// catch (Exception e)
	// {
	// logger.error(e);
	// logger.error("下载过程中出现异常");
	// }
	// }
	// else
	// {
	// logger.error("链接失败！");
	// }
	//
	// }

	/**
	 * 
	 * 下载FTP文件 当你需要下载FTP文件的时候，调用此方法 根据<b>获取的文件名，本地地址，远程地址</b>进行下载
	 * 
	 * @param ftpFile
	 * @param relativeLocalPath
	 * @param relativeRemotePath
	 */
	private static void downloadFile(FTPFile ftpFile, String relativeLocalPath, String relativeRemotePath) {
		if (ftpFile.isFile()) {
			if (ftpFile.getName().indexOf("?") == -1) {
				OutputStream outputStream = null;
				try {
					File locaFile = new File(relativeLocalPath + ftpFile.getName());
					// 判断文件是否存在，存在则返回
					if (locaFile.exists()) {
						return;
					} else {
						outputStream = new FileOutputStream(relativeLocalPath + ftpFile.getName());
						ftp.retrieveFile(ftpFile.getName(), outputStream);
						outputStream.flush();
						outputStream.close();
					}
				} catch (Exception e) {
					logger.error(e);
				} finally {
					try {
						if (outputStream != null) {
							outputStream.close();
						}
					} catch (IOException e) {
						logger.error("输出文件流异常");
					}
				}
			}
		} else {
			String newlocalRelatePath = relativeLocalPath + ftpFile.getName();
			String newRemote = new String(relativeRemotePath + ftpFile.getName().toString());
			File fl = new File(newlocalRelatePath);
			if (!fl.exists()) {
				fl.mkdirs();
			}
			try {
				newlocalRelatePath = newlocalRelatePath + '/';
				newRemote = newRemote + "/";
				String currentWorkDir = ftpFile.getName().toString();
				boolean changedir = ftp.changeWorkingDirectory(currentWorkDir);
				if (changedir) {
					FTPFile[] files = null;
					files = ftp.listFiles();
					for (int i = 0; i < files.length; i++) {
						downloadFile(files[i], newlocalRelatePath, newRemote);
					}
				}
				if (changedir) {
					ftp.changeToParentDirectory();
				}
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Ftp f = new Ftp();
		f.setIpAddr("114.55.138.73");
		f.setUserName("administrator");
		f.setPwd("ZYRScrljsyc060822");
		// f.setPath("D:/FTP/LocalUser/administrator/JAVA");
		FtpUtil.connectFtp(f);
//		try {
//			// File file = new File("F:/11.zip");
//			// File file = new File("D:\\FTP\\LocalUser\\administrator\\toclothjson");
////			File file = new File("C:\\APP_Server\\Suit.assetbundle");
////			FtpUtil.upload(file);// 把文件上传在ftp上
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		// FtpUtil.startDown(f, "e:/", "/xxtest");// 下载ftp文件测试

		// t.connect("/", "114.55.138.73", 21, "administrator", "ZYRScrljsyc060822");
		// File file = new File("F:/test.rar");

		// String fileUrl = "";
		//
//		 FileInputStream in=new FileInputStream(new File("C:\\APP_Server\\Suit.assetbundle"));
		 FileInputStream in=new FileInputStream(new File("C:\\APP_Server\\2.jpg"));
//		 moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "ftp://114.55.138.73/APP_Server/PC", "Suit.assetbundle", in);
//		 moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/PC", "Suit.assetbundle", in);
		 moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/PC", "2.jpg", in);
	}
}