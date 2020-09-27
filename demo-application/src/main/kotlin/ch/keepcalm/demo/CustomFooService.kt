package ch.keepcalm.demo

import foo.FooService

class CustomerFooService : FooService {
    override fun sayFoo() {
        println("::::::: Say hello from my [CustomerFooService] implementation :::::::")
    }
}
