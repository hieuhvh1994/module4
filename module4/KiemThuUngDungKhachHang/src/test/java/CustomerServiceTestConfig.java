import com.repository.CustomerRepository;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImplWithSpringData;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerServiceTestConfig {
    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImplWithSpringData();
    }
    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }
}