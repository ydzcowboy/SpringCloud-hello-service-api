package cowboy.hello_service_api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cowboy.hello_service_api.model.User;
@RequestMapping("/helloApi")
public interface HelloService {

	@RequestMapping("/hello")
	String hello();
	
	@RequestMapping("/hello1")
	String hello(@RequestParam("name") String name);// 必须指定@RequestParam 的value,不能少
	
	@GetMapping("/hello2")  //等同@RequestMapping 设置method 为GET
	String HelloById(@RequestParam(value="id",required=false) Integer id);

	@GetMapping(value="/hello3")
	User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	
	@RequestMapping(value="/hello4",method=RequestMethod.POST)
	String hello(@RequestBody User user);
	
	@GetMapping(value="/user/getByName/{name}")
	User getUserByName(@PathVariable("name") String name);

}
