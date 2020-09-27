package ch.keepcalm.demo

import hello.HelloService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.logging.Logger


@Configuration
class CustomHelloServiceConfiguration() {

    /**
     * Replaces the default HelloService provided by [HelloServiceAutoConfiguration].
     */
    @Bean
    fun customHelloServices(): HelloService? {
        // return object because HelloService is a interface
        return object : HelloService {
            override fun sayHello() {
                Logger.getAnonymousLogger().info("---------------> CustomHelloService say hello from Logger!   <----------------")
            }
        }
    }
}
