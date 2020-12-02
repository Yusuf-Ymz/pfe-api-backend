package be.ipl.pfe;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PfeApplication {

    public static void main(String[] args) {
        System.out.println(System.getenv("JDBC_DATABASE_URL"));
        SpringApplication.run(PfeApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
