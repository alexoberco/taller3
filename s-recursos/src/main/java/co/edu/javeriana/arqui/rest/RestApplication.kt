package co.edu.javeriana.arqui.rest

import jakarta.ws.rs.ApplicationPath
import jakarta.ws.rs.core.Application

@ApplicationPath("/api")
open class RestApplication : Application()
