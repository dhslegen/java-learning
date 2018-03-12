package java实例与思考;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

/*【定义事件】关键是定义其中的source对象*/
class DemoEvent extends EventObject {
	private static final long serialVersionUID = -2440129584829446909L;

	public DemoEvent(Object source) {
		super(source);
	}
}

/* 【定义监听器接口】定义响应事件的方法名，并无函数体 */
interface IDemoEventListener extends EventListener {
	public void process(DemoEvent event);
}

/* 【定义第一个监听器】实现监听器接口的类，其中实现了方法 ，用于向监听器传递实例引用*/
class FirstEventListener implements IDemoEventListener {
	public void process(DemoEvent event) {
		System.out.println("First event listener process event...");
	}

}

/* 【定义第二个监听器】 */
class SecondEventListener implements IDemoEventListener {
	public void process(DemoEvent event) {
		System.out.println("Second event listener process event...");
	}

}

/* 【定义事件源】 */
class EventSource {
	private List<IDemoEventListener> listeners = new ArrayList<IDemoEventListener>();

	public EventSource() {
	}

	public void addDemoListener(IDemoEventListener demoListener) {
		listeners.add(demoListener);
	}//提供注册

	public void notifyDemoEvent() {

		for (IDemoEventListener eventListener : listeners) {
			DemoEvent demoEvent = new DemoEvent(this);
			eventListener.process(demoEvent);
		}
	}

}

/* 【测试】 */
public class 事件测试 {
	public static void main(String args[]) {

		// 定义事件源
		EventSource eventSource = new EventSource();

		// 定义并向事件源中注册事件监听器
		FirstEventListener firstEventListener = new FirstEventListener();
		eventSource.addDemoListener(firstEventListener);

		// 定义并向事件源中注册事件监听器
		SecondEventListener secondEventListener = new SecondEventListener();
		eventSource.addDemoListener(secondEventListener);

		// 事件通知
		eventSource.notifyDemoEvent();
	}
}
