package org.test

@Grab('spring-boot-starter-hornetq')

@EnableJms
@Log
class JmsSample {

    @JmsListener(destination = 'smpQueue')
    def processMsg(String msg) {
        log.info("Received $msg")
    }
}