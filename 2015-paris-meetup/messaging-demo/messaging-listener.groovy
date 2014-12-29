package org.test

@EnableRabbit
@Log
class JmsSample {

    @RabbitListener(queues = 'smpQueue')
    def processMsg(String msg) {
        log.info("Received $msg")
    }
}