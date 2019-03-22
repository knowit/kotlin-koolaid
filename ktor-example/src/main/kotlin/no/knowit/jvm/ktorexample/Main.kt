package no.knowit.jvm.ktorexample

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

const val publicPort = 8080

fun Application.main() {
    routing {
        get("/health") {
            call.respondText("OK")
        }

        get("/") {
            if (call.request.local.port == publicPort) {
                call.respondText("Connected to public API")
            } else {
                call.respondText("Connected to private API")
            }
        }
    }
}

fun main() {
    embeddedServer(
        Netty, // Embedded Netty server
        environment = applicationEngineEnvironment {}, // Can be configured
        configure = {
            responseWriteTimeoutSeconds = 10 // Timeout for requests (in seconds)
            shareWorkGroup = false // Reuse worker group for processing calls
        }).start()
}

