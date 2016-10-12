//package com.shecc.eoms.core.common.utils;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.Socket;
//
//public class SocketClient {
//
//	private String hostName;
//	private int portNum;
//	private int delaySecond;
//
//	public SocketClient() {
//		this.hostName = "222.74.221.187";
//		this.portNum = 8899;
//		this.delaySecond = 50000;
//	}
//
//	public String sendMessage(String strMessage) {
//
//		String str = "";
//		String serverString = "";
//		Socket socket;
//		try {
//			socket = new Socket(hostName, portNum);
//
//			OutputStream os = socket.getOutputStream();
//			os.write(strMessage.toString().getBytes("GBK"));
//			os.flush();
//
//			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//			long sendTime = System.currentTimeMillis();
//			long receiveTime = System.currentTimeMillis();
//			boolean received = false; // 成功接收报文
//			boolean delayTooLong = false;
//			serverString = null;
//
//			while (!received && !delayTooLong) {
//				if (socket.getInputStream().available() > 0) {
//					char tagChar[];
//					tagChar = new char[1024];
//					int len;
//					String temp;
//					String rev = "";
//					if ((len = in.read(tagChar)) != -1) {
//						temp = new String(tagChar, 0, len);
//						rev += temp;
//						temp = null;
//					}
//					serverString = rev;
//				}
//				receiveTime = System.currentTimeMillis();
//				if (serverString != null)
//					received = true; 
//				if ((receiveTime - sendTime) > delaySecond)
//					delayTooLong = true;
//			}
//			in.close();
//			os.close();
//			socket.close();
//
//			str = serverString;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			socket = null;
//			str.trim();
//			System.out.println("--->返回的socket通讯字符串=" + str);
//
//			return str;
//		}
//
//	}
//
//	public static void main(String[] args) throws UnsupportedEncodingException {
//
//		SocketClient s = new SocketClient();
//
//		String str = "DATA:13917535340|哈哈哈哈哈";
//		System.out.println(s.sendMessage(str));
//
//	}
//
//}
