package ch.keepcalm.demo

import bar.BarService
import foo.FooService
import hello.HelloService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args) {
        addInitializers(
            beans {
                // Replaces the default FooService provided by starter.
                bean<CustomerFooService>("FooService")

                // Replaces the default BarService provided by starter.
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
