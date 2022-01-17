package com.apollo.elegant.injection.dependency

/**
 * dependency injection
 * 依赖注入
 * Car ---> engine
 */
class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

fun main(){
    val engine = Engine()
    val car = Car(engine)
    car.start()
}