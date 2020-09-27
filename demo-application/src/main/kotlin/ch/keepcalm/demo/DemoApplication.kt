package ch.keepcalm.demo

import bar.BarService
import foo.FooService
import hello.HelloService
import org.slf4j.LoggerFactory
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
                // Replaces the default FooService provided by starter.
                bean<CustomerFooService>("FooService")

                bean("customBarService") {
                    CustomerBarService()
                }

                bean {
                    ApplicationRunner {

                        ref<FooService>().sayFoo()
                        ref<HelloService>().sayHello()

                        println(":::: ApplicationRunner :::: ")

                        ref<BarService>().sayBye()

                    }
                }
            }
        )
    }
}
