package com.example

import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

fun main(args: Array<String>) {
	ApplicationContext.builder().banner(false)
		.eagerInitConfiguration(true)
		.eagerInitSingletons(true).build().start()
}

@Controller("/")
open class MyClass(private val baseConfiguration: BaseConfiguration) {
	init {
		println("Host: ${baseConfiguration.host}")
		println("Port: ${baseConfiguration.port}")
	}

	@Get
	fun test() {
		println("Host: ${baseConfiguration.host}")
		println("Port: ${baseConfiguration.port}")
	}
}

@ConfigurationProperties("base")
interface BaseConfiguration : Other {
	val port: Int
}

interface Other {
	val host: String
}
