package com.chapuza.chapuzappandroid.features.appointments.presentation

enum class AppointmentStatus {
    Pending,
    Confirmed,
    Completed,
    Cancelled
}

data class Appointment(
    val id: Int,
    val service: String,
    val professionalName: String,
    val sector: String,
    val date: String,
    val price: Int,
    val status: AppointmentStatus,
    val isUpcoming: Boolean
)

val sampleAppointments: List<Appointment> = listOf(
    Appointment(
        id = 1,
        service = "Cambio de grifo",
        professionalName = "Javier Moreno",
        sector = "Fontanería",
        date = "Jue, 15 oct · 17:00",
        price = 45,
        status = AppointmentStatus.Confirmed,
        isUpcoming = true,
    ),
    Appointment(
        id = 2,
        service = "Montaje de armario",
        professionalName = "Pedro L.",
        sector = "Carpintería",
        date = "Sáb, 17 oct · 11:30",
        price = 60,
        status = AppointmentStatus.Pending,
        isUpcoming = true,
    ),
    Appointment(
        id = 3,
        service = "Revisión de enchufe",
        professionalName = "Laura R.",
        sector = "Electricidad",
        date = "Vie, 2 oct · 10:00",
        price = 40,
        status = AppointmentStatus.Completed,
        isUpcoming = false,
    ),
    Appointment(
        id = 4,
        service = "Pintura de salón",
        professionalName = "Marta S.",
        sector = "Pintura",
        date = "Lun, 21 sep · 09:00",
        price = 120,
        status = AppointmentStatus.Completed,
        isUpcoming = false,
    ),
    Appointment(
        id = 5,
        service = "Instalación de lámpara",
        professionalName = "Carlos G.",
        sector = "Electricidad",
        date = "Mié, 16 sep · 18:00",
        price = 35,
        status = AppointmentStatus.Cancelled,
        isUpcoming = false,
    ),
)