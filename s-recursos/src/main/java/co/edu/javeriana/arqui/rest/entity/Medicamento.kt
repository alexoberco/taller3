package co.edu.javeriana.arqui.rest.entity

import jakarta.persistence.*

@Entity
@Table(name = "medicamentos")
open class Medicamento() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var nombre: String = ""

    var laboratorio: String? = null
}