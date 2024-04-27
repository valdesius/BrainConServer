package v.inc.brainconserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import v.inc.brainconserver.auth.AuthenticationService;
import v.inc.brainconserver.auth.RegisterRequest;

import static v.inc.brainconserver.domain.Role.MENTOR;
import static v.inc.brainconserver.domain.Role.STUDENT;

@SpringBootApplication
public class BrainConServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrainConServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Adqfqin")
                    .lastname("Adqwfwqmin")
                    .email("awfdmin@mail.com")
                    .password("pafwssword")
                    .role(MENTOR)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Awfwfdmin")
                    .lastname("Adwfmin")
                    .email("managewfr@mail.com")
                    .password("paswfwsword")
                    .role(STUDENT)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }

}
