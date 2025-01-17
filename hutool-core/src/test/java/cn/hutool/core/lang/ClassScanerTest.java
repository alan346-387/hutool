package cn.hutool.core.lang;

import cn.hutool.core.util.ClassUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ClassScanerTest {

	@Test
	@Disabled
	public void scanTest() {
		ClassScanner scaner = new ClassScanner("cn.hutool.core.util", null);
		Set<Class<?>> set = scaner.scan();
		for (Class<?> clazz : set) {
			Console.log(clazz.getName());
		}
	}

	@Test
	@Disabled
	public void scanPackageBySuperTest(){
		// 扫描包，如果在classpath下找到，就不扫描JDK的jar了
		final Set<Class<?>> classes = ClassScanner.scanPackageBySuper(null, Iterable.class);
		Console.log(classes.size());
	}

	@Test
	@Disabled
	public void scanAllPackageBySuperTest(){
		// 扫描包，如果在classpath下找到，就不扫描JDK的jar了
		final Set<Class<?>> classes = ClassScanner.scanAllPackageBySuper(null, Iterable.class);
		Console.log(classes.size());
	}


	@Test
	@Disabled
	public void scanAllPackageIgnoreLoadErrorTest(){
		final ClassScanner classScanner = new ClassScanner(null, null);
		classScanner.setIgnoreLoadError(true);
		final Set<Class<?>> classes = classScanner.scan(false);
		Console.log(classes.size());
		Console.log(classScanner.getClassesOfLoadError());
	}

	@Test
	@Disabled
	public void scanJavaLang() {
		final Set<Class<?>> classes = ClassUtil.scanPackage("java.lang");
		for (final Class<?> aClass : classes) {
			Console.log(aClass.getName());
		}
	}
}
