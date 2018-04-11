package java实例与思考;

import java.io.Reader;
import java.util.Scanner;

import javax.net.ssl.SSLException;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

public class 线程 {
	@Test
	public void test子类重写创建线程() {
		/*
		 * 【线程定义】线程是thread类或其子类创建的对象，面向的是jvm的线程管理，当对象调用start（）函数时，线程对象添加到
		 * 线程管理的队列中，其后的调用工作有jvm自动完成。而轮到某线程使用CPU时，执行的是线程对象的run（）方法体，
		 * 类似test或者main的函数入口功能。
		 */
		/* 【线程执行体定义】【1.】子类重写run（）方法，添加具体内容 ,并声明线程对象 */
		class mythread01 extends Thread {
			public mythread01(String s) {
				setName(s);
			}

			int n = 0;

			public void run() {
				System.out.println("我是线程" + Thread.currentThread().getName());
				while (true) {
					n++;
					System.out.printf("\n%s", "我在左面");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		class mythread02 extends Thread {
			public mythread02(String s) {
				setName(s);
			}

			int n = 0;

			public void run() {
				System.out.println("我是线程" + Thread.currentThread().getName());
				while (true) {
					n++;
					System.out.printf("\n%40s", "我在右面");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		mythread01 mt1 = new mythread01("线程1");
		mythread02 mt = new mythread02("线程2");
		mt1.start();
		mt.start();
		while (true) {
			System.out.println(Thread.currentThread().getName() + "正在执行");
			if (mt1.n == 8 || mt.n == 8) {
				System.out.println("退出系统");
				System.exit(0);
			}
		} /*
			 * 【！注意】事实证明线程的分配根据系统的不同也有所不同，也不一定是平均分配，
			 * 因此不可以在主线程中判断其他线程的状态，因为有可能需要判断的时候并没有分配时间片。
			 * 可以看出线程的意义在于多任务，各线程根据优先级（setpriority（1-10））完成各自任务！
			 */
		/*
		 * 【线程执行体定义】【2.】线程对象的核心就是run（）执行体 {if (target != null) { target.run();
		 * }} ，由成员变量Runnable target，构造函数 this.target = target;可以看出另一种方法通过
		 * Thread(Runnable target)的构造函数传递一个实现了runable接口的对象，这样线程对象的
		 * run（）就变成了目标对象的run（）
		 */
	}

	@Test
	public void test实现runnable接口目标对象创建线程() {

		class left implements Runnable {
			int a = 0;

			public void run() {
				while (true) {
					a++;
					System.out.println("我在左面写字");
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		class right implements Runnable {
			int a = 0;

			public void run() {
				while (true) {
					a++;
					System.out.println("           我在右面写字");
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		left lf = new left();/*
								 * 注意不可放在类的前面，因为函数用时才加载代码字节，且是顺序执行， 而类是运行时就加载了！
								 */
		right rt = new right();
		Thread th01 = new Thread(lf);
		Thread th02 = new Thread(rt);
		th01.start();
		th02.start();
		while (true) {
			if (rt.a == 8 || rt.a == 8) {
				System.exit(0);
			}
		}
	}

	@Test
	public void test目标对象组合线程() {
		class bank implements Runnable {
			String s1, s2;
			Thread x, y;

			bank(String n1, String n2) {
				s1 = n1;
				s2 = n2;
				x = new Thread(this);
				y = new Thread(this);
			}

			public void run() {
				while (true) {
					if (Thread.currentThread().getName().equals(s1))

					{
						System.out.println("我是线程一");
					} else {
						System.out.println("我是线程二");
					}
					try

					{
						Thread.sleep(10);
					} catch (

					InterruptedException e)

					{
					}
				}
			}
		}

		String s1 = "出纳";
		String s2 = "会计";
		bank s = new bank(s1, s2);
		s.x.setName(s1);
		s.y.setName(s2);
		s.x.start();
		s.y.start();

	}

	@Test
	public void test同步方法() {
		/*
		 * 【同步方法】用synchronize修饰的方法，一般用在对数据进行修改的方法，特点：如果方法被某线程
		 * 调用，其他线程一旦调用这个方法就会引起阻塞，但是如果同步方法调用了wait（）方法，就是允许其
		 * 他线程调用该同步方法修改数据，调用完毕后要用notifyall（）方法通知所有在同步方法调用 wait（）而等待的线程。
		 * 【注意】等待不是阻塞，等待是因为数据不符合 主动地让位，其他线程完毕后要通
		 * 知它继续运行。而阻塞是被动的，同步方法只能被一个线程调用，其他线程被迫等待，不用
		 * notify通知，只要线程调用完毕，或调用等待了就可以自动被调用！
		 * 【原理】只有同步方法才有线程的竞争关系，线程的竞争体现在都用同步方法对同一目标对象的数据进行修改，
		 * 因此在目标对象同步方法中调用this.wait（）及this.notifyall（）（this可省略），就是暂停和通知继续某
		 * 线程对对象的操作（同步方法）。所以可以将两者放在同一个同步方法中（本例），也可以不放同一个在同步方 法中
		 * （下面的例子），但必须都在同步方法中，且应对应操作，即对【同一目标对象】的暂停和继续（下例中线程子类对象挂起
		 * 就是子类对象调用含notifyall的同步方法来恢复，类似的如果是目标对象的线程，也是通过目标对象的恢复函数）！
		 */
		class TicketSeller {
			int fiveNumber = 1, tenNumber = 0, twentyNumber = 0;

			public synchronized void restart() {
				notifyAll();
			}

			public synchronized void sellTicket(int receiveMoney) {
				String s = Thread.currentThread().getName();
				if (receiveMoney == 5) {
					fiveNumber += 1;
					System.out.println(s + "给售票员5元钱，售票员卖给" + s + "一张票，不必找赎");
				} else if (receiveMoney == 10) {
					while (fiveNumber < 1) {
						try {
							System.out.println(s + "给售票员10元钱");
							System.out.println("售票员请" + s + "靠边等一会");
							wait();
							System.out.println(s + "等待结束，继续买票");
						} catch (InterruptedException e) {
						}
					}
					fiveNumber -= 1;
					tenNumber += 1;
					System.out.println(s + "给售票员10元钱，售票员卖给" + s + "一张票，找赎5元");

				} else if (receiveMoney == 20) {
					while (fiveNumber < 1 || tenNumber < 1) {

						try {
							System.out.println(s + "给售票员20元钱");
							System.out.println("售票员请" + s + "靠边等一会");
							wait();
							System.out.println(s + "结束等待，继续买票");
						} catch (InterruptedException e) {
						}
					}
					fiveNumber -= 1;
					tenNumber -= 1;
					twentyNumber += 1;
					System.out.println(s + "给售票员20元钱，售票员卖给" + s + "一张票，找赎15元");
				}

			}
		}
		class Cinema implements Runnable {
			TicketSeller seller;
			String name1, name2, name3;

			public synchronized void restart() {
				notifyAll();
			}

			Cinema(String s1, String s2, String s3) {
				seller = new TicketSeller();
				name1 = s1;
				name2 = s2;
				name3 = s3;
			}

			public void run() {
				if (Thread.currentThread().getName().equals(name1)) {
					seller.sellTicket(20);
				} else if (Thread.currentThread().getName().equals(name2)) {
					seller.sellTicket(10);
				} else if (Thread.currentThread().getName().equals(name3)) {
					seller.sellTicket(5);
				}
			}
		}

		String s1 = "张明", s2 = "孙泽成", s3 = "赵本山";
		Cinema canema = new Cinema(s1, s2, s3);
		Thread zhang, sun, zhao;
		zhang = new Thread(canema);
		sun = new Thread(canema);
		zhao = new Thread(canema);
		zhang.setName(s1);
		sun.setName(s2);
		zhao.setName(s3);
		zhang.start();
		sun.start();
		zhao.start();
		int s4;
		Scanner sc = new Scanner(System.in);

		s4 = sc.nextInt();
		if (s4 == 0) {
			canema.seller.restart();
		}

	}

	@Test
	public void test挂起恢复() {
		class myth extends Thread {
			int a;

			public synchronized void hanup() {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			public synchronized void restart() {
				notifyAll();
			}

			@Override
			public void run() {
				if (Thread.currentThread().getName().equals("1")) {
					while (true) {
						a++;
						System.out.println(a);
						if (a == 3) {
							System.out.println("线程一睡了");
							hanup();
						}
						if (a == 8) {
							System.out.println("我醒来干活");
						}
					}
				}
			}
		}

		myth m = new myth();
		m.setName("1");
		m.start();
		Scanner sc02 = new Scanner(System.in);
		if (sc02.nextInt() == 1) {
			System.out.println("ceshi ");
			m.restart();
		} // 有关线程的在测试类里无法像在主程序里一样的效果

	}

	@Test
	public void test线程联合() {
		class xcdy implements Runnable {
			Thread t1 = new Thread(this);
			Thread t2 = new Thread(this);

			public void run() {
				if (Thread.currentThread() == t1) {
					System.out.println("我是t1，我在等待t2加入");
					t2.start();
					try {
						t2.join();// 必须等联合的线程全部运行完毕才能进行原线程；测试必须在main（）
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2结束。t1继续");
				} else if (Thread.currentThread() == t2) {
					System.out.println("我是t2，我正在运行，运行3秒");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		xcdy xc = new xcdy();
		xc.t1.start();
	}

	@Test
	public void test守护线程() {
		class shxc implements Runnable {
			Thread th1 = new Thread(this);
			Thread th2 = new Thread(this);

			public void run() {
				if (Thread.currentThread() == th1) {
					int i = 1;
					System.out.println("我是线程1");
					while (i <= 8) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("线程1执行第" + i + "次");
						i++;
					}
				} else if (Thread.currentThread() == th2) {
					System.out.println("我是线程2");
					int i = 1;
					while (true) {
						System.out.println("线程2执行第" + i + "次");
						i++;
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
		shxc s = new shxc();
		s.th1.start();
		s.th2.setDaemon(true);// 必须在start（）之前设置守护，则该线程在该程序中所有非守护（用户线程）完毕之后立即停止。
		// 一般用于不严格的工作，停止不会产生不良后果。
		s.th2.start();
	}

}
