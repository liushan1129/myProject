package cn.larry.spring.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @EnableAutoConfiguration用于自动配置，会根据pom配置（实际上应该是根据具体的依赖）来判断这是一个什么应用，并创建相应的环境
 * 此处@EnableAutoConfiguration会判断这是一个web应用，所以会创建相应的web环境
 */
@Controller
@EnableAutoConfiguration
public class SampleController {
	
	/**
	 *@RequestMapping请求路径
	 *@ResponseBody作用:将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区
	 *等同于
	 *response.getWriter.write(JSONObject.fromObject(user).toString());
	 */
	@RequestMapping("/my")
	@ResponseBody
	String home(){
		return "Hello world";
	}
	
	public static void main(String[] args) {
		/**
		 * SpringApplication用于从main方法启动Spring应用的类。默认，会执行
		 * 1、vhuangjain一个合适的ApplicationContext实力（取决于classpath）
		 * 2、注册一个CommandLinePropertySource,以便将命令行参数作为Spring properties
		 * 3、刷新application context,加载所有单例beans
		 * 4、激活所有CommandLineRunner beans
		 */
		SpringApplication.run(SampleController.class, args);
	}
}
