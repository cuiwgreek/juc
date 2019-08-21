/**
 * 适用于非静态方法：this.getClass().getName()
 * 适用于静态方法：Thread.currentThread().getStackTrace()[1].getClassName()
 */
public class MethodName {
	public static void main(String[] args) {
		MethodName methodName = new MethodName();
		String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("class name: " + clazz + " Method Name " + method);
		methodName.anotherMethod();
	}

	private void anotherMethod() {
		String clazz = this.getClass().getName();
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("class name: " + clazz + " Method Name " + method);
	}
}