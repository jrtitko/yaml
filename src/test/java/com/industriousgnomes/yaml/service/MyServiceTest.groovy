package com.industriousgnomes.yaml.service

import spock.lang.Specification
import spock.lang.Subject

class MyServiceTest extends Specification {

    @Subject
    MyService myService

    void setup() {
        myService = new MyService()
    }


}
