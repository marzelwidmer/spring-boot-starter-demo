package ch.keepcalm.demo

import bar.BarService

class CustomerBarService : BarService {

    override fun sayBye() {
        println("::::::: Say bye from my [CustomerBarService] implementation :::::::")
    }
}
