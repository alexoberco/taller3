package co.edu.javeriana.arqui.rest.entity

import jakarta.persistence.*

@Entity
@Table(name = "pacientes")
open class Paciente() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var nombre: String = ""

    @Column(nullable = false)
    var apellido: String = ""
}