package com.shecc.eoms.core.common.utils;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * USER ray ray1192@163.com 
 * DATE 2014-5-16 下午08:48:20 
 * INFO com.shecc.eoms.core.common.utils Test2.java 
 * REMARK
 * 
 */
public class MsgUtil {

	/**
	 * @param args 电话号码
	 * @param args 内容
	 * @throws Exception
	 */
	public static void sendMsg(String  args1,String args2) throws Exception {

		//String hostName = "222.74.221.187";
		String hostName = "192.168.9.99";
		int portNum = 8899;
		String strMessage = "DATA:"+args1+"|"+args2;
		
		Socket socket = null;
		
		try {
			socket = new Socket(hostName, portNum);
			
			//System.out.println("#############---->发送报文=" + strMessage);
		
			OutputStream os = socket.getOutputStream();
			os.write(strMessage.toString().getBytes("GBK"));
			os.flush();
			
			
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
//			String serverMessage = "";
//			serverMessage = in.readLine();
//			System.out.println("#############---->返回报文:" + serverMessage);
//			in.close();
			
			os.close();
			socket.close();
			
			System.out.println("#############---->发送报文=" + strMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
