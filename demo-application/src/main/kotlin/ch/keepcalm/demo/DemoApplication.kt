package ch.keepcalm.demo

import hello.HelloService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans
import java.util.logging.Logger

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args) {
        addInitializers(
            beans {
//                bean {
//                    // Replaces the default HelloService provided by [HelloServiceAutoConfiguration].
//                    HelloService {
//                        LoggerFactory.getLogger(DemoApplication::class.java).info("Hello from Logger!")
//                    }
//                }
                bean {
                    ref<HelloService>().sayHello()
                    ApplicationRunner { println(":::: ApplicationRunner :::: ") }
                }
            }
        )
    }
}

@Configuration
class HelloServiceConfig() {

    /**
     * Replaces the default HelloService provided by [HelloServiceAutoConfiguration].
     */
    @Bean
    fun customHelloServices(): HelloService? {
        // return object because HelloService is a interface
        return object : HelloService {
            override fun sayHello() {
                Logger.getAnonymousLogger().info("Hello from Logger!")
            }
        }
    }
}
