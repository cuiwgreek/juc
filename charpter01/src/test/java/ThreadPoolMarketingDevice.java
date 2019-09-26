import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 营销取活动信息线程池
 *
 *
 */
public class ThreadPoolMarketingDevice {
	private static final int CORE_POOL_SIZE = 50;

	private static final int MAX_POOL_SIZE = 50;

	private static final long KEEP_ALIVE_TIME = 0;

	private static final int WORK_QUEUE_SIZE = 5000;

	
	@SuppressWarnings("rawtypes")
	private final static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
			CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
			new LinkedBlockingQueue(WORK_QUEUE_SIZE),
			new ThreadFactoryBuilder().setNameFormat("marketingDevicePool-%d").build(),
			new ThreadPoolExecutor.AbortPolicy());

//	 final static ExecutorService pool = Executors.newFixedThreadPool(20);

	public static ThreadPoolExecutor newInstance() {
		return threadPool;
	}

	public void execute(Runnable command) {

		threadPool.execute(command);
	}
	

}
