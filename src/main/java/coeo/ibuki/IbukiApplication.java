package coeo.ibuki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("coeo.ibuki.dao")
public class IbukiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbukiApplication.class, args);
	}

}
