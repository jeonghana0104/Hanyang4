package ac.kr.hanyang.backendEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Auditing 활성화
public class BackendExApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendExApplication.class, args);
	}

}
