package org.javachina.listener.view;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("一个session被创建了");
		event.getSession().setMaxInactiveInterval(10);
		//1.取得应用对象
		ServletContext sct = event.getSession().getServletContext();
		String count = (String)sct.getAttribute("count");
		if(count==null){
			sct.setAttribute("count", 1+"");
		}else{
			int countValue = Integer.parseInt(count);
			sct.setAttribute("count", (countValue+1)+"");
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("一个session被销毁");
		//1.取得应用对象
				ServletContext sct = event.getSession().getServletContext();
		//2.计算销毁session的数量
				String count = (String)sct.getAttribute("destoryCount");
				if(count==null){
					sct.setAttribute("destoryCount", 1+"");
				}else{
					int countValue = Integer.parseInt(count);
					sct.setAttribute("destoryCount", (countValue+1)+"");
				}
	}

}
