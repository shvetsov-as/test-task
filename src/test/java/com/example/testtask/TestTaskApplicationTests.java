package com.example.testtask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = {TestTaskApplicationTests.Initializer.class})
class TestTaskApplicationTests {

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=jdbc:postgresql://localhost:5440/postgres",
                    "spring.datasource.username=postgres",
                    "spring.datasource.password=postgres",
                    "jpa.hibernate.ddl-auto=create-drop"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    void contextLoads() {
        System.out.println("******* Context loaded *******");
    }

//    static {
//        Launcher launcher = LauncherFactory.create();
//        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
//                .request()
//                .selectors(DiscoverySelectors.selectPackage("com.example.testtask"))
//                .build();
//        launcher.execute(request);
//    }

}
