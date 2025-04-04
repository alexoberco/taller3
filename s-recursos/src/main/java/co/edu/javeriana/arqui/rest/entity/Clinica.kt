package co.edu.javeriana.arqui.rest.entity

import jakarta.persistence.*

@Entity
@Table(name = "clinicas")
open class Clinica() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var nombre: String = ""

    var direccion: String? = null
}