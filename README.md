# Spring Boot Starter with Kotlin DSL Bean Definition

## Traditional Spring Bean Configuration
Override the `starter` default Bean with the `Configurtion` class.
```
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

```


## Kotlin Bean DSL
Override the `starter` default Bean with the `Kotlin Bean DSL`. 
```
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

```
